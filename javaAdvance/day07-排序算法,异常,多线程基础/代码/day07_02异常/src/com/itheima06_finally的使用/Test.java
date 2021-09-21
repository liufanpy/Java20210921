package com.itheima06_finally的使用;

/*
概述
    作用：在方法内，负责在try中代码出现异常时，一定会执行的代码，一般用于一些再出现问题后一定要关闭的资源处理
    处理方式：try中存在的异常产生的时候，系统会确保finally在jvm或该方法结束前，执行finally中的代码
    格式：try...[catch...catch...]finally...  【catch可以没有】
运行效果常见情况
    不try直接抛给虚拟机，程序结束，不执行finally中内容
    加上try，不加catch，finally能执行，但是程序不再继续运行
    加上try，并catch该异常，finally能执行，程序继续运行
需求：通过除数为0异常，演示finally的不同格式使用效果


 */
public class Test {
    public static void main(String[] args) {
        System.out.println("开始");
        // 不try直接抛给虚拟机，程序结束，不执行finally中内容
        // System.out.println(10 / 0);
        // 加上try，不加catch，finally能执行，但是程序不再继续运行
        // try {
        //     System.out.println(10 / 0);
        // } finally {
        //     System.out.println("try中的代码执行了");
        // }
        // 加上try，并catch该异常，finally能执行，程序继续运行
        try {
            System.out.println(10 / 0);
        } catch (ArithmeticException a) {
            System.out.println("异常被捕获了");
        } finally {
            System.out.println("try中的代码执行了");
        }
        System.out.println("结束");
    }
}
