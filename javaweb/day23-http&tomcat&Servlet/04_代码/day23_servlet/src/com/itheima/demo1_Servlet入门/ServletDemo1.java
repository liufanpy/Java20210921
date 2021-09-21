package com.itheima.demo1_Servlet入门;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author：pengzhilin
 * @Date: 2021/5/3 12:17
 */
// 通过配置文件方式
public class ServletDemo1 implements Servlet {

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        // 每次访问Servlet都会执行Servlet里面的service方法
        // eg:每次访问ServletDemo1就会来到这里
        System.out.println("ServletDemo1...");
    }


    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }



    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
