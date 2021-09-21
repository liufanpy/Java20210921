package com.itheima.job;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        //创建spring的容器
        new ClassPathXmlApplicationContext("applicationContext.xml");


        System.in.read();
    }
}
