package com.itheima.servlet;

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
@WebServlet("/order")
public class OrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            //1. 获取请求参数 method
            String methodStr = req.getParameter("method");

            //2. 找方法
            Method m = this.getClass().getMethod(methodStr , HttpServletRequest.class , HttpServletResponse.class);

            //3. 调用方法
            m.invoke( this ,req , resp );
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }


    public void delete(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("执行了OrderServlet的delete方法~！");
    }

    public void add(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("执行了OrderServlet的add方法~！");
    }

    public void update(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("执行了OrderServlet的update方法~！");

    }

}
