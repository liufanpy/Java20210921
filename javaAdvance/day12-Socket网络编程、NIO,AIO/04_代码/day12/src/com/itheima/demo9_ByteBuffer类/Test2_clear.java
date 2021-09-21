package com.itheima.demo9_ByteBuffer类;

import java.nio.ByteBuffer;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/17 15:46
 */
public class Test2_clear {
    public static void main(String[] args) {
        /*
            - public Buffer clear()：还原缓冲区的状态。
              - 将position设置为：0
              - 将限制limit设置为容量capacity；
              - 丢弃标记mark。
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

        // 修改limit为5
        b1.limit(5);

        // postion:3,limit:5,capacity:10
        System.out.println("postion:" + b1.position() + ",limit:" + b1.limit() + ",capacity:" + b1.capacity());

        // 还原一下
        b1.clear();

        //  postion:0,limit:10,capacity:10
        System.out.println("postion:" + b1.position() + ",limit:" + b1.limit() + ",capacity:" + b1.capacity());

    }
}
