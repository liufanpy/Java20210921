package com.itheima02_多态时成员的访问特点;

public class Zi extends Fu {
    int num = 999;
    int num2 = 888;

    @Override
    public void method() {
        System.out.println("子类重写父类中的show方法");
    }

    public void show() {
        System.out.println("子类特有的show方法");
    }

    public static void staticMethod() {
        System.out.println("子类中的静态方法");
    }
}
