package com.itheima.demo1_Cookie的入门使用;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author：pengzhilin
 * @Date: 2021/5/6 9:41
 */
@WebServlet("/ServletDemo1")
public class ServletDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 获取浏览器携带的所有cookie
        Cookie[] cookies = request.getCookies();// aCookie(akey=aaa)  bCookie(akey=bbb)

        // 循环遍历所有的cookie
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                String value = cookie.getValue();
                System.out.println("cookie的键:" + name + ",cookie的值:" + value);
            }
        }

        // 1.创建Cookie对象,并存储数据
        Cookie aCookie = new Cookie("akey", "aaa");
        Cookie bCookie = new Cookie("bkey", "bbb");

        // 2.把Cookie对象响应给浏览器
        response.addCookie(aCookie);
        response.addCookie(bCookie);

        // 3.响应点数据到页面
        response.getWriter().print("ServletDemo1...");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
