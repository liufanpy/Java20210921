package com.itheima02_CountDownLatch类;

import java.util.concurrent.CountDownLatch;

/*
概述:CountDownLatch允许一个或多个线程等待其他线程完成操作。
构造方法:public CountDownLatch(int count)// 初始化一个指定计数器的CountDownLatch对象
常用方法:
    public void await() throws InterruptedException// 让当前线程等待
    public void countDown()	// 计数器进行减1
需求：线程1要执行打印：A和C，线程2执行打印：B，但线程1在打印A后，等待线程2打印完B再打印C。
*/
public class Test {
    public static void main(String[] args) throws InterruptedException {
        //先创建一个CountDownLatch对象
        CountDownLatch cdl = new CountDownLatch(1);
        //创建两个线程对象，指定同一个CountDownLatch对象
        MyThread1 mt1 = new MyThread1(cdl);
        MyThread2 mt2 = new MyThread2(cdl);
        mt1.start();
        Thread.sleep(1000);
        mt2.start();
    }

}
