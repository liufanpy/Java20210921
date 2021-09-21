package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controller01 {

    @RequestMapping("/show")
    public String show(){

        System.out.println("调用了Controller01 的 show方法~！");
        return "success";
    }
}
