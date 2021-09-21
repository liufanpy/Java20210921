package com.itheima.demo8_OutputStreamWriter类;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/15 14:42
 */
public class Test3_转换文件编码练习 {
    public static void main(String[] args) throws Exception {
        //1.创建转换输入流对象,指定gbk编码,关联数据源文件路径
        FileInputStream fis = new FileInputStream("day11\\bbb\\gbk.txt");
        InputStreamReader isr = new InputStreamReader(fis,"gbk");

        //2.创建转换输出流对象,指定utf8编码,关联目的地文件路径
        FileOutputStream fos = new FileOutputStream("day11\\bbb\\gbk_utf8.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos,"utf8");

        //3.定义一个int变量,用来存储读取到的字符
        int c;

        //4.循环读取
        while ((c = isr.read()) != -1) {
            //5.在循环中,写出数据
            osw.write(c);
        }
        //6.释放资源
        osw.close();
        isr.close();

    }
}
