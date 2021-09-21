package com.itheima.servlet02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/*
    负责处理所有有关订单的请求
 */
@WebServlet("/order02")
public class OrderServlet extends BaseServlet {

    public void delete(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("执行了OrderServlet02的delete方法~！");
    }

    public void add(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("执行了OrderServlet02的add方法~！");
    }

    public void update(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("执行了OrderServlet02的update方法~！");

    }

}
