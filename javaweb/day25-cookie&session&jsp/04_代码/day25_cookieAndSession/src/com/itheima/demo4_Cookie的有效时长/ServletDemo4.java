package com.itheima.demo4_Cookie的有效时长;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author：pengzhilin
 * @Date: 2021/5/6 10:27
 */
@WebServlet("/ServletDemo4")
public class ServletDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取所有的cookie对象,打印数据
        Cookie[] cookies = request.getCookies();
        if (cookies != null){
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName()+"="+cookie.getValue());
            }
        }

        // 创建Cookie对象
        Cookie aCookie = new Cookie("akey", "aaa");
        Cookie bCookie = new Cookie("bkey", "bbb");

        // 设置aCookie的有效时长,bCookie的有效时长为默认
        aCookie.setMaxAge(60*60*24*7);

        // 响应Cookie对象
        response.addCookie(aCookie);
        response.addCookie(bCookie);

        // 响应数据到页面,证明当前Servlet执行了
        response.getWriter().print("ServletDemo4....");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
