package com.itheima.demo2_懒汉式单列设计模式;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/21 8:55
 */
public class Test {
    public static void main(String[] args) {
        Person.method();

        // 使用该类的唯一对象
        System.out.println(Person.getInstance());
        System.out.println(Person.getInstance());
        System.out.println(Person.getInstance());
        System.out.println(Person.getInstance());
    }
}
