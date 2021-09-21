package com.itheima03_同步方法.p02同步方法中的锁验证;

public class StaticMethodThread extends Thread {
    @Override
    public void run() {
        show();
    }

    public static synchronized void show() {

        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread().getName() + "正在打印:" + i);
        }
    }
}
