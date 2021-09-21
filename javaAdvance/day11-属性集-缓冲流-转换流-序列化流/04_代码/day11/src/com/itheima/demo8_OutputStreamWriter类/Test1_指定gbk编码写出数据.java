package com.itheima.demo8_OutputStreamWriter类;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/15 12:20
 */
public class Test1_指定gbk编码写出数据 {
    public static void main(String[] args) throws Exception{
        // 1.创建转换输出流对象,关联目的地文件路径
        FileOutputStream fos = new FileOutputStream("day11\\bbb\\gbk_1.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos,"gbk");

        // 2.写出数据
        osw.write("中国你好");

        // 3.释放资源
        osw.close();

    }
}
