package com.itheima01_Lambda概述;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "第" + i + "次运行");
        }
    }
}
