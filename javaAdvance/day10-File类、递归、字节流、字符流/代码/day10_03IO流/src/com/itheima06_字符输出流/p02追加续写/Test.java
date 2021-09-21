package com.itheima06_字符输出流.p02追加续写;

import java.io.File;
import java.io.FileWriter;
import java.io.FileWriter;
import java.io.IOException;

/*
追加续写:想创建输出流对象，之前数据会被清空。想要保留目标文件中原来的数据，需要使用特定的构造方法。
构造方法:append的值，true 表示追加数据，false 表示清空原有数据。
    public FileWriter(File file, boolean append):创建字符输出流写入由指定的 File对象表示的文件。
    public FileWriter(String name, boolean append):创建字符输出流以指定的名称写入文件。
需求：在已经存在"黑马"的文件中，补充写入"程序员"

 */
public class Test {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("day10_03IO流\\a6.txt");
        fw.write("黑马");
        fw.close();
        // public FileWriter(File file, boolean append)
        // File f  = new File("day10_03IO流\\a6.txt");
        // FileWriter fw2 = new FileWriter(f);
        // public FileWriter(String name, boolean append)
        FileWriter fw2 = new FileWriter("day10_03IO流\\a6.txt", true);
        fw2.write("程序员");
        fw2.close();
    }
}
