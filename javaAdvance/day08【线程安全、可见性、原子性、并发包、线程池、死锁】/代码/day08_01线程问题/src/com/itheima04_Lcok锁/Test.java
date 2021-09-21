package com.itheima04_Lcok锁;


/*
概述:
    java.util.concurrent.locks.Lock机制提供了比同步代码块和同步方法更广泛的锁定操作。
    Lock是一个接口，需要使用其子类ReentrantLock来创建对象，使用具体的功能。
构造方法:public ReentrantLock(){}
常用方法：
    public void lock() 加同步锁。
    public void unlock() 释放同步锁。
需求：使用Lock锁解决卖票线程安全问题

*/
public class Test {
    public static void main(String[] args) {
        //创建任务对象
       TicketsRunnable tr = new TicketsRunnable();
        //创建四个线程，代表四个窗口执行卖票任务
        Thread t1 = new Thread(tr, "窗口1:");
        Thread t2 = new Thread(tr, "窗口2:");
        Thread t3 = new Thread(tr, "窗口3:");
        Thread t4 = new Thread(tr, "窗口4:");
        //启动四个窗口，开始卖票
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
