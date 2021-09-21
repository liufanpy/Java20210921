package com.itheima.demo5_字符缓冲流;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/15 11:11
 */
public class Test1_BufferedReader {
    public static void main(String[] args) throws Exception {
        // 1.创建字符缓冲输入流对象,关联数据源文件路径
        FileReader fr = new FileReader("day11\\aaa\\b.txt");
        BufferedReader br = new BufferedReader(fr);

        // 2.读数据
        // 2.1 定义一个字符串类型的变量,用来存储读取到的行数据
        String line;

        // 2.2 循环读取行数据
        while ((line = br.readLine()) != null) {
            System.out.println("line:" + line);
        }

        // 3.释放资源
        br.close();

    }
}
