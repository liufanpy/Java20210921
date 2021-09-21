package com.itheima.demo9_ByteBuffer类;

import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/17 15:10
 */
public class Test2_put {
    public static void main(String[] args) {
        // 创建ByteBuffer字节缓冲数组,指定容量为10
        ByteBuffer b1 = ByteBuffer.allocate(10);

        //- public ByteBuffer put(byte b)：向当前可用位置添加数据。
        b1.put((byte) 10);
        b1.put((byte) 20);
        b1.put((byte) 30);

        //- public ByteBuffer put(byte[] byteArray)：向当前可用位置添加一个byte[]数组
        byte[] bys = {97, 98, 99, 100};
        b1.put(bys);

        //- public ByteBuffer put(byte[] byteArray,int offset,int len)：添加一个byte[]数组的一部分
        b1.put(bys, 0, 2);

        // b1:[10, 20, 30, 97, 98, 99, 100, 97, 98, 0]
        System.out.println("b1:" + Arrays.toString(b1.array()));
    }
}
