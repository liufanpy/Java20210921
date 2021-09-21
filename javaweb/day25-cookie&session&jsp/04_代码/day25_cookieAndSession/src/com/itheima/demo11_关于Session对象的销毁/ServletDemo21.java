package com.itheima.demo11_关于Session对象的销毁;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @Author：pengzhilin
 * @Date: 2021/5/6 15:02
 */
@WebServlet("/ServletDemo21")
public class ServletDemo21 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 创建session对象存值
        HttpSession session = request.getSession();

        // 获取sessionId
        String id = session.getId();
        System.out.println("ServletDemo21...id:"+id);

        // 存值
        session.setAttribute("akey","aaa");


        // 手动响应sessionId
        Cookie cookie = new Cookie("JSESSIONID",id);
        // 设置有效时长
        cookie.setMaxAge(60*60);
        // 设置有效路径
        cookie.setPath(request.getContextPath());
        // 响应cookie
        response.addCookie(cookie);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
