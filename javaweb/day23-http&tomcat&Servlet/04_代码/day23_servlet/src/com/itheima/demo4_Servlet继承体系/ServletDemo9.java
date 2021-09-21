package com.itheima.demo4_Servlet继承体系;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @Author：pengzhilin
 * @Date: 2021/5/3 15:51
 */
@WebServlet("/demo9")
public class ServletDemo9 extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("ServletDemo9...");
    }
}
