package com.itheima.demo4_字节缓冲流;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/15 10:19
 */
public class Test2_字节缓冲流读写一个字节拷贝文件 {
    public static void main(String[] args) throws Exception {
        // 0.获取当前系统时间距离标准基准时间的毫秒值
        long start = System.currentTimeMillis();

        // 1.创建字节缓冲输入流对象,关联数据源文件路径
        FileInputStream fis = new FileInputStream("day11\\aaa\\jdk9.exe");
        BufferedInputStream bis = new BufferedInputStream(fis);

        // 2.创建字节缓冲输出流对象,关联目的地文件路径
        FileOutputStream fos = new FileOutputStream("day11\\aaa\\jdk9Copy2.exe");
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        // 3.定义一个int变量,用来存储读取到的字节数据
        int len;

        // 4.循环读取字节数据
        while ((len = bis.read()) != -1) {
            // 5.在循环中,写出字节数据
            bos.write(len);
        }

        // 6.释放资源
        bos.close();
        bis.close();

        // 7.获取当前系统时间距离标准基准时间的毫秒值
        long end = System.currentTimeMillis();
        System.out.println("总共花了:" + (end - start) + "毫秒");// 大概需要31秒
    }
}
