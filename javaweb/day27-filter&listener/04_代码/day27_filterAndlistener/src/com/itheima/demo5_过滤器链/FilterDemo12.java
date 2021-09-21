package com.itheima.demo5_过滤器链;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Author：pengzhilin
 * @Date: 2021/5/9 10:24
 */

public class FilterDemo12 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 过滤
        System.out.println("来到了FilterDemo12过滤器...");

        // 过滤器链对象放行
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
