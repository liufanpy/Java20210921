package com.itheima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
    使用原始的Servlet Api来获取数据
 */
@Controller
public class Controller03 {


    @RequestMapping("/getParams")
    public String getParams(HttpServletRequest request , HttpServletResponse response , HttpSession session){

        //1. 获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println(username + "=" + password);

        //2. 返回cookie
        Cookie c = new Cookie("username", username);
        response.addCookie(c);

        //3. session存数据
        session.setAttribute("username",username);


        return "success";
    }
}
