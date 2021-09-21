package com.itheima02_字节流概述与字节输出流.p01字节流概述与字节流使用;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
一切皆字节:
    一切文件数据(文本、图片、视频等)存储时，都是以一个个字节(二进制)形式保存，传输时也一样
    字节流可以传输任意文件数据
    无论使用什么样的流对象，底层传输的始终为二进制数据
分类:
    字节输入流:以字节的形式从硬盘读取到内存中。读取的目的是为了拿到数据做某种事情，处理完这些数据将从内存消失。
    字节输出流:以字节的形式从内存写出到硬盘中。输出的目的是为了将数据持久保存，处理完这些数据将持久的被存储。
字节输出流:
    介绍:
        java.io.OutputStream 抽象类表示字节输出流所有类的超类,规定了字节信息写到目的地的共性方法。
        java.io.FileOutputStream 文件输出流，字节输出流常用子类，用于将数据写出到文件。
    构造方法:
        public FileOutputStream(File file)：创建文件输出流以写入由指定的 File对象表示的文件。
        public FileOutputStream(String name)： 创建文件输出流以指定的名称写入文件。
        注意:使用输出流创建对象，如果该文件不存在，会自动创建。
    常用方法:
        public void close()：关闭此输出流并释放与此流相关联的任何系统资源。
        public void flush()：刷新此输出流并强制任何缓冲的输出字节被写出。
        public void write(int b)：将指定的字节写入此输出流。
        public void write(byte[] b)：将 b.length字节从指定的字节数组写入此输出流。
        public void write(byte[] b, int off, int len)：从指定字节数组,按照偏移量写入len个字节。

需求：演示字节输出流的基本使用。
 */
public class Test {
    public static void main(String[] args) throws IOException {
        //public FileOutputStream(File file)
        //绝对路径
        // File f1=new File("E:\\1.forteach\\javase2_113code\\day10_03IO流\\a1.txt");
        //相对路径
        File f1 = new File("day10_03IO流\\a1.txt");
        FileOutputStream fos1 = new FileOutputStream(f1);
        // public FileOutputStream(String name)
        //绝对路径
        // String f1 ="E:\\1.forteach\\javase2_113code\\day10_03IO流\\a1.txt";
        //相对路径
        // String f1 ="day10_03IO流\\a1.txt";
        // FileOutputStream fos1 = new FileOutputStream(f1);
        // public void write(int b)
        fos1.write(97);
        // public void write(byte[] b)
        byte[] bys = {98, 99, 100, 101};
        fos1.write(bys);
        // public void write(byte[] b, int off, int len)
        byte[] bys2 = {102, 103, 104, 105};
        fos1.write(bys2, 0, 2);//包左不包右
        // public void flush()
        // fos1.flush();
        // public void close()
        fos1.close();//关闭并刷新
    }
}
