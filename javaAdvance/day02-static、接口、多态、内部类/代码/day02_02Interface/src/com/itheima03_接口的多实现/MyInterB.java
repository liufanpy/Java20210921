package com.itheima03_接口的多实现;

public interface MyInterB {
    //静态常量
    public static final int NUM = 999;

    //抽象方法
    public abstract void abstractMethod();

    //默认方法
    public default void defaultMethod() {
        System.out.println("B接口中的默认方法");
    }
    //静态方法
    public static void staticMethod() {
        System.out.println("B接口中的静态方法");
    }
}
