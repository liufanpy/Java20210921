package com.itheima01_ConcurrentHashMap类.p01HashMap线程安全问题;

/*
演示HashMap线程安全问题
    需求：使用两个线程，向同一个HashMap集合，各添加数据500000次，预期结果1000000对数据。
HashMap线程安全问题总结
    由于没有保障再添加数据过程中，多线程的原子性，导致操作丢失
*/
public class Test {
    public static void main(String[] args) throws InterruptedException {
        MyThread mt = new MyThread();
        mt.start();

        for (int i = 0; i < 50000; i++) {
            mt.hm.put(Thread.currentThread().getName() + i, i);
        }

        Thread.sleep(5000);

        System.out.println("集合中最终存储了" + mt.hm.size() + "个数据");
    }
}
