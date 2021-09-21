package com.itheima01_ConcurrentHashMap类.p03ConcurrentHashMap解决线程安全问题及与Hashtable区别;


/*
ConcurrentHashMap并发类介绍
    并发类，可以保障线程并发中的安全问题
    HashMap线程不安全，会导致数据错乱，属于并发安全问题
    使用线程安全的Hashtable效率低下
需求：为了保证线程安全同时并提高效率，可以使用ConcurrentHashMap替换HashMap。
*/
public class Test {
    public static void main(String[] args) throws InterruptedException {
        MyThread mt = new MyThread();
        mt.start();

        for (int i = 0; i < 50000; i++) {
            mt.chm.put(Thread.currentThread().getName() + i, i);
        }

        Thread.sleep(5000);

        System.out.println("集合中最终存储了" + mt.chm.size() + "个数据");
    }
}
