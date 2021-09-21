package com.itheima.demo4_拦截方式;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author：pengzhilin
 * @Date: 2021/5/9 10:00
 */
@WebServlet("/ServletDemo")
public class ServletDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("执行ServletDemo...");

        // 转发到ServletDemo9
        //request.getRequestDispatcher("ServletDemo9").forward(request,response);

        // 重定向
        response.sendRedirect(request.getContextPath()+"/ServletDemo9");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
