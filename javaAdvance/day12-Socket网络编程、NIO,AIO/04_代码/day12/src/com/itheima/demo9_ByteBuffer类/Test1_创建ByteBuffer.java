package com.itheima.demo9_ByteBuffer类;

import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/17 14:58
 */
public class Test1_创建ByteBuffer {
    public static void main(String[] args) {
        //- static ByteBuffer allocate(int capacity)   分配一个新的缓冲区（堆内存，创建快，访问慢）。--->常用
        // 创建一个ByteBuffer字节缓冲数组,封装了一个长度为10的byte数组,数组中的元素为:0
        ByteBuffer b1 = ByteBuffer.allocate(10);

        //- static ByteBuffer allocateDirect(int capacity)   分配一个新的直接缓冲区（系统内存，创建慢，访问快）。
        // 创建一个ByteBuffer字节缓冲数组,封装了一个长度为10的byte数组,数组中的元素为:0
        ByteBuffer b2 = ByteBuffer.allocateDirect(10);

        //- static ByteBuffer wrap(byte[] array)    将 byte 数组包装到缓冲区中（堆区）。--->常用
        // 创建一个ByteBuffer字节缓冲数组,封装了一个长度为4的byte数组,数组中的元素为:97,98,99,100
        byte[] bys = {97, 98, 99, 100};
        ByteBuffer b3 = ByteBuffer.wrap(bys);

        //System.out.println("b1:" + Arrays.toString(b1.array()));// [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        //System.out.println("b3:" + Arrays.toString(b3.array()));// [97, 98, 99, 100]

    }
}
