package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controller01 {

    NullPointerException n;

    @RequestMapping("/show")
    public void show(int num){
        System.out.println("执行了Controller01的show方法~...");
        if(1 == num){
            throw  new NullPointerException();
        }else if(2 == num){
            throw  new ClassCastException();
        }else{
            throw  new RuntimeException();
        }
    }
}
