package com.tanhua.server.service;

import com.alibaba.fastjson.JSON;
import com.tanhua.commons.exception.TanHuaException;
import com.tanhua.commons.templates.FaceTemplate;
import com.tanhua.commons.templates.OssTemplate;
import com.tanhua.commons.templates.SmsTemplate;
import com.tanhua.domain.db.User;
import com.tanhua.domain.db.UserInfo;
import com.tanhua.domain.vo.UserInfoVo;
import com.tanhua.dubbo.api.db.UserApi;
import com.tanhua.domain.vo.ErrorResult;
import com.tanhua.dubbo.api.db.UserInfoApi;
import com.tanhua.server.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 用户处理业务类
 * 有可能要调用多个xxxApi
 */
@Service
@Slf4j
public class UserService {

    @Reference
    private UserApi userApi;

    @Reference
    private UserInfoApi userInfoApi;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Value("${tanhua.redisValidateCodeKeyPrefix}")
    private String redisValidateCodeKeyPrefix;

    @Value("${tanhua.tokenKey}")
    private String tokenKey;

    @Autowired
    private SmsTemplate smsTemplate;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private OssTemplate ossTemplate;

    @Autowired
    private FaceTemplate faceTemplate;

    /**
     * 用户保存返回用户id
     * 传智健康Result:响应对象
     * 探花项目ResponseEntity:响应对象
     */
    public Long saveUser(User user) {
       return userApi.saveUser(user);
    }
    /**
     * 根据手机号码查询用户功能
     */
    public User findByMobile(String mobile) {
        return userApi.findByMobile(mobile);
    }

    /**
     * 登录注册-发送验证码
     */
    public void sendCode(String mobile) {
        log.debug("登录注册-发送验证码,手机号码****{}",mobile);
        //a.根据手机号查询redis验证码是否失效
        String redisCode = redisTemplate.opsForValue().get(redisValidateCodeKeyPrefix + mobile);
        //b.如果存在，直接返回错误信息，告知“验证码还未失效”
        if(!StringUtils.isEmpty(redisCode)){
            throw new TanHuaException(ErrorResult.duplicate());
        }
        //c.如果不存在，调用短信平台（阿里云）发送验证码短信
        String validateCode = "123456"; ///验证码写死了 为了方便后续测试
        /*String randomNum = RandomStringUtils.randomNumeric(6);
        validateCode =randomNum;*/
        if(false) {
            Map<String, String> stringStringMap = smsTemplate.sendValidateCode(mobile, validateCode);

            if (stringStringMap != null) {
                throw new TanHuaException(ErrorResult.error());
            }
        }
        log.debug("登录注册-发送验证码,手机号码****{}********{}",mobile,validateCode);
        //d.发送成功，将验证码写入redis
        redisTemplate.opsForValue().set(redisValidateCodeKeyPrefix + mobile,validateCode,5, TimeUnit.MINUTES);
    }

    /**
     * 登录注册
     */
    public Map loginReg(String mobile, String verificationCode) {
        //定义返回Map
        Map map = new HashMap();
        map.put("isNew",false);//默认登录
        //a.根据手机号作为key查询redis验证码是否存在
        String redisCode = redisTemplate.opsForValue().get(redisValidateCodeKeyPrefix + mobile);
        //b.验证码不存在，说明验证码失效了
        if(StringUtils.isEmpty(redisCode)){
            throw new TanHuaException(ErrorResult.loginError());
        }
        //c.验证码存在，校验验证码
        if(!redisCode.equals(verificationCode)){
            //d.校验验证码失败了，说明验证码错误
            throw new TanHuaException(ErrorResult.validateCodeError());
        }
        //f.验证码校验成功了，说明登录成功了
        ///g.调用服务提供者：根据手机号码查询tb_user表 看用户是否存在
        User user = userApi.findByMobile(mobile);
        //h.如果用户不存在，保存用户:服务提供者保存用户，则生成token存入redis
        if(user == null){///注册
            user = new User();
            user.setMobile(mobile);//手机号码
            user.setPassword(DigestUtils.md5Hex(mobile.substring(mobile.length()-6)));//可以随意设置
            Long userId = userApi.saveUser(user); //保存用户成功后，返回用户id
            map.put("isNew",true);
            //注册后将userId设置到user对象中
            user.setId(userId);
        }
         ///j.如果用户存在，则生成token存入redis
        String token = jwtUtils.createJWT(mobile,user.getId());
        map.put("token",token);
        String userStr = JSON.toJSONString(user);//将user对象转字符串
        redisTemplate.opsForValue().set(tokenKey+token,userStr,1,TimeUnit.DAYS);
        //k.将验证码删除
        redisTemplate.delete(redisValidateCodeKeyPrefix + mobile);
        return map;
    }

    /**
     * 新用户---1填写资料
     */
    public void loginReginfo(UserInfoVo userInfoVo, String token) {
        //判断Token是否存在（是否登录了？）
        User user = getUser(token);
        if(user == null){
            throw new TanHuaException(ErrorResult.loginFail());
        }
        Long userId = user.getId();
        //调用服务提供者保存用户个人信息
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(userInfoVo,userInfo);
        userInfo.setId(userId);//当前用户id
        //以前赋值方式
        //userInfo.setGender(userInfoVo.getGender());
        userInfoApi.saveUserInfo(userInfo);
    }

    /**
     * 获取用户对象公共方法
     * @param token
     * @return
     */
    public User getUser(String token) {
        String userStr = redisTemplate.opsForValue().get(tokenKey + token);
        if (StringUtils.isEmpty(userStr)) {
            return null;
        }
        //续期1天
        redisTemplate.expire(tokenKey + token,1,TimeUnit.DAYS);
        return JSON.parseObject(userStr, User.class);
    }

    /**
     * 新用户---2选取头像
     */
    public void loginReginfoHead(MultipartFile headPhoto, String token) {
        try {
            //a.判断Token是否存在（是否登录了？）
            User user = getUser(token);
            if(user == null){
                throw new TanHuaException(ErrorResult.loginFail());
            }
            Long userId = user.getId();
            //c.人脸识别 调用百度云组件
            boolean detect = faceTemplate.detect(headPhoto.getBytes());
            if(!detect){
                throw new TanHuaException(ErrorResult.faceError());
            }
            //d.上传头像 调用阿里云OSS组件
            String filename = headPhoto.getOriginalFilename();//获取原始文件名
            String avatar = ossTemplate.upload(filename, headPhoto.getInputStream());
            //f.更新用户头像
            UserInfo userInfo = new UserInfo();
            userInfo.setAvatar(avatar);
            userInfo.setId(userId);//根据用户id 更新头像
            userInfoApi.editUserInfo(userInfo);
        } catch (IOException e) {
            throw new TanHuaException(ErrorResult.error());
        }
    }
}
