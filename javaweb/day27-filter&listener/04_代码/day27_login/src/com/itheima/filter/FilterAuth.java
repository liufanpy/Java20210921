package com.itheima.filter;

import com.itheima.bean.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author：pengzhilin
 * @Date: 2021/5/9 16:13
 */
@WebFilter("/*")
public class FilterAuth implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //1.创建一个过滤器类实现过滤器接口
        //2.设置过滤器的路径为 /*
        //3.获取请求的urI路径--->浏览器请求的路径(拦截的路径)
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String requestURI = request.getRequestURI();

        //4.判断路径中是否包含(index,login,register,......)
        if (requestURI.contains("index") || requestURI.contains("login") || requestURI.contains("register")|| requestURI.contains("ServletCode")) {
            //4.1 如果包含,就直接放行
            chain.doFilter(request, response);
        } else {
            //4.2 如果不包含,就继续校验是否登录
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");

            if (user == null) {
                //4.2.1. 如果没有登录(session对象中的user是否空),就不放行.,重定向到登录页面
                response.sendRedirect("login.jsp");
                return;
            } else {
                //4.2.2  如果有登录(session对象中的user是否空),就放行
                chain.doFilter(request, response);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
