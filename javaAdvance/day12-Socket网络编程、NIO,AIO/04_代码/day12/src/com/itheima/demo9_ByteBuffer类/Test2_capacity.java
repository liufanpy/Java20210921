package com.itheima.demo9_ByteBuffer类;

import java.nio.ByteBuffer;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/17 15:16
 */
public class Test2_capacity {
    public static void main(String[] args) {
        // 创建ByteBuffer字节缓冲数组,指定容量为10
        ByteBuffer b1 = ByteBuffer.allocate(10);

        //b1的容量: 10
        System.out.println("b1的容量: "+b1.capacity());

        // 添加数据
        b1.put((byte) 10);
        b1.put((byte) 20);
        b1.put((byte) 30);

        //b1的容量: 10
        System.out.println("b1的容量: "+b1.capacity());
    }
}
