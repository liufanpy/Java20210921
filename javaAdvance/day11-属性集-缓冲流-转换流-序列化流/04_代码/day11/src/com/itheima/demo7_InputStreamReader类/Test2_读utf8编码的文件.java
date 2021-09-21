package com.itheima.demo7_InputStreamReader类;

import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/15 12:14
 */
public class Test2_读utf8编码的文件 {
    public static void main(String[] args) throws Exception{
        // 1.创建转换输入流对象,关联数据源文件路径
        FileInputStream fis = new FileInputStream("day11\\bbb\\utf8.txt");
        InputStreamReader isr = new InputStreamReader(fis,"utf8");

        // 2.定义一个int类型的变量,用来存储读取到的字符
        int b;

        // 3.循环读取数据
        while ((b = isr.read()) != -1) {
            // 4.在循环中,打印数据
            System.out.println((char) b);// 不乱码
        }

        // 5.释放资源
        isr.close();
    }
}
