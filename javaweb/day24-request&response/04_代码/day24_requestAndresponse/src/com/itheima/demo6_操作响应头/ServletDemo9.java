package com.itheima.demo6_操作响应头;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author：pengzhilin
 * @Date: 2021/5/5 11:53
 */
@WebServlet("/ServletDemo9")
public class ServletDemo9 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ServletDemo9...");
        // 重定向:方式一
        // response.setStatus(302);
        // response.setHeader("Location","http://www.itcast.cn");

        // 重定向: 方式二
        //response.sendRedirect("http://www.itcast.cn");

        // 重定向的路径: 相对路径
        //response.sendRedirect("index.html");
        // 重定向的路径: 绝对路径
        //response.sendRedirect("http://localhost:8080/day24/index.html");
        // 使用绝对路径访问内部项目中的资源可以省略http,ip地址,端口号
        response.sendRedirect("/day24/index.html");// 绝对路径

        // 重定向到WEB-INF下的资源
        //response.sendRedirect("http://localhost:8080/day24/WEB-INF/b.html");// 报错,不可以


        /*
            重定向和转发的区别:
                1.重定向的路径是会改变的,请求转发的路径是不会改变的
                2.重定向是2次请求,请求转发是1次请求
                3.重定向写绝对路径(也可以写相对路径),请求转发只能写相对路径
                4.重定向可以重定向到当前项目资源,也可以外部项目资源,请求转发只能转发到当前项目资源
                5.把数据存到request里面, 重定向不可用,请求转发可以用
                6.重定向不可以转发到WEB-INF下面的资源,请求转发可以转发到WEB-INF下面的资源
         */
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
