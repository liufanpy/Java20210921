package com.itheima.demo10_FileChannel类的使用;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/17 16:32
 */
public class Test2_结合MappedByteBuffer复制2GB以上的文件 {
    public static void main(String[] args) throws Exception{
        // 1.创建RandomAccessFile对象,指定模式: r:表示读,  rw:表示读写
        RandomAccessFile r1 = new RandomAccessFile("day12\\aaa\\hb.jpg","r");
        RandomAccessFile r2 = new RandomAccessFile("day12\\ccc\\hbCopy2.jpg","rw");

        // 2.获取FileChannel
        FileChannel c1 = r1.getChannel();
        FileChannel c2 = r2.getChannel();

        // 3.获取文件的字节大小
        long size = c1.size();

        // 4.映射
        MappedByteBuffer m1 = c1.map(FileChannel.MapMode.READ_ONLY, 0, size);
        MappedByteBuffer m2 = c2.map(FileChannel.MapMode.READ_WRITE, 0, size);

        // 5.把m1中的字节数据拷贝到m2中
        for (long i = 0; i < size; i++) {
            // 获取m1映射数组中的字节数据
            byte b = m1.get();
            // 存储到m2映射数组中
            m2.put(b);
        }

        // 6.释放资源
        c2.close();
        c1.close();
        r2.close();
        r1.close();

    }
}
