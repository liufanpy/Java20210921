package com.itheima04_图片复制案例;

import java.io.*;

/*
需求:将已存在的图片，从一个目录中，复制到另一个目录中。
分析:
    需要数据源与要写入数据的目的地
    需要使用字节流读取数据
    需要在读到数据的同时将数据写到目的地
实现

 */
public class Test {
    public static void main(String[] args) throws IOException {
        // 需要数据源与要写入数据的目的地
        File srcFile = new File("day10_03IO流\\hyrz.jpg");
        FileInputStream fis = new FileInputStream(srcFile);
        File destFile = new File("day10_03IO流\\hyrz_copy.jpg");
        FileOutputStream fos = new FileOutputStream(destFile);
        // 需要使用字节流读取数据
        byte[] bys = new byte[8];
        int len = -1;
        while ((len = fis.read(bys)) != -1) {
            //没读到一次数据，循环就会进来，将数据写到目的地
            // 需要在读到数据的同时将数据写到目的地
            //public void write(byte[] b, int off, int len)
            fos.write(bys, 0, len);
        }
        //关流
        fos.close();
        fis.close();
    }
}
