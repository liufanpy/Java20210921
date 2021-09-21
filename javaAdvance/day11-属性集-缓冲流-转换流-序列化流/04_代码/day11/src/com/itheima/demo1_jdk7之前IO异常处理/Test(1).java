package com.itheima.demo1_jdk7之前IO异常处理;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/15 8:50
 */
public class Test {
    public static void main(String[] args) {
        // jdk7之前:  try...catch...finally
        // 快捷键:  选中代码--->然后ctrl+alt+t
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            // 1.创建字节输入流对象,关联数据源文件路径
            fis = new FileInputStream("day11\\aaa\\hb.jpg");

            // 2.创建字节输出流对象,关联目的地文件路径
            fos = new FileOutputStream("day11\\aaa\\hbCopy1.jpg");

            // 3.定义一个byte数组,用来存储读取到的字节数据
            byte[] bys = new byte[8192];

            // 3.定义一个int类型的变量,用来存储读取到的字节个数
            int len;

            // 4.循环读取数据
            while ((len = fis.read(bys)) != -1) {
                // 5.在循环中,写出数据
                fos.write(bys, 0, len);
            }

        } catch (IOException e) {
            System.out.println("出现了异常,异常的信息是:" + e.getMessage());
        } finally {
            // 一般放释放资源的代码
            // 6.释放资源
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fis != null) {
                        fis.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
