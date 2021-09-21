package com.itheima.demo7_过滤非法字符案例;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @Author：pengzhilin
 * @Date: 2021/5/9 10:59
 */
@WebFilter("/bb/*")
public class FilterIllegal implements Filter {

    // 定义一个集合,用来存储所有的非法或者不文明字符
    private ArrayList<String> list = new ArrayList<>();

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //2.在doFilter方法中:
        //2.1 请求和响应对象进行转型
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        //2.2 使用请求对象获得提交的言论
        String message = request.getParameter("message");

        //2.3 判断提交的言论中是否包含不文明或者不合法的字符
        for (String msg : list) {
            //2.4 如果有,就替换这些字符,直接响应到页面,不放行
            if (message.contains(msg)) {
                message = message.replace(msg, "***");
                response.getWriter().println("您发表的言论是:" + message);
                return;// 结束方法--->不放行
            }
        }

        //2.5 如果没有,就直接放行到Servlet
        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {
        // 1.在init方法中读IllegalWords.txt文件中的数据到内存中
        BufferedReader br = null;
        try {
            // 1.1 获得关联IllegalWords.txt文件的输入流
            InputStream is = config.getServletContext().getResourceAsStream("IllegalWords.txt");

            // 1.2 把输入流转换为字符缓冲输入流
            InputStreamReader isr = new InputStreamReader(is, "utf-8");
            br = new BufferedReader(isr);

            // 1.3 定义String类型的变量,用来存储读取到的行数据
            String line = null;

            // 1.4 循环读取行数据
            while ((line = br.readLine()) != null) {
                // 1.5 在循环中,把读取到的行数据存储到集合中
                list.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 1.6 释放资源
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
