package com.itheima.proxy.cglib;

public class StarAdvice {

    public void before(){
        System.out.println("彩排一下~~");
    }
    public void after(){
        System.out.println("收钱~~");
    }
}
