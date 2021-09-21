package com.itheima.demo5_字符缓冲流;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/15 11:16
 */
public class Test2_BufferedWriter {
    public static void main(String[] args) throws Exception{
        // 1.创建字符缓冲输出流对象,关联目的地文件路径
        FileWriter fw = new FileWriter("day11\\aaa\\c.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        // 2.写出数据
        bw.write("今天天气好晴朗");
        bw.newLine();

        bw.write("坐在教室敲代码");
        bw.newLine();

        bw.write("两耳不闻窗外事");
        bw.newLine();

        bw.write("一心只读圣贤书");

        // 3.释放资源
        bw.close();

    }
}
