package com.itheima03_线程同步解决原子性问题;


/*
概述:通过给count++添加同步机制，使count++称为一个原子性操作。
需求：通过同步代码块解决高并发原子性问题

*/
public class Test {
    public static void main(String[] args) {
        AtomicThread at = new AtomicThread();
        at.start();
        //主线程中也对该变量增加10000次
        for (int i = 0; i < 10000; i++) {
            synchronized (at){
                at.count++;
            }

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
