package com.itheima_01File类概述与构造.p02相对路径与绝对路径;

import java.io.File;

/*
路径的分类
    绝对路径：从盘符开始的路径，这是一个完整的路径。
    相对路径：相对于项目目录的路径，这是一个便捷的路径，开发中经常使用
需求：演示相对路径和绝对路径表示当前模块下的a.txt文件

 */
public class Test {
    public static void main(String[] args) {
        // 绝对路径
        File f = new File("E:\\1.forteach\\javase2_113code\\day10_01File\\a.txt");
        System.out.println(f);
        //相对路径 相对于项目
        File f2 = new File("day10_01File\\a.txt");
        System.out.println(f2.getAbsolutePath());
    }
}
