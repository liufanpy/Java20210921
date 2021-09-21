package com.itheima.demo1_操作请求行;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author：pengzhilin
 * @Date: 2021/5/5 9:03
 */
@WebServlet("/ServletDemo1")
public class ServletDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //- getMethod();获取请求方式
        System.out.println("请求方式:"+request.getMethod());

        //- getRemoteAddr() ；获取客户机的IP地址(知道是谁请求的)
        System.out.println("客户机的IP地址:"+request.getRemoteAddr());

        //- getContextPath();获得当前应用工程名(部署的路径); 重点
        System.out.println("项目部署的路径:"+request.getContextPath());

        //- getRequestURI();获得请求地址，不带主机名
        System.out.println("请求地址，不带主机名:"+request.getRequestURI());

        //- getRequestURL()；获得请求地址，带主机名
        System.out.println("请求地址，带主机名:"+request.getRequestURL());

        //- getServerPort()；获得服务端的端口
        System.out.println("服务端的端口:"+request.getServerPort());

        //- getQueryString()；获的请求参数(get请求的,URL的?后面的. eg:username=zs&password=123456)
        System.out.println("请求参数:"+request.getQueryString());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
