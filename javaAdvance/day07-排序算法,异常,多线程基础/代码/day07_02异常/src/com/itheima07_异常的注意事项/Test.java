package com.itheima07_异常的注意事项;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
try/catch/finally都不可以单独使用
运行时异常被抛出可以不处理（不捕获也不声明抛出），因为所有的方法默认抛出运行时异常
在try/catch后可以追加finally代码块，其中的代码一定会被执行，通常用于资源回收
方法重写时的注意事项:如果父类声明了某个异常或该异常的父类，子类重写该方法也可以声明，否则只能捕获。
    父类的方法抛出异常，子类覆盖(重写)父类方法时，只能抛出相同的异常或该异常子集
    父类的方法未抛出的异常，子类覆盖(重写)父类方法时，只能捕获处理，不能声明该异常
try...catch捕获多个异常时，前边的类不能是后边类的父类或同类
需求：演示异常处理常见注意事项

 */
public class Test {
    public static void main(String[] args) {
        // try/catch/finally都不可以单独使用
        // try{}
        System.out.println("--------");
        // catch (Exception e){}
        System.out.println("--------");
        // finally{}
        // 运行时异常被抛出可以不处理（不捕获也不声明抛出），因为所有的方法默认抛出运行时异常
        System.out.println(10 / 0);
        // 在try/catch后可以追加finally代码块，其中的代码一定会被执行，通常用于资源回收
        try {
            System.out.println(10 / 0);
        } finally {
            System.out.println("我的try执行了");
        }
        // try...catch捕获多个异常时，前边的类不能是后边类的父类或同类
        String time = "2020-12-12";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            System.out.println(10 / 0);
            Date parse = sdf.parse(time);
        } /*catch (Exception e) {

        } */catch (ArithmeticException a) {

        } catch (ParseException p) {

        }
    }
}
