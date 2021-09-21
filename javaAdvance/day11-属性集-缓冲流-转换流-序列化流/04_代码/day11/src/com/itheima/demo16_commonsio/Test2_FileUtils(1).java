package com.itheima.demo16_commonsio;

import org.apache.commons.io.FileUtils;

import java.io.File;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/15 17:08
 */
public class Test2_FileUtils {
    public static void main(String[] args) throws Exception {
        // public static void copyFileToDirectory( File srcFile,  File destFile)
        // 需求: 拷贝文件到指定文件夹下
        File srcF = new File("day11\\aaa\\hb.jpg");// 文件路径
        File destF = new File("day11\\ddd");// 文件夹路径

        FileUtils.copyFileToDirectory(srcF, destF);

    }
}
