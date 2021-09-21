package com.itheima_03目录的遍历;

import java.io.File;
import java.util.Arrays;

/*
方法介绍
    public String[] list() ：返回一个String数组，表示该File目录中的所有子文件或目录。
    public File[] listFiles() ：返回一个File数组，表示该File目录中的所有的子文件或目录。
需求：演示获取D盘下所有文件和目录

 */
public class Test {
    public static void main(String[] args) {
        File f = new File("D:\\");
        // public String[] list()
        String[] list = f.list();
        System.out.println(Arrays.toString(list));
        // public File[] listFiles()
        File[] files = f.listFiles();
        System.out.println(Arrays.toString(files));
    }
}
