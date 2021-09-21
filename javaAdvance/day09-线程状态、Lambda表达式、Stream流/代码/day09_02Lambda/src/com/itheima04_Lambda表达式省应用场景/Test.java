package com.itheima04_Lambda表达式省应用场景;

/*
应用场景
    用变量的形式
    在调用方法时，作为“实参”
    作为方法的“返回值”应用方式
需求:使用Runnable接口演示Lambda的三种应用场景。

*/
public class Test {
    public static void main(String[] args) {
        // 用变量的形式
        Runnable r = () -> { };//new Runnable(){}
        // 在调用方法时，作为“实参”
        showRunnable(() -> { });
        // 作为方法的“返回值”应用方式
        getRunnable();
    }

    public static void showRunnable(Runnable r) {
        r.run();
    }

    public static Runnable getRunnable() {
        return () -> { };
    }
}
