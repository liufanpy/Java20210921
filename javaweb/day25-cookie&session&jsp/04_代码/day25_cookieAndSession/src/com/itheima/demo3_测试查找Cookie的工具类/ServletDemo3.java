package com.itheima.demo3_测试查找Cookie的工具类;

import com.itheima.utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author：pengzhilin
 * @Date: 2021/5/6 10:12
 */
@WebServlet("/ServletDemo3")
public class ServletDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 需求: 查找名字为akey的cookie----->先访问ServletDemo1(写aCookie,bCookie到浏览器),然后访问ServletDemo3
        // 1.获得浏览器携带的所有Cookie
        Cookie[] cookies = request.getCookies();

        // 2.查找名字为akey的cookie
        Cookie aCookie = CookieUtils.getCookie("akey", cookies);

        // 3.打印cookie的名字和值
        System.out.println(aCookie.getName() + " = " + aCookie.getValue());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
