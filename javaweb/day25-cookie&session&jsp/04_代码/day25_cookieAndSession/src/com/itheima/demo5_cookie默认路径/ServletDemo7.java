package com.itheima.demo5_cookie默认路径;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author：pengzhilin
 * @Date: 2021/5/6 10:52
 */
@WebServlet("/aa/bb/ServletDemo7")
public class ServletDemo7 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 创建Cookie对象,并存值
        Cookie cCookie = new Cookie("ckey", "ccc");

        // 响应Cookie对象到浏览器
        response.addCookie(cCookie);

        // 响应数据到页面,证明执行了当前Servlet
        response.getWriter().print("ServletDemo7...");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
