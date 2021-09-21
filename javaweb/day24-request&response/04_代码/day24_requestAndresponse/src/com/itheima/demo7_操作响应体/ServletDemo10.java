package com.itheima.demo7_操作响应体;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author：pengzhilin
 * @Date: 2021/5/5 12:11
 */
@WebServlet("/ServletDemo10")
public class ServletDemo10 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置浏览器打开方式
        response.setHeader("Content-type", "text/html;charset=utf-8");

        // 操作响应体--->字节流
        response.getOutputStream().write("ServletDemo10...".getBytes());
        response.getOutputStream().write("ServletDemo10操作响应体...".getBytes("utf-8"));

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
