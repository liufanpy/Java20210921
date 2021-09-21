package com.itheima.demo5_字符缓冲流;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/15 11:26
 */
public class Test3_文本排序练习 {
    public static void main(String[] args) throws Exception {
        //分析:
        //1.创建字符缓冲输入流对象,关联数据源文件路径
        FileReader fr = new FileReader("day11\\aaa\\出师表.txt");
        BufferedReader br = new BufferedReader(fr);

        //2.创建ArrayList集合,用来存储每一行字符串数据
        ArrayList<String> list = new ArrayList<>();

        //3.定义一个String类型的变量,用来存储读取到的行数据
        String line;

        //4.循环读取行数据
        while ((line = br.readLine()) != null) {
            //5.在循环中,把读取到的行数据存储到ArrayList集合中
            list.add(line);
        }

        //6.释放资源
        br.close();


        //7.对ArrayList集合进行升序排序
        // Collections.sort(list)方法对list集合排序,如果list集合中的元素是字符串,会按照字符串的字典顺序进行升序排序
        // eg排序前集合元素: ab,ba,ca,ac,bc
        // eg排序后集合元素: ab,ac,ba,bc,ca
        Collections.sort(list);

        //8.创建字符缓冲输出流对象,关联目的地文件路径
        FileWriter fw = new FileWriter("day11\\aaa\\出师表.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        //9.循环遍历ArrayList集合
        for (String text : list) {
            //10.在循环中,写出数据到文件中
            bw.write(text);
            bw.newLine();
        }
        //11.释放资源
        bw.close();
    }
}
