package com.itheima.demo1_饿汉式单例设计模式;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/21 8:45
 */
// 饿汉式单例设计模式
public class Person {
    // 概述:  饿汉单例设计模式就是使用类的时候已经将对象创建完毕,
    // 不管以后会不会使用到该类的唯一对象，先创建了再说。很着急的样子，故被称为“饿汉模式”。

    // 1.将构造方法私有化,防止外界通过new直接创建该类的对象
    private Person(){

    }

    // 2.定义一个私有的成员变量,用来存储该类的唯一对象
    private static final Person P = new Person();

    // 3.提供一个公共的静态方法用来获取该类的唯一对象
    public static Person getInstance(){
        return P;
    }

    public static void method(){}

}
