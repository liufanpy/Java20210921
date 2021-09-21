package com.itheima.demo10_FileChannel类的使用;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/17 16:32
 */
public class Test2_结合MappedByteBuffer复制2GB以下的文件 {
    public static void main(String[] args) throws Exception{
        // 1.创建RandomAccessFile对象,指定模式: r:表示读,  rw:表示读写
        RandomAccessFile r1 = new RandomAccessFile("H:\\a.zip","r");
        RandomAccessFile r2 = new RandomAccessFile("day12\\ccc\\a.zip","rw");

        // 2.获取FileChannel
        FileChannel c1 = r1.getChannel();
        FileChannel c2 = r2.getChannel();

        // 3.获取文件的字节大小
        long size = c1.size();

        // 假设每次复制的字节大小:  everySize
        long everySize = 500*1024*1024;

        //复制的总次数: count = size%everySize==0 ?  size / everySize :  (size / everySize) + 1;
        long count = size%everySize==0 ?  size / everySize :  (size / everySize) + 1;

        // 循环映射
        for (long i = 0; i < count; i++) {

            //每次复制的开始位置:  start =  i*everySize
            long  start =  i*everySize;

            //每次真正复制的字节大小:  (size - start) > everySize  ? everySize :  size-start
            long trueSize = (size - start) > everySize  ? everySize :  size-start;

            // 4.映射
            MappedByteBuffer m1 = c1.map(FileChannel.MapMode.READ_ONLY, start, trueSize);
            MappedByteBuffer m2 = c2.map(FileChannel.MapMode.READ_WRITE, start, trueSize);

            // 5.把m1中的字节数据拷贝到m2中
            for (long j = 0; j < trueSize; j++) {
                // 获取m1映射数组中的字节数据
                byte b = m1.get();
                // 存储到m2映射数组中
                m2.put(b);
            }
        }

        // 6.释放资源
        c2.close();
        c1.close();
        r2.close();
        r1.close();

    }
}
