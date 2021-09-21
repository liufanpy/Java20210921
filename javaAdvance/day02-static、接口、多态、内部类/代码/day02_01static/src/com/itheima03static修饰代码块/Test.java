package com.itheima03static修饰代码块;

/*
static修饰代码块:称为静态代码块。位于成员位置，随着类的加载而执行。优先于main和构造方法
定义格式: static {}；
使用格式:无
需求：通过测试类，演示静态代码块执行


 */
public class Test {
    static {
        System.out.println("我是一个静态代码块");
    }

    public Test() {
        System.out.println("我是一个无参构造方法");
    }

    public static void main(String[] args) {
        System.out.println("我是main方法");
        new Test();//匿名对象
    }
}
