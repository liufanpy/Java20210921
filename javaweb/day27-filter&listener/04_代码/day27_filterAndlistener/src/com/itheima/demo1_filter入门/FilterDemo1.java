package com.itheima.demo1_filter入门;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author：pengzhilin
 * @Date: 2021/5/9 9:04
 */
public class FilterDemo1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("来到了FilterDemo1过滤器...");
        // 没放行就到不了目标资源,只有放行了才会到目标资源执行(Servlet,jsp,html)
        filterChain.doFilter (servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
