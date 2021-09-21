package com.tanhua.server.service;

import com.tanhua.commons.exception.TanHuaException;
import com.tanhua.commons.templates.SmsTemplate;
import com.tanhua.domain.db.User;
import com.tanhua.dubbo.api.db.UserApi;
import com.tanhua.domain.vo.ErrorResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Value("${tanhua.redisValidateCodeKeyPrefix}")
    private String redisValidateCodeKeyPrefix;

    @Autowired
    private SmsTemplate smsTemplate;

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
        Map<String, String> stringStringMap = smsTemplate.sendValidateCode(mobile, validateCode);

        if(stringStringMap != null){
            throw new TanHuaException(ErrorResult.error());
        }
        log.debug("登录注册-发送验证码,手机号码****{}********{}",mobile,validateCode);
        //d.发送成功，将验证码写入redis
        redisTemplate.opsForValue().set(redisValidateCodeKeyPrefix + mobile,validateCode,5, TimeUnit.MINUTES);
    }

}
