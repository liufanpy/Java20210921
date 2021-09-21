package com.itheima.demo9_ByteBuffer类;

import java.nio.ByteBuffer;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/17 15:46
 */
public class Test2_flip {
    public static void main(String[] args) {
        /*
            - public Buffer flip()：缩小limit的范围。
              - 将当前position位置设置为0；
              - 将limit设置为当前position位置；
              - 丢弃标记。
         */
        // 创建ByteBuffer字节缓冲数组,指定容量为10
        ByteBuffer b1 = ByteBuffer.allocate(10);

        // postion:0,limit:10,capacity:10
        System.out.println("postion:" + b1.position() + ",limit:" + b1.limit() + ",capacity:" + b1.capacity());

        // 添加数据
        b1.put((byte) 10);
        b1.put((byte) 20);
        b1.put((byte) 30);

        // postion:3,limit:10,capacity:10
        System.out.println("postion:" + b1.position() + ",limit:" + b1.limit() + ",capacity:" + b1.capacity());

        // flip一下
        b1.flip();

        // postion:0,limit:3,capacity:10
        System.out.println("postion:" + b1.position() + ",limit:" + b1.limit() + ",capacity:" + b1.capacity());

    }
}
