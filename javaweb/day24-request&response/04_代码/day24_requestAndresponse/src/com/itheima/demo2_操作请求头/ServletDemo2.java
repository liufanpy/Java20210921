package com.itheima.demo2_操作请求头;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author：pengzhilin
 * @Date: 2021/5/5 9:44
 */
@WebServlet("/ServletDemo2")
public class ServletDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获得浏览器的版本信息
        String userAgent = request.getHeader("User-Agent");
        System.out.println("浏览器信息: " + userAgent);
        // 作用
        if (userAgent.contains("Firefox")){
            // 火狐的浏览器--->中文就需要进行Base64编码

        }else{
            // 其他浏览器----->URL编码(utf-8)
        }

        // 获得访问来源路径--->防盗链
        String referer = request.getHeader("Referer");
        System.out.println("获得访问来源路径:" + referer);

        // 作用
        if (referer.contains("baidu.com")) {
            // 给你图片
        } else {
            // 不给你图片
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
