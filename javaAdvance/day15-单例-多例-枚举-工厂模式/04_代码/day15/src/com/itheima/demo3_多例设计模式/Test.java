package com.itheima.demo3_多例设计模式;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/21 9:13
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(Person.getInstance());
        System.out.println(Person.getInstance());
        System.out.println(Person.getInstance());
        System.out.println(Person.getInstance());
        System.out.println(Person.getInstance());
        System.out.println(Person.getInstance());
        System.out.println(Person.getInstance());
        System.out.println(Person.getInstance());
        System.out.println(Person.getInstance());
    }
}
