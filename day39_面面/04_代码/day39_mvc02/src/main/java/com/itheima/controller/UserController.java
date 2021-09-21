package com.itheima.controller;

import com.itheima.annotation.Controller;
import com.itheima.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
    所有有关用户操作的请求，都交给这个controller来完成
        1. 类上打注解 @Controller
        2. 方法上打注解 @RequestMappting
 */
@Controller
public class UserController {

    @RequestMapping("/user/register")
    public void register(HttpServletRequest req , HttpServletResponse resp){
        System.out.println("执行了UserController的register方法~！");
    }

    @RequestMapping("/user/login")
    public void login(HttpServletRequest req , HttpServletResponse resp){
        System.out.println("执行了UserController的login方法~！");
    }
}
