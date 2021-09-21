package com.itheima_01File类概述与构造.p01File概述与构造方法;

import java.io.File;

/*
概述
    java.io.File 是文件和目录路径名的抽象表示，主要用于文件和目录的创建、查找和删除等操作。
常用构造方法
    public File(String pathname):通过将给定的路径名字符串转换为抽象路径名来创建新的 File实例。
    public File(String parent, String child):从父路径名字符串和子路径名字符串创建新的 File实例。
    public File(File parent, String child):从父抽象路径名和子路径名字符串创建新的 File实例。
需求：演示三种构造方法表示D盘aaa目录下的a.txt文件

 */
public class Test {
    public static void main(String[] args) {
        // public File(String pathname)
        File f1 = new File("D:\\temp");//\是转义字符
        System.out.println(f1);
        // public File(String parent, String child)
        String  f2="D:\\";
        File f3 = new File(f2, "temp");
        System.out.println(f3);
        // public File(File parent, String child)
        File f4 = new File("D:\\");
        File f5 = new File(f4, "temp");
        System.out.println(f5);
    }
}
