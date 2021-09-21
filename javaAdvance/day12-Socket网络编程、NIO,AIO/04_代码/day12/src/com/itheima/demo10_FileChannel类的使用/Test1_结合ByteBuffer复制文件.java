package com.itheima.demo10_FileChannel类的使用;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/17 16:11
 */
public class Test1_结合ByteBuffer复制文件 {
    public static void main(String[] args) throws Exception{
        // 1.创建字节输入流对象,关联数据源文件路径
        FileInputStream fis = new FileInputStream("day12\\aaa\\hb.jpg");
        // 2.创建字节输出流对象,关联目的地文件路径
        FileOutputStream fos = new FileOutputStream("day12\\ccc\\hbCopy1.jpg");

        // 3.通过输入流和输出流分别获取对应的FileChannel对象
        FileChannel c1 = fis.getChannel();
        FileChannel c2 = fos.getChannel();



        // 4.创建字节缓冲数组,指定容量
        ByteBuffer b = ByteBuffer.allocate(8192);

        // 4.循环读数据
        while (c1.read(b) != -1) {
            // flip一下,切换为写的模式
            b.flip();// position:0, limit: position

            // 5.在循环中,写数据
            c2.write(b);

            // clear一下,供下一次循环使用
            b.clear();// position:0, limit: capacity
        }
        // 6.释放资源
        c2.close();
        c1.close();
        fos.close();
        fis.close();
    }
}
