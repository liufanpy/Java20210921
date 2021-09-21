package com.tanhua.server.service;

import com.alibaba.fastjson.JSON;
import com.tanhua.commons.exception.TanHuaException;
import com.tanhua.domain.db.User;
import com.tanhua.domain.db.UserInfo;
import com.tanhua.domain.vo.ErrorResult;
import com.tanhua.domain.vo.UserInfoVo;
import com.tanhua.dubbo.api.db.UserInfoApi;
import com.tanhua.server.utils.GetAgeUtil;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * 业务处理类
 */
@Service
public class UserInfoService {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Reference
    private UserInfoApi userInfoApi;

    @Value("${tanhua.tokenKey}")
    private String tokenKey;

    @Autowired
    private UserService userService;

    /**
     * 查询用户信息
     */
    public UserInfoVo queryUserInfo(Long userID, Long huanxinID, String token) {
        //定义返回UserInfoVo
        UserInfoVo userInfoVo = new UserInfoVo();
        //a.判断Token是否存在(判断是否登录了)
        User user = userService.getUser(token);
        if(user == null){
            throw new TanHuaException(ErrorResult.loginFail());
        }
        Long userId = user.getId();
        //b.调用服务提供者：根据当前用户id查询tb_userInfo数据
        UserInfo userInfo = userInfoApi.queryUserInfo(userId);
        //c.得到UserInfo后将数据copy到UserInfoVO中
        BeanUtils.copyProperties(userInfo,userInfoVo);
        //单独设置年龄
        if(!StringUtils.isEmpty(userInfo.getAge())) {
            userInfoVo.setAge(String.valueOf(userInfo.getAge()));
        }
        else {
            //通过调用工具类 将生日转成年龄
            userInfoVo.setAge(String.valueOf(GetAgeUtil.getAge(userInfo.getBirthday())));
        }

        //d.返回UserInfoVo
        return userInfoVo;
    }

    /**
     * 更新用户信息
     */
    public void updateUserInfo(UserInfoVo userInfoVo, String token) {
        //a.判断Token是否存在(判断是否登录了)
        User user = userService.getUser(token);
        if(user == null){
            throw new TanHuaException(ErrorResult.loginFail());
        }
        Long userId = user.getId();
        //b.调用服务提供者：根据当前用户id更新tb_userInfo数据
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(userInfoVo,userInfo);
        if(!StringUtils.isEmpty(userInfoVo.getBirthday())){
            //当生日不为空  更新年龄
            //c.如果更新了生日，需要同步更新年龄字段
            userInfo.setAge(GetAgeUtil.getAge(userInfoVo.getBirthday()));
        }
        //最后设置当前用户id
        userInfo.setId(userId);
        userInfoApi.editUserInfo(userInfo);
    }
}
