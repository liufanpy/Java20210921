package com.itheima.servlet03;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
    所有与用户相关的操作都交给这个类来完成。
 */
public class UserServlet {


    /**
     * 注册的方法
     *   @RequestMapping的作用就是用于定义什么样的请求地址，能够执行这个register方法
     * @param request
     * @param response
     */
    @RequestMapping("/user/register")
    public void  register(HttpServletRequest request , HttpServletResponse response){
        System.out.println("执行了UserServlet的register方法~！");
    }


    public void login(HttpServletRequest request , HttpServletResponse response){
        System.out.println("执行了UserServlet的login方法~！");
    }
}
