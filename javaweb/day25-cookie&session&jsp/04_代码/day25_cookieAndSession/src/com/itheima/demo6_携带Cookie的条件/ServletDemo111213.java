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
 * @Date: 2021/5/6 11:09
 */
@WebServlet("/ServletDemo111213")
public class ServletDemo111213 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建Cookie对象
        Cookie bCookie = new Cookie("bkey", "bbb");

        // 设置Cookie的有效路径
        bCookie.setPath("/day25/aa");

        // 响应Cookie到浏览器
        response.addCookie(bCookie);

        // 3.响应数据到页面,证明该Servlet执行了
        response.getWriter().print("ServletDemo111213...");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
