package com.itheima.demo17_注解综合练习;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/18 15:47
 */
public class TestDemo {

    @MyTest
    public void test1(){
        System.out.println("test1...");
    }

    @MyTest
    public void test2(){
        System.out.println("test2...");
    }

    public void test3(){
        System.out.println("test3...");
    }

}
