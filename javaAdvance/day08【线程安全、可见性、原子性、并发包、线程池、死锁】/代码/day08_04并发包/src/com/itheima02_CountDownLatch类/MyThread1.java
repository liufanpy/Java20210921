package com.itheima02_CountDownLatch类;

import java.util.concurrent.CountDownLatch;

public class MyThread1 extends Thread {
    public CountDownLatch cdl;

    public MyThread1(CountDownLatch cdl) {
        this.cdl = cdl;
    }

    @Override
    public void run() {
        System.out.println("线程1打印A...");
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程1打印C...");
    }
}
