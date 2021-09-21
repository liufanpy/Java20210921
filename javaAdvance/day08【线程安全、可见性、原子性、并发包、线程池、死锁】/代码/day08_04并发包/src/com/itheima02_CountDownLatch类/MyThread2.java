package com.itheima02_CountDownLatch类;

import java.util.concurrent.CountDownLatch;

public class MyThread2 extends Thread {
    public CountDownLatch cdl;

    public MyThread2(CountDownLatch cdl) {
        this.cdl = cdl;
    }

    @Override
    public void run() {
        System.out.println("线程1打印B...");
        cdl.countDown();
    }
}
