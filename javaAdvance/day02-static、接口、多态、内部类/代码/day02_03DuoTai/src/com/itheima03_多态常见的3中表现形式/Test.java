package com.itheima03_多态常见的3中表现形式;

/*
多态的3中表现形式
    普通父类引用指向子类对象
    抽象父类引用指向子类对象
    父接口引用指向子类对象
需求：分别定义一个普通父类，抽象父类，父接口，并创建对应子类和实现类,演示3种多态
 */
public class Test {
    public static void main(String[] args) {
        // 普通父类引用指向子类对象
        Fu f = new Zi();
        f.method();
        //抽象父类引用指向子类对象
        AbstractFu af = new AbstractZi();
        af.method();
        // 父接口引用指向子类对象
        MyInter mi = new InterImpl();
        mi.method();
    }
}
