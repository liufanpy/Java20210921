package com.itheima.demo2_懒汉式单列设计模式;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/21 8:54
 */
// 懒汉式单列设计模式
public class Person {
    // 概述:  懒汉单例设计模式就是调用getInstance()方法时对象才被创建，
    // 先不急着创建出对象，等要用的时候才创建对象。不着急，故称为“懒汉模式”。

    // 1.将构造方法私有化,防止外界通过new调用构造方法创建该类对象
    private Person(){

    }

    // 2.定义一个私有的静态成员变量,用来存一下该类唯一的对象
    private static Person p; // 初始值为null

    // 3.提供一个公共的静态方法给外界获取该类的唯一对象
    public static synchronized Person getInstance(){
        // 判断: 如果是第一次调用getInstance方法,就创建该类的唯一对象,否则就返回第一次创建的唯一对象
        if (p == null){
            // 说明是第一次调用getInstance()方法
            p = new Person();
        }
        return p;
    }

    public static void method(){}

}
