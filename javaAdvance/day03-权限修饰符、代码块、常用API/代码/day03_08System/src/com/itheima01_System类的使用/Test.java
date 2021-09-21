package com.itheima01_System类的使用;

/*
概述:
    java.lang.System 可以获取与系统相关的信息或系统级操作的工具类
    System类构造方法被私有修饰，不能创建对象，通过类名调用内部静态内容即可。
常用方法:
    public static void exit(int status)    终止当前运行的Java虚拟机，非零表示异常终止
    public static long currentTimeMillis() 返回当前时间(以毫秒为单位)
需求：演示System类中的常用方法

 */
public class Test {
    public static void main(String[] args) {
        // public static void exit(int status)
        System.out.println("开始");
        System.out.println("运行");
        // System.exit(-1);
        // while (true){
        //
        // }
        System.out.println("结束");
        // public static long currentTimeMillis()
        System.out.println(System.currentTimeMillis());

    }
}
