package com.itheima02_接口的基本实现;

public interface MyInter {
    //静态常量
    public static final int NUM = 10;

    //抽象方法
    public abstract void abstractMethod();

    //默认方法
    public default void defaultMehtod() {
        System.out.println("接口中的默认方法");
    }
    public default void defaultMehtod2() {
        System.out.println("接口中的默认方法2");
    }
    //静态方法
    public static void staticMethod() {
        System.out.println("接口中的静态方法");
    }
}
