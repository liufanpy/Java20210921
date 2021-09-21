package com.itheima.demo8_统计网站访问人数;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author：pengzhilin
 * @Date: 2021/5/3 16:55
 */
@WebServlet("/count")
public class CountServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        // 获得ServletContext对象,往对象中存储count=0
        getServletContext().setAttribute("count",0);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获得ServletContext中count的值
        int count = (int)getServletContext().getAttribute("count");

        // 2.count++
        count++;

        // 3.把count的值存回ServletContext中
        getServletContext().setAttribute("count",count);

        // 4.响应数据到页面
        response.getWriter().println("welcome....");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
