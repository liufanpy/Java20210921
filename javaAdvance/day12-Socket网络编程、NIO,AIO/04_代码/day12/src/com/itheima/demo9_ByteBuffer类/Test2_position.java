package com.itheima.demo9_ByteBuffer类;

import java.nio.ByteBuffer;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/17 15:23
 */
public class Test2_position {
    public static void main(String[] args) {
        // 创建ByteBuffer字节缓冲数组,指定容量为10
        ByteBuffer b1 = ByteBuffer.allocate(10);

        // b1的limit: 10,b1的postion:0,能使用的位置: [0,10)
        System.out.println("b1的limit: "+b1.limit()+",b1的postion:"+b1.position());

        // 添加数据
        b1.put((byte) 10);
        b1.put((byte) 20);
        b1.put((byte) 30);

        // b1的limit: 10,b1的postion:3,能使用的位置: [3,10)
        System.out.println("b1的limit: "+b1.limit()+",b1的postion:"+b1.position());
    }
}
