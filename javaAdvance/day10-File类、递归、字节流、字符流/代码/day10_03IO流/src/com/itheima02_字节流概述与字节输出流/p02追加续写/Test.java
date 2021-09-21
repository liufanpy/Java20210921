package com.itheima02_字节流概述与字节输出流.p02追加续写;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
追加续写:创建输出流对象，之前数据会被清空。想要保留目标文件中原来的数据，需要使用特定的构造方法。
构造方法:append的值，true 表示追加数据，false 表示清空原有数据。
    public FileOutputStream(File file, boolean append)： 创建文件输出流以写入由指定的 File对象表示的文件。
    public FileOutputStream(String name, boolean append)： 创建文件输出流以指定的名称写入文件。
需求：在已经存在ab的文件中，补充写入cde

 */
public class Test {
    public static void main(String[] args) throws IOException {
        File f1 = new File("day10_03IO流\\a2.txt");
        FileOutputStream fos1 = new FileOutputStream(f1);
        byte[] bys1 = {97, 98};
        fos1.write(bys1);
        fos1.close();
        // public FileOutputStream(File file, boolean append)
        // File f2 = new File("day10_03IO流\\a2.txt");
        // FileOutputStream fos2 = new FileOutputStream(f1);//没有设置追加写入，原数据会被清空
        // FileOutputStream fos2 = new FileOutputStream(f1,true);
        // public FileOutputStream(String name, boolean append)
        String f2 = "day10_03IO流\\a2.txt";
        FileOutputStream fos2 = new FileOutputStream(f2, true);
        byte[] bys2 = {99, 100, 101};
        fos2.write(bys2);
        fos2.close();
    }
}
