package com.itheima.demo6_编码引出的问题;

import java.io.FileReader;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/15 12:02
 */
public class Test1_FileReader读gbk编码文件 {
    public static void main(String[] args) throws Exception {
        // 1.创建字符输入流对象,关联数据源文件路径
        FileReader fr = new FileReader("day11\\bbb\\gbk.txt");

        // 2.定义一个int类型的变量,用来存储读取到的字符
        int b;

        // 3.循环读取数据
        while ((b = fr.read()) != -1) {
            // 4.在循环中,打印数据
            System.out.println((char) b);
        }

        // 5.释放资源
        fr.close();

    }
}
