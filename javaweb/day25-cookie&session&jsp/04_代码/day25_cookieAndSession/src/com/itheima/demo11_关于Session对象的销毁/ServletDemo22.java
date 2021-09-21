package com.itheima.demo11_关于Session对象的销毁;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author：pengzhilin
 * @Date: 2021/5/6 15:02
 */
@WebServlet("/ServletDemo22")
public class ServletDemo22 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取session对象
        HttpSession session = request.getSession();

        // 获取sessionId
        String id = session.getId();
        System.out.println("ServletDemo22...id:"+id);

        // 取值
        String value = (String) session.getAttribute("akey");
        response.getWriter().println("akey = "+ value);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
