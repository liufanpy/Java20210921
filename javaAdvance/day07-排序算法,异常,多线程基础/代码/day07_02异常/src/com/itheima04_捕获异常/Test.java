package com.itheima04_捕获异常;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
作概述
    作用：处理异常的方式，在方法内，使用特殊格式检查可能出问题的代码，捕捉时机产生的异常，从而避免提交给虚拟机，并给出异常出现后的相应操作。
    处理方式：
        如果是运行时异常,可以使用捕获的方式处理异常
        如果是编译时异常，且没有以声明方式处理，就必须使用捕获方式，否则报错
    当异常出现，并被捕获，程序会继续向下执行，不会影响程序运行。
    格式
        格式1
            try{
                编写可能会出现异常的代码
            }catch(异常类型  e){
                处理异常的代码/记录日志/打印异常信息/继续抛出异常
            }
            ...
        格式2
            try{
            	编写可能会出现异常的代码
            }catch(异常类型1|异常类型2|...e){
            	处理异常的代码/记录日志/打印异常信息/继续抛出异常
            }
多个异常分别处理时常见方式
    多个异常分别try，分别捕获(处理)。
    多个异常一次try，分别捕获(处理)。
    多个异常一次try，一次捕获(处理)。
需求：通过除数为0异常和日期解析异常，演示try...catch的使用及常见异常捕获方式

 */
public class Test {
    public static void main(String[] args) {
        //捕获运行时异常
        method1();
        //捕获编译时异常
        method2();
        // 多个异常分别处理时常见方式
        method3();
    }

    public static void method3() {
        // 多个异常分别try，分别捕获(处理)。
        try {
            System.out.println(10 / 0);
        } catch (ArithmeticException e) {
            System.out.println("您输入的除数为0");
        }
        String time = "2020年01月01日";
        Date parse = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            parse = sdf.parse(time);
        } catch (ParseException p) {
            System.out.println("您的解析格式或提供的数据有误");
        }
        // 多个异常一次try，分别捕获(处理)。

        try {
            System.out.println(10 / 0);
            parse = sdf.parse(time);
        } catch (ArithmeticException e) {
            System.out.println("您输入的除数为0");
        } catch (ParseException p) {
            System.out.println("您的解析格式或提供的数据有误");
        }
        // 多个异常一次try，一次捕获(处理)。
        try {
            System.out.println(10 / 0);
            parse = sdf.parse(time);
        } catch (ArithmeticException | ParseException e) {
            System.out.println("出问题了");
        }
        try {
            System.out.println(10 / 0);
            parse = sdf.parse(time);
        } catch (Exception e) {
            System.out.println("出问题了");
        }
    }

    public static void method2() {
        String time = "2020年01月01日";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = null;
        try {
            parse = sdf.parse(time);
        } catch (ParseException p) {
            System.out.println("您的解析格式或提供的数据有误");
        }
        System.out.println(parse);
        System.out.println("结束");
    }

    public static void method1() {
        System.out.println("开始");
        try {
            System.out.println(10 / 0);
            System.out.println("over1");
        } catch (ArithmeticException e) {
            System.out.println("您输入的除数为0");
        }
        System.out.println("over");
    }
}
