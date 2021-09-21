package com.itheima.demo5_过滤器链;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Author：pengzhilin
 * @Date: 2021/5/9 10:20
 */
@WebFilter("/ServletDemo10")
public class FilterDemo10 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 过滤
        System.out.println("来到了FilterDemo10过滤器...");

        // 过滤器链对象放行
        chain.doFilter(req, resp);

        // 放行之后执行
        System.out.println("FilterDemo10过滤器放行之后执行的代码...");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
