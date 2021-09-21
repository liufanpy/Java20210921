package com.itheima.demo3_ServletConfig;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author：pengzhilin
 * @Date: 2021/5/3 15:38
 */
public class ServletDemo8 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        String value = servletConfig.getInitParameter("akey");
        System.out.println("akey对应的值:"+value);// aaa
        System.out.println(servletConfig.getServletContext());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("ServletDemo8...");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
