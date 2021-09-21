package com.tanhua.server.controller;

import com.tanhua.domain.db.User;
import com.tanhua.server.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 登录控制层
 */
@RestController
@RequestMapping("/user")
@Slf4j //日志注解
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 用户保存返回用户id
     * 传智健康Result:响应对象
     * 探花项目ResponseEntity:响应对象
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity saveUser(@RequestBody User user) {
        Long userId = userService.saveUser(user);
        log.debug("用户保存成功了。。。。" + userId);
        return ResponseEntity.ok(userId);
    }

    /**
     * 根据手机号码查询用户功能
     */
    @RequestMapping(value = "/findByMobile", method = RequestMethod.GET)
    public ResponseEntity findByMobile(String mobile) {
        User user = userService.findByMobile(mobile);
        log.debug("根据手机号码查询用户。。。。" + user.toString());
        return ResponseEntity.ok(user);
    }

    /**
     * 登录注册-发送验证码
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity sendCode(@RequestBody Map<String, String> params) {
        String mobile = params.get("phone");
        userService.sendCode(mobile);
        return ResponseEntity.ok(null);
    }
}
