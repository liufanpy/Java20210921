package com.itheima.demo9_ByteBuffer类;

import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/17 15:29
 */
public class Test2_mark {
    public static void main(String[] args) {
        // 创建ByteBuffer字节缓冲数组,指定容量为10
        ByteBuffer b1 = ByteBuffer.allocate(10);

        // 添加数据
        b1.put((byte) 10);
        b1.put((byte) 20);
        b1.put((byte) 30);

        // mark一下
        b1.mark();// 标记当前的position位置: 3

        // 添加数据
        b1.put((byte) 40);
        b1.put((byte) 50);
        b1.put((byte) 60);


        // b1的position:6
        System.out.println("b1的position:"+b1.position());
        // b1:[10, 20, 30, 40, 50, 60, 0, 0, 0, 0]
        System.out.println("b1:"+ Arrays.toString(b1.array()));


        // 修改postion位置为3
        /*b1.position(3);
        b1.put((byte)70);
        // b1:[10, 20, 30, 70, 50, 60, 0, 0, 0, 0]
        System.out.println("b1:"+ Arrays.toString(b1.array()));*/

        // reset一下
        b1.reset();

        // b1的position:3
        System.out.println("b1的position:"+b1.position());
        b1.put((byte)70);
        // b1:[10, 20, 30, 70, 50, 60, 0, 0, 0, 0]
        System.out.println("b1:"+ Arrays.toString(b1.array()));


    }
}
