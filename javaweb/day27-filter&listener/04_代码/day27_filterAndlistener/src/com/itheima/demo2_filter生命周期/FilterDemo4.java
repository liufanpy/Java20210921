package com.itheima.demo2_filter生命周期;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Author：pengzhilin
 * @Date: 2021/5/9 9:35
 */

public class FilterDemo4 implements Filter {

    public void init(FilterConfig config) throws ServletException {
        System.out.println("FilterDemo4...init...初始化...");
        // 获得该过滤器的配置参数
        String value = config.getInitParameter("akey");
        System.out.println("akey的值是:" + value);
    }


    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 过滤操作
        System.out.println("FilterDemo4...doFilter...过滤操作...");

        // 放行
        chain.doFilter(req, resp);
    }

    public void destroy() {
        System.out.println("FilterDemo4...destroy...销毁...");
    }

}
