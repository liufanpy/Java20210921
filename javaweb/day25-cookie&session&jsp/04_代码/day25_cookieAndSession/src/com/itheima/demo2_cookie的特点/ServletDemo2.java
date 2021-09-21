package com.itheima.demo2_cookie的特点;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @Author：pengzhilin
 * @Date: 2021/5/6 9:56
 */
@WebServlet("/ServletDemo2")
public class ServletDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取浏览器携带的所有cookie
        Cookie[] cookies = request.getCookies();

        // 循环遍历所有的cookie
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                String value = cookie.getValue();
                System.out.println("cookie的键:" + URLDecoder.decode(name,"utf-8") + ",cookie的值:" + value);
            }
        }

        // 1.创建Cookie对象,并存储数据
        Cookie aCookie = new Cookie(URLEncoder.encode("中国","utf-8"), "很棒");

        // 2.把Cookie对象响应给浏览器
        response.addCookie(aCookie);

        // 3.响应点数据到页面
        response.getWriter().print("ServletDemo2...");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
