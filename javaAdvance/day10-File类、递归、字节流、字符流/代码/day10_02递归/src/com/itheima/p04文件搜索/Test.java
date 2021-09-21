package com.itheima.p04文件搜索;

import java.io.File;

/*
需求：使用递归搜索指定目录中的.java 文件。
分析:
    规律:
        遇到目录，递归调用
        遇到(满足条件的)文件，直接打印
    出口:
        遇到(满足条件的)文件，直接打印
思路
    打印展示的目录
    判断当前路径对应的实体是否是目录
     	如果是目录，获取目录下所有的文件和目录
     	遍历所有的文件和目录
     		所有的文件和目录File对象
      		判断如果当前路径是一个文件,且以.java作为后缀名，则打印该文件名
      		如果当前路径是一个目录，则利用递归展示该目录下的内容
 */
public class Test {
    public static void main(String[] args) {
        // File f = new File(".");
        File f = new File("E:\\1.forteach\\javase2_113code");
        showJavaFile(f);
    }

    public static void showJavaFile(File file) {

        // 判断当前路径对应的实体是否是目录
        if (file.isDirectory()) {
            // 打印展示的目录
            System.out.println("当前操作的目录:" + file.getAbsolutePath());
            //         如果是目录，获取目录下所有的文件和目录
            File[] files = file.listFiles();
            //         遍历所有的文件和目录
            for (File f1 : files) {// 所有的文件和目录File对象
                //             如果当前路径是一个目录，则利用递归展示该目录下的内容
                if (f1.isDirectory()) {
                    showJavaFile(f1);
                    //         判断如果当前路径是一个文件,且以.java作为后缀名，则打印该文件名
                } else if (f1.isFile()) {
                    String name = f1.getName();
                    if (name.endsWith(".java")) {
                        System.out.println(name);
                    }
                }
            }
        } else {
            System.out.println("您当前要操作的不是目录，是一个文件");
        }
    }
}
