package com.itheima.demo9_session的执行原理;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author：pengzhilin
 * @Date: 2021/5/6 12:14
 */
@WebServlet("/ServletDemo17")
public class ServletDemo17 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获得session对象
        HttpSession session = request.getSession();

        // 2.获得sessionId
        String id = session.getId();
        System.out.println("sessionId:" + id);

        // 3.响应数据到页面,证明该Servlet执行了
        response.getWriter().print("ServletDemo17...");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
