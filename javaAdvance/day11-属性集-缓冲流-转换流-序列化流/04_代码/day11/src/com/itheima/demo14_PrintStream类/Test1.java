package com.itheima.demo14_PrintStream类;

import java.io.PrintStream;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/15 16:08
 */
public class Test1 {
    public static void main(String[] args) throws Exception{
        // 需求: 通过打印流,把数据打印到day11\ddd\a.txt文件中
        // 1.创建打印流对象,关联目的地文件路径
        PrintStream ps = new PrintStream("day11\\ddd\\a.txt");

        // 2.打印数据到文件中
        ps.println(97);
        ps.println(true);
        ps.println(3.14);
        ps.println("黑马程序");
        ps.println('员');

        // 3.释放资源
        ps.close();

        // ----------------------------
        PrintStream ps1 = System.out;
        ps1.println("itcast");
        // 下面这句代码等效于上面2行代码
        System.out.println("itheima");// 链式编程

    }
}
