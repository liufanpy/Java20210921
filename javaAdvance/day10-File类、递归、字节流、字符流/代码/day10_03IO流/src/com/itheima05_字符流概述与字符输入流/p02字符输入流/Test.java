package com.itheima05_字符流概述与字符输入流.p02字符输入流;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Function;

/*
介绍
    java.io.Reader抽象类表示字符输入流的所有类的超类，规定了读取字符信息到内存中的共性方法。
    java.io.FileReader 文件输入流，字符输入流常用子类，(使用系统默认的字符编码和默认字节缓冲区)将数据读取到内存中。
构造方法
    FileReader(File file):创建一个新的 FileReader ，给定要读取的File对象。
    FileReader(String fileName):创建一个新的 FileReader ，给定要读取的文件的名称。
常用方法
    public void close():关闭此流并释放与此流相关联的任何系统资源。
    public int read():从输入流读取一个字符。
    public int read(char[] cbuf):从输入流中读取一些字符，并将它们存储到字符数组 cbuf中 。
需求：演示字符输入流基本使用(文件内容为“你好啊”)
*/
public class Test {
    public static void main(String[] args) throws IOException {
        // FileReader(File file)
        // File f1 = new File("day10_03IO流\\b3.txt");
        // FileReader fr = new FileReader(f1);
        // FileReader(String fileName)
        FileReader fr = new FileReader("day10_03IO流\\b3.txt");
        // public int read()
        // int ch1 = fr.read();
        // System.out.println(ch1);
        // System.out.println((char)ch1);
        // // System.out.println((char)fr.read());
        // int ch2 = fr.read();
        // System.out.println(ch2);
        // System.out.println((char)ch2);
        // int ch3 = fr.read();
        // System.out.println(ch3);
        // System.out.println((char)ch3);
        int ch = -1;
        while ((ch = fr.read()) != -1) {
            System.out.println((char) ch);
        }
        fr.close();
        System.out.println("--------");
        FileReader fr2 = new FileReader("day10_03IO流\\b3.txt");
        // public int read(char[] cbuf)
        char[] chs = new char[2];
        // System.out.println(fr2.read(chs));
        // System.out.println(new String(chs));
        // System.out.println(fr2.read(chs));
        // System.out.println(new String(chs));
        // System.out.println(fr2.read(chs));
        // System.out.println(new String(chs));
        // System.out.println(fr2.read(chs));
        // System.out.println(new String(chs));
        int len = -1;
        while ((len = fr2.read(chs)) != -1) {
            System.out.println(new String(chs, 0, len));
        }
        fr.close();
    }
}
