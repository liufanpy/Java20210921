package com.itheima_02File类常用方法;

import java.io.File;
import java.io.IOException;

/*
常用方法:
    创建功能
        public boolean createNewFile() ：当且仅当具有该名称的文件尚不存在时，创建一个新的空文件，该文件的父级目录需要先存在。
        public boolean mkdir() ：创建由此File表示的目录，该目录的父级目录需要先存在。
        public boolean mkdirs() ：创建由此File表示的目录，包括任何必需但不存在的父目录。
    获取功能
        public String getAbsolutePath()  ：返回此File的绝对路径名字符串。
        public String getPath()  	：将此File转换为路径名字符串。
        public String getName()  	：返回由此File表示的文件或目录的名称。
        public long length()  		：返回由此File表示的文件的长度。
    判断功能
        public boolean exists() ：此File表示的文件或目录是否实际存在。
        public boolean isDirectory() ：此File表示的是否为目录。
        public boolean isFile() ：此File表示的是否为文件。
    删除功能
        public boolean delete() ：删除由此File表示的文件或目录。
需求：通过相对路径，演示File类中的方法。

 */
public class Test {
    public static void main(String[] args) throws IOException {
        //相对路径  项目\\day10_01File\\aaa\\a.txt
        //相对路径  项目\\day10_01File\\aaa
        //相对路径  项目\\day10_01File\\aaa\\bbb\\ccc

        // 创建功能
        // public boolean createNewFile()
        File f1 = new File("day10_01File\\aaa\\a.txt");
        System.out.println(f1.createNewFile());//系统找不到指定的路径
        // public boolean mkdir()
        File f2 = new File("day10_01File\\aaa");
        System.out.println(f2.mkdir());
        // public boolean mkdirs()
        File f3 = new File("day10_01File\\aaa\\bbb\\ccc");
        System.out.println(f3.mkdirs());
        System.out.println("--------");
        // 获取功能
        // public String getAbsolutePath()
        System.out.println(f1.getAbsolutePath());
        System.out.println(f2.getAbsolutePath());
        System.out.println(f3.getAbsolutePath());
        // public String getPath()
        System.out.println(f1.getPath());
        System.out.println(f2.getPath());
        System.out.println(f3.getPath());
        // public String getName()
        System.out.println(f1.getName());
        System.out.println(f2.getName());
        System.out.println(f3.getName());
        // public long length()
        System.out.println(f1.length());
        System.out.println(f2.length());
        System.out.println(f3.length());
        // 判断功能
        // public boolean exists()
        System.out.println(f1.exists());
        System.out.println(f2.exists());
        System.out.println(f3.exists());
        File f4 = new File("mmm");
        System.out.println(f4.exists());
        // public boolean isDirectory()
        System.out.println(f1.isDirectory());
        System.out.println(f2.isDirectory());
        System.out.println(f3.isDirectory());
        // public boolean isFile()
        System.out.println(f1.isFile());
        System.out.println(f2.isFile());
        System.out.println(f3.isFile());
        // public boolean delete()
        System.out.println(f1.delete());//true
        System.out.println(f2.delete());//false  想要删除某个文件夹，必须把文件夹下面的内容都删除
        System.out.println(f3.delete());//true
        File f5 = new File("mmm");
        System.out.println(f5.delete());//false
    }
}
