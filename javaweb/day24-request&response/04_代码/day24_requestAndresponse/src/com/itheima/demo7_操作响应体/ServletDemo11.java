package com.itheima.demo7_操作响应体;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author：pengzhilin
 * @Date: 2021/5/5 12:11
 */
@WebServlet("/ServletDemo11")
public class ServletDemo11 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 解决乱码问题(原因: 服务器的编码和浏览器的解码不一致导致)
        // 方式一:
        // 设置服务器编码的编码
        // response.setCharacterEncoding("utf-8");
        // 设置浏览器解码的编码
        // response.setHeader("Content-Type","text/html; charset=utf-8");

        // 方式二:
        //response.setContentType("text/html; charset=utf-8");

        // 1.处理乱码 ---->设置模板
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        // 操作响应体--->字符流
        response.getWriter().print("<h1>ServletDemo11...</h1>");
        response.getWriter().print("<font size='7' color='red'>ServletDemo11...</font>");
        response.getWriter().print("<h1>ServletDemo11操作响应体...</h1>");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
