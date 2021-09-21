package com.itheima.web;

import cn.dsna.util.images.ValidateCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author：pengzhilin
 * @Date: 2021/5/6 15:57
 */
@WebServlet("/ServletCode")
public class ServletCode extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.创建验证码对象
        // 参数1: 宽度 参数2: 高度,  参数3: 验证码的字符数   参数4: 线条数
        ValidateCode validateCode = new ValidateCode(200,50,4,100);

        // 获得验证码的字符
        String code = validateCode.getCode();
        System.out.println("code:"+code);

        // 获得session对象
        HttpSession session = request.getSession();

        // 存储验证码
        session.setAttribute("checkCode",code);


        // 2.响应验证码到页面
        validateCode.write(response.getOutputStream());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
