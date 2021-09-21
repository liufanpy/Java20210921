package com.itheima.demo2_Servlet路径;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @Author：pengzhilin
 * @Date: 2021/5/3 14:59
 */
// 完全路径匹配--->一个Servlet可以有多个路径
@WebServlet(value = {"/demo7","/ServletDemo7"})
public class ServletDemo7 implements Servlet {

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        // 只要访问Servlet就会执行service方法
        System.out.println("活着:ServletDemo7...service");

    }


    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("出生:init...");
    }

    @Override
    public void destroy() {
        System.out.println("死亡:destroy...");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }



    @Override
    public String getServletInfo() {
        return null;
    }


}
