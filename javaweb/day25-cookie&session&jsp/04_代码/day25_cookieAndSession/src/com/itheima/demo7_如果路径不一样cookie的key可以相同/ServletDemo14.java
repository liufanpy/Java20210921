package com.itheima.demo7_如果路径不一样cookie的key可以相同;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author：pengzhilin
 * @Date: 2021/5/6 11:17
 */
@WebServlet("/ServletDemo14")
public class ServletDemo14 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // 注意: 如果2个Cookie的路径一样,并且键名一样,那么后面的Cookie会覆盖前面的Cookie
        // 1.创建Cookie对象,并存储数据
        Cookie aCookie = new Cookie("akey", "aaa");
        Cookie bCookie = new Cookie("akey", "bbb");

        // 2.设置有效路径
        //aCookie.setPath("/day25");
        aCookie.setPath(request.getContextPath());//  /day25
        bCookie.setPath(request.getContextPath());//  /day25


        // 3.把Cookie对象响应给浏览器
        response.addCookie(aCookie);
        response.addCookie(bCookie);

        // 4.响应点数据到页面
        response.getWriter().print("ServletDemo14...");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
