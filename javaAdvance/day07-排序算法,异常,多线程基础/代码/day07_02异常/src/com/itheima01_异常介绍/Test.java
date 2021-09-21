package com.itheima01_异常介绍;

/*
概述：
    异常指程序在执行过程中,出现的非正常情况
    java中默认将异常抛给jvm处理，而jvm处理的方式就是中断运行、
    在Java等面向对象的编程语言中，将异常问题，用指定的类来表示，并提供一定的处理办法行
异常体系
    Throwable 类是 Java 语言中所有错误或异常的超类，分类Error和Exception两个方向
    java.lang.Error   合理的应用程序不应该试图捕获的严重问题
        表示严重错误，无法处理的错误，只能事先避免，好比绝症。
        一旦出现，程序终止。
    java.lang.Exception，合理的应用程序想要捕获的条件
        表示异常，程序员可以修改代码解决，是必须要处理的。好比感冒、阑尾炎。
        一旦出现，由开发者决定如何处理
 	        给别人处理：将代码丢给调用者处理。
 	        自己处理：将问题截获，进行相应处理。
异常(Exception)分类
    编译时(checked)异常：
        编译时期,检查异常,如果有异常没处理,则编译失败。
        (如日期格式化异常)
    运行时(runtime)异常：
        编译时期,运行异常不会被编译器检测(不报错)，运行时期,检查异常.如果有异常没处理,则运行失败。
        (如数学异常)
需求:通过演示ArrayIndexOfBoundsException(数组索引越界异常)异常，分析异常的产生与传递过程

异常中的关键字
    throw：抛出		手动抛出异常类的实例化对象
    throws：声明		声明方法中存在的一个或多个异常类型
    try：尝试		代码块，内部包含可能存在问题的代码
    catch：捕捉		与try结合使用，捕捉try代码块中可能存在的某个异常
    finally：最终	与try结合使用，存放try中异常未被捕捉，程序跳转时，一定要执行的代码
 */
public class Test {
    public static void main(String[] args) {
        //定义数组
        int[] arr = new int[]{1, 2, 3};
        //使用获取数组指定位置元素的方法
        int ele = getElement(arr, 3);
    }

    public static int getElement(int[] arr, int index) {
        int num = arr[index];
        return num;
    }
}
