package com.itheima.demo1_饿汉式单例设计模式;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/21 8:45
 */
public class Test {
    public static void main(String[] args) {
        Person.method();// 就已经创建了Person类的唯一对象

        // 获取该类的唯一对象
        System.out.println(Person.getInstance());
        System.out.println(Person.getInstance());
        System.out.println(Person.getInstance());
        System.out.println(Person.getInstance());
        System.out.println(Person.getInstance());
    }
}
