package com.itheima05_字符流概述与字符输入流.p01字符流概述与字节读取字符数据问题;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
为什么有字符流
    一个中文字符可能占用多个字节存储。
    使用字节流读取文本文件时，如果遇到中文字符时，可能不会显示完整的字符。
分类
    字符输入流:以字符的形式从硬盘读取到内存中。读取的目的是为了拿到数据做某种事情，处理完这些数据将从内存小时。
    字符输出流:以字符的形式从内存写出到硬盘中。输出的目的是为了将数据持久保存，处理完这些数据将持久的被存储。
需求：演示字节流读取字符内容问题中。
 */
public class Test {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("day10_03IO流\\b2.txt");
        byte[] bys = new byte[2];
        int len = -1;
        len = fis.read(bys);
        System.out.println(new String(bys, 0, len));
        len = fis.read(bys);
        System.out.println(new String(bys, 0, len));
        len = fis.read(bys);
        System.out.println(new String(bys, 0, len));
        fis.close();
        FileOutputStream fos = new FileOutputStream("day10_03IO流\\a4.txt");
        byte[] bytes = "黑马程序员".getBytes();
        fos.write(bytes, 0, 2);
        fos.close();
    }
}
