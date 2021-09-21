package com.itheima.controller;

import com.itheima.entity.Result;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/getUsername")
    public Result getUsername(){

        //1. 问springsecurity要用户信息
        // 当我们登录成功了之后，springsecurity会在session里面保存我们的用户认证授权的信息。
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();


        //2. 封装数据返回
        Result result = null;
        if(user != null){ //有找到人
            result = new Result(true , "查询用户名成功" , user.getUsername());
        }else{
            result = new Result(false , "查询用户名失败" );
        }

        return result;
    }
}
