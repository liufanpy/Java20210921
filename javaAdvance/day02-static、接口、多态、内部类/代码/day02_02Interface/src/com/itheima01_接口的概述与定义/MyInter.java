package com.itheima01_接口的概述与定义;

public interface MyInter {
    //静态常量
    // int NUM =10;
    public static final int NUM = 10;
    //抽象方法
    // void abstractMethod();
    public abstract void abstractMethod();
    //默认方法
    // abstract void method(){
    //
    // }
    public default void method() {

    }
    //静态方法
    public static void staticMethod(){

    }
}
