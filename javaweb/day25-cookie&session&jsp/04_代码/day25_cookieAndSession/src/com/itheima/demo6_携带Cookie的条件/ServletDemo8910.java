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
 * @Date: 2021/5/6 11:06
 */
@WebServlet("/ServletDemo8910")
public class ServletDemo8910 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建Cookie对象
        Cookie aCookie = new Cookie("akey", "aaa");

        // 设置Cookie的有效路径
        aCookie.setPath("/day25");

        // 响应Cookie到浏览器
        response.addCookie(aCookie);

        // 3.响应数据到页面,证明该Servlet执行了
        response.getWriter().print("ServletDemo8910...");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
