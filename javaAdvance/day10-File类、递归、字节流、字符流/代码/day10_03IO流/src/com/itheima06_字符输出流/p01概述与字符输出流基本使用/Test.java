package com.itheima06_字符输出流.p01概述与字符输出流基本使用;

import java.io.File;
import java.io.FileWriter;
import java.io.FileWriter;
import java.io.IOException;

/*
介绍
    java.io.Writer 抽象类表示字符输出流的所有类的超类，规定了将字符信息写出到目的地共性方法。
    java.io.FileWriter文件输出流，字符输出流常用子类，(使用系统默认的字符编码和默认字节缓冲区)将数据写出到文件。
构造方法
    FileWriter(File file):创建一个新的 FileWriter，给定要读取的File对象。
    FileWriter(String fileName):创建一个新的 FileWriter，给定要读取的文件的名称。
常用方法
    public void close():关闭此输出流并释放与此流相关联的任何系统资源。
    public void flush() :刷新此输出流并强制任何缓冲的输出字符被写出。
    public void write(int c):写出一个字符。
    public void write(char[] cbuf)：将 cbuf.length字符从指定的字符数组写出此输出流。
    public void write(char[] b, int off, int len):从指定字节数组,按照偏移量写入len个字符。
    public void write(String str):写出一个字符串。
    public void write(String str, int off, int len) ，每次可以写出一个字符串的指定范围
需求：演示字符输出流的基本使用及关闭和刷新在字符流中的区别


 */
public class Test {
    public static void main(String[] args) throws IOException {
        // FileWriter(File file)
        // File f1 = new File("day10_03IO流\\a5.txt");
        // FileWriter fw = new FileWriter(f1);
        // FileWriter(String fileName)
        FileWriter fw = new FileWriter("day10_03IO流\\a5.txt");
        // public void write(int c)
        fw.write('黑');
        // public void write(char[] cbuf)
        char[] chs = {'马', '程', '序', '员'};
        fw.write(chs);
        // public void write(char[] b, int off, int len)
        char[] chs2 = {'你', '好', '啊'};
        fw.write(chs2, 0, 2);
        // public void write(String str)
        fw.write("你值得拥有...");
        // public void write(String str, int off, int len)
        fw.write("你是最棒的", 2, 3);
        //字符流写完数据，必须要刷新
        //public void flush()
        //如果你的文件内容过大，在一定的次数之后，必须要刷新，以防内存溢出
        // fw.flush();

        // public void close()
        fw.close();
    }
}
