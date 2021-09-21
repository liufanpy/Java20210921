package com.itheima.demo16_commonsio;

import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/15 17:06
 */
public class Test1_IOUtils工具类 {
    public static void main(String[] args) throws Exception{
        // public static int copy(InputStream in, OutputStream out)
        FileInputStream fis = new FileInputStream("day11\\aaa\\hb.jpg");
        FileOutputStream fos = new FileOutputStream("day11\\ddd\\hbCopy1.jpg");
        // 使用IOUtils工具类进行拷贝文件
        IOUtils.copy(fis,fos);
        // 释放资源
        fos.close();
        fis.close();

    }
}
