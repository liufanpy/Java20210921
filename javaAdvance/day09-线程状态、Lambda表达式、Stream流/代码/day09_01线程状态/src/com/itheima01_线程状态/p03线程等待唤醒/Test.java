package com.itheima01_线程状态.p03线程等待唤醒;

/*
需求：通过测试类创建两个线程演示等待唤醒
*/
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        new Thread() {
            @Override
            public void run() {
                System.out.println("默默的等待...");
                synchronized (lock) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("终于等到你...");
            }
        }.start();
        //定义另一个线程，在线程中，使用同一把锁，唤醒上面的线程
        Thread.sleep(3000);
        new Thread() {
            @Override
            public void run() {
                System.out.println("辛苦你的等待，我来了...");
                synchronized (lock) {
                    lock.notify();
                }
                System.out.println("终于唤醒了你...");
            }
        }.start();
    }
}
