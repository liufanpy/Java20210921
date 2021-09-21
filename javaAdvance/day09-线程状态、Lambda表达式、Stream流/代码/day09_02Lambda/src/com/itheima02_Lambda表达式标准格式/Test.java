package com.itheima02_Lambda表达式标准格式;

import java.util.*;

/*
使用前提
    必须具有接口，且要求接口中有且仅有一个抽象方法。
    有且仅有一个抽象方法的接口，称为函数式接口
    @FunctionalInterface注解:检查一个接口是否是函数式接口
格式:(参数类型 参数名)->{代码语句}
    ()内的语法与传统方法参数列表一致：无参数则留空，多个参数则用逗号分隔。
    ->是新引入的语法格式，代表指向动作。
    {}内的语法与传统方法体要求基本一致。
应用方式
    方式1“无参、无返回值”
    方式2“有参、有返回值”
需求：通过Lambda的标准格式完成Collections中的自定义排序功能与Runnable接口的使用。
*/
public class Test {
    public static void main(String[] args) {
        // “有参、有返回值”
        //定义一个集合
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 5, 2, 3, 8);
        // Comparator c = new Comparator<Integer>() {
        //     @Override
        //     public int compare(Integer o1, Integer o2) {
        //         return o1 - o2;
        //     }
        // };
        // Collections.sort(list, c);
        Collections.sort(list, (Integer i1, Integer i2) -> {
            return i1 - i2;
        });
        System.out.println(list);
        // “无参、无返回值”   匿名对象+Lambda表达式
        // new Thread(
        //         new Runnable() {
        //             @Override
        //             public void run() {
        //                 System.out.println("我是一个线程");
        //             }
        //         }
        // ).start();
        new Thread(() -> {
            System.out.println("我是一个线程");
        }).start();
    }
}
