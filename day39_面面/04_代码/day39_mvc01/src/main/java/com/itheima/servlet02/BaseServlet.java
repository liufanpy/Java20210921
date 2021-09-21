package com.itheima.servlet02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/*
    这是所有servlet的父类，
        1. 用于存放所有子类的doGet和doPost代码
        2. BaseServlet必须是一个servlet，所以要继承HTTPServlet
        3. BaseServlet其实它只做一件事：
            收到请求之后，去调用子类的方法。
        4. 既然只做一件事情而已，那么有没有必要重写两个方法 doGet和doPost
            能否只重写一个方法即可？ 可以选择去重写 service 方法

        5. 有以下几个疑问：
            1. 方法里面的this是谁？
                A : BaseServlet  B :  可能是UserServlet|OrderServlet  C :  子类

                this :谁调用这个方法，那么this就是谁。肯定就是子类对象来调用这些方法

            2. BaseServlet也是一个Servlet，要不要加上@WebServlet("/base");
                不需要加上，因为BaseServlet仅仅只是一个父类，用来做一个请求方法的判定调用而已。
                    真正干活的是子类。


 */
public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

}
