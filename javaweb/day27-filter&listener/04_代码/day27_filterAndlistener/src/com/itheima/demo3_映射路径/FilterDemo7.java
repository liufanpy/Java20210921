package com.itheima.demo3_映射路径;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Author：pengzhilin
 * @Date: 2021/5/9 9:54
 */
@WebFilter("*.do")
public class FilterDemo7 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 过滤
        System.out.println("来到了FilterDemo7过滤器...");

        // 放行
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
