package com.itheima.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*
    返回数据
 */
@Controller
public class Controller04 {

    /*
        返回字符串： 使用response对象写出去
     */
    @RequestMapping("/returnStr01")
    public void returnStr01(HttpServletResponse resp) throws IOException {
        resp.getWriter().write("str01...");
    }


    /*
        返回字符串： 使用@ResponseBody，打注解，告诉springmvc，方法的返回值是字符串，不是页面
     */
    @ResponseBody
    @RequestMapping("/returnStr02")
    public String returnStr02()  {
       return  "str02...";
    }

    //返回中文 ： 打算采用springmvc配置转换器的写法
    @ResponseBody
    @RequestMapping("/returnStr03")
    public String returnStr03()  {
        return  "这是返回的中文: returnStr03";
    }

    //返回中文 ： 使用简单的写法， 使用 produces 属性来配置响应数据的编码。
    @ResponseBody
    @RequestMapping(value = "/returnStr04" , produces = "text/html;charset=utf-8")
    public String returnStr04()  {
        return  "这是返回的中文: returnStr04";
    }



    /*
        返回json字符串
            1. 自己转化成json字符串，然后返回
     */
    @ResponseBody
    @RequestMapping("/returnJson01")
    public String returnJson01() throws JsonProcessingException {
        System.out.println("returnJson01...");

        //1. 创建对象
        User user = new User("admin" , "123456");

        //2. 转化成json
        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(user);

        //3. 返回json
        return json;
    }



    /*
        返回json字符串
            1. 不需要我们自己转化对象成json字符串。
            2. 只需要返回对象即可。
     */
    @ResponseBody
    @RequestMapping("/returnJson02")
    public User returnJson02() throws JsonProcessingException {
        System.out.println("returnJson02...");

        //1. 创建对象
        User user = new User("管理员" , "123456");

        //2. 直接返回2
        return user;
    }


}
