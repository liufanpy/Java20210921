package com.itheima.demo5_ServletContext域对象;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author：pengzhilin
 * @Date: 2021/5/3 16:22
 */
@WebServlet("/demo14")
public class ServletDemo14 extends HttpServlet {
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            System.out.println("ServletDemo14....");
            // 1.获得ServletContext域对象
            ServletContext servletContext = getServletContext();

            // 2.通过ServletContext域对象删除数据
            servletContext.removeAttribute("bkey");
        }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
