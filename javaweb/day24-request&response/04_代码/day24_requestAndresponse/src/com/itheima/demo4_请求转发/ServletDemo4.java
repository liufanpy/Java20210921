package com.itheima.demo4_请求转发;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author：pengzhilin
 * @Date: 2021/5/5 10:59
 */
@WebServlet("/ServletDemo4")
public class ServletDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("李四:张三你等会,我的钱在银行,我去给你取...");
        // 找李四的媳妇
        // 转发的路径: 写相对路径,不要写绝对路径
        //request.getRequestDispatcher("http://localhost:8080/day24/ServletDemo5").forward(request,response);// 报错
        //request.getRequestDispatcher("ServletDemo5").forward(request,response);// 正确

        // 请求转发的路径只能写相对路径,不能写绝对路径
        // 请求转发地址栏不会变
        // 请求转发只有1次请求
        // 请求转发只能转发到本项目中的资源,不能转发到外部项目资源
        //request.getRequestDispatcher("http://www.baidu.com").forward(request,response);// 报错
        request.getRequestDispatcher("aa/a.html").forward(request,response);// 正确

        // 请求转发到WEB-INF路径下的资源
//        request.getRequestDispatcher("WEB-INF/b.html").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
