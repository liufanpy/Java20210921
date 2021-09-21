package com.itheima.demo7_ServletContext的其他作用;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author：pengzhilin
 * @Date: 2021/5/3 16:26
 */
@WebServlet("/demo15")
public class ServletDemo15 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获得文件MIME类型
        String fileName1 = "a.mp3";
        String fileName2 = "b.jpg";
        // getMimeType(String file)
        String f1MimeType = getServletContext().getMimeType(fileName1);
        String f2MimeType = getServletContext().getMimeType(fileName2);
        System.out.println("a.mp3文件的mime类型:"+f1MimeType);
        System.out.println("b.jpg文件的mime类型:"+f2MimeType);

        // 获得全局初始化参数: String getInitParameter(String name) ;
        System.out.println(getServletContext().getInitParameter("ckey"));// ccc

        // 获取web资源路径
        // web下面的itheima.txt的路径:
        // 错误绝对路径: G:\szitheima113\day23_servlet\web\itheima.txt
        // 正确绝对路径: G:\szitheima113\out\artifacts\day23_servlet_war_exploded\itheima.txt
        // - String  getRealPath(String path);根据资源名称得到资源的绝对路径.
        // getRealPath方法的路径已经到了web目录
        String realPath = getServletContext().getRealPath("itheima.txt");
        System.out.println("绝对路径:"+realPath);

        //- getResourceAsStream(String path) ;返回制定路径文件的流
        // getResourceAsStream方法的路径已经到了web目录
        InputStream is = getServletContext().getResourceAsStream("itheima.txt");
        System.out.println(is.read());// 97
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
