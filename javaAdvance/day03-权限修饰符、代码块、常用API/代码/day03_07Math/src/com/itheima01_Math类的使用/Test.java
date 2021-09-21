package com.itheima01_Math类的使用;

/*
概述:
    java.lang.Math: 含执行基本数字运算的方法的工具类。
    Math类构造方法被私有修饰，不能创建对象。
    构造方法被私有修饰，不能创建对象，通过类名调用内部静态内容即可。
常用方法:
    public static int abs(int a)                   获取参数a的绝对值
    public static double ceil(double a)            向上取整
    public static double floor(double a)           向下取整
    public static double pow(double a, double b)   获取a的b次幂
    public static long round(double a)             四舍五入取整
    public static int max(int a, int b)            返回两个 int 值中较大的一个
    public static int min(int a, int b)            返回两个 int 值中较小的一个
需求：演示Math类中的常用方法

 */
public class Test {
    public static void main(String[] args) {
        // public static int abs(int a)
        System.out.println("5的绝对值:" + Math.abs(5));
        System.out.println("-5的绝对值:" + Math.abs(-5));
        // public static double ceil(double a)
        System.out.println("2.3向上取整:" + Math.ceil(2.3));
        System.out.println("2.7向上取整:" + Math.ceil(2.7));
        // public static double floor(double a)
        System.out.println("2.3向下取整:" + Math.floor(2.3));
        System.out.println("2.7向下取整:" + Math.floor(2.7));
        // public static double pow(double a, double b)
        System.out.println("2的3次方:" + Math.pow(2, 3));
        // public static long round(double a)
        System.out.println("2.3四舍五入:" + Math.round(2.3));
        System.out.println("2.7四舍五入:" + Math.round(2.7));
        // public static int max(int a, int b)
        System.out.println("10和20的较大值" + Math.max(10, 20));
        // public static int min(int a, int b)
        System.out.println("10和20的较小值" + Math.min(10, 20));
    }
}
