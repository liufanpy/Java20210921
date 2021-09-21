package com.itheima.demo16_commonsio;

import org.apache.commons.io.FileUtils;

import java.io.File;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/15 17:08
 */
public class Test3_FileUtils {
    public static void main(String[] args) throws Exception{
        // public static void copyDirectoryToDirectory(File file1 ,File file2 )
        // 需求: 拷贝文件夹到指定文件夹下
        File srcF = new File("day11\\bbb");
        File destF = new File("day11\\ddd");
        FileUtils.copyDirectoryToDirectory(srcF,destF);

    }
}
