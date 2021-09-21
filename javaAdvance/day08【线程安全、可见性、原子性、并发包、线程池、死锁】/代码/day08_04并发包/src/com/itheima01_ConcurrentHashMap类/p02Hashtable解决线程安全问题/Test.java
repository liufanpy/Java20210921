package com.itheima01_ConcurrentHashMap类.p02Hashtable解决线程安全问题;


/*
演示Hashtable解决线程安全问题
需求：为了保证线程安全，可以使用Hashtable替换HashMap。
*/
public class Test {
    public static void main(String[] args) throws InterruptedException {
        MyThread mt = new MyThread();
        mt.start();

        for (int i = 0; i < 50000; i++) {
            mt.ht.put(Thread.currentThread().getName() + i, i);
        }

        Thread.sleep(5000);

        System.out.println("集合中最终存储了" + mt.ht.size() + "个数据");
    }
}