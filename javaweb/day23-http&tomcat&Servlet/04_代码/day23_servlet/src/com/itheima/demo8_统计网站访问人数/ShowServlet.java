package com.itheima.demo8_统计网站访问人数;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author：pengzhilin
 * @Date: 2021/5/3 16:58
 */
@WebServlet("/show")
public class ShowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 0.处理响应乱码
        response.setContentType("text/html;charset=utf-8");

        // 1.获得ServletContext中的count的值
        int count = (int) getServletContext().getAttribute("count");

        // 2.响应count的值到页面上
        //System.out.println(count);
        response.getWriter().println("这是第"+count+"位用户");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
