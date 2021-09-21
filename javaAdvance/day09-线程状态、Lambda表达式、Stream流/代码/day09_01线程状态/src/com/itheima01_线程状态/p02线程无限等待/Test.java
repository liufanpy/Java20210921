package com.itheima01_线程状态.p02线程无限等待;

/*
需求：通过测试类演示无限等待
*/
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        // lock.wait();//java.lang.IllegalMonitorStateException
        System.out.println("默默的等待...");
        synchronized (lock) {
            lock.wait();
        }
        System.out.println("终于等到你...");
    }
}
