package com.itheima02_volatile不能解决原子性问题;


/*
概述:多线程环境下，volatile关键字可以保证共享数据的可见性，但是并不能保证对数据操作的原子性
需求：通过volatile尝试解决高并发原子性问题
*/
public class Test {
    public static void main(String[] args) {
        AtomicThread at = new AtomicThread();
        at.start();
        //主线程中也对该变量增加10000次
        for (int i = 0; i < 10000; i++) {
            at.count++;
        }
        //为了确保子线程执行完成，所以需要在这里睡一会
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("count的最终结果是:" + at.count);

    }
}
