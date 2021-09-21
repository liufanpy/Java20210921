package com.itheima.job;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class MainDemo {
    public static void main(String[] args) throws IOException {
        new ClassPathXmlApplicationContext("applicationContext-job.xml");
        System.in.read();
    }
}
