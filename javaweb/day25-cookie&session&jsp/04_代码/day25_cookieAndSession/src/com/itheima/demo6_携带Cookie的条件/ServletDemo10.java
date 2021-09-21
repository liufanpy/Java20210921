package com.itheima.demo6_携带Cookie的条件;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author：pengzhilin
 * @Date: 2021/5/6 11:04
 */
@WebServlet("/aa/bb/ServletDemo10")
public class ServletDemo10 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取浏览器携带的Cookie
        Cookie[] cookies = request.getCookies();

        // 2.循环遍历所有的Cookie
        if (cookies != null){
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName()+" = "+cookie.getValue());
            }
        }

        // 3.响应数据到页面,证明该Servlet执行了
        response.getWriter().print("ServletDemo10...");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
