package com.itheima03_字节输入流;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

/*
介绍
    java.io.InputStream抽象类表示字节输入流所有类的超类，规定了读取字节信息到内存的共性方法。
    java.io.FileInputStream 文件输入流，字节输入流常用子类，将数据读取到内存中。
构造方法
    FileInputStream(File file)：创建文件输入流以读取，由指定的File对象表示要连接的文件。
    FileInputStream(String name)：创建文件输入流以读取，由指定的文件路径名表示要连接的文件。
    注意:创建一个流对象时，必须传入文件路径，且该路径下，如果没有该文件,会抛出文件不存在异常。
常用方法:
    public void close() ：关闭此输入流并释放与此流相关联的任何系统资源。
    public int read()： 从输入流读取数据的下一个字节。
    public int read(byte[] b)： 从输入流中读取一些字节数，并将它们存储到字节数组b中节。
需求：演示字节输入流的基本使用(文件内容为“abcde”)。
 */
public class Test {
    public static void main(String[] args) throws IOException {
        // FileInputStream(File file)
        // File f1 = new File("day10_03IO流\\b1.txt");
        // FileInputStream fis = new FileInputStream(f1);//java.io.FileNotFoundException
        // FileInputStream(String name)
        FileInputStream fis = new FileInputStream("day10_03IO流\\b1.txt");
        // public int read()
        // System.out.println(fis.read());
        // System.out.println(fis.read());
        // System.out.println(fis.read());
        int by = -1;
        while ((by = fis.read()) != -1) {//read读到的数据不等于-1，返回true
            System.out.println(by);
        }
        fis.close();
        System.out.println("-------");
        FileInputStream fis2 = new FileInputStream("day10_03IO流\\b1.txt");
        // public int read(byte[] b)
        byte[] bys = new byte[2];
        // System.out.println(fis2.read(bys));
        // System.out.println(Arrays.toString(bys));
        // System.out.println(fis2.read(bys));
        // System.out.println(Arrays.toString(bys));
        // System.out.println(fis2.read(bys));
        // System.out.println(Arrays.toString(bys));
        // System.out.println(fis2.read(bys));
        // System.out.println(Arrays.toString(bys));
        int len=-1;
        while((len=fis2.read(bys))!=-1){//读到的结果不等于-1，代表读到了数据
            System.out.println(new String(bys,0,len));
        }
    }
}
