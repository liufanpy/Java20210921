package com.itheima.servlet02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/*
    负责处理所有有关用户的请求
 */
@WebServlet("/user02")
public class UserServlet extends BaseServlet {

    public void delete(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("执行了UserServlet02的delete方法~！");
    }

    public void register(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("执行了UserServlet02的register方法~！");
    }

    public void login(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("执行了UserServlet02的login方法~！");

    }

}
