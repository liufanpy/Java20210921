package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
    跳转页面|返回视图
 */
@Controller
public class Controller02 {

    //逻辑视图返回
    @RequestMapping("/page01")
    public String page01(){
        System.out.println("page01...");
        return "success";
    }

    //物理视图返回 , 一旦配置了视图解析器，那么这种跳转会受影响
    @RequestMapping("/page02")
    public String page02(){
        System.out.println("page02...");
        return "/success.jsp";
    }

    /*
        1. 显式的告诉springmvc，采用请求转发跳转 带上前缀  forward:
        2. 不受视图解析器的影响
        3. 必须要写完整的地址路径
     */
    @RequestMapping("/page03")
    public String page03(){
        System.out.println("page03...");
        return "forward:/success.jsp";
    }

    /*
        1. 显式的告诉springmvc，采用重定向跳转  带上前缀  redirect:
        2. 不受视图解析器的影响
        3. 必须要写完整的地址路径
     */
    @RequestMapping("/page04")
    public String page04(){
        System.out.println("page04...");
        return "redirect:/success.jsp";
    }
}
