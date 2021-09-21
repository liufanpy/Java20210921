package com.itheima02_同步代码块;


/*
概述:synchronized关键字可以用于方法中的某个区块中，表示只对这个区块的资源实行互斥访问。
格式：
    synchronized (同步锁){
        //代码块
    }
同步锁说明:
    对象的同步锁只是一个概念,可以想象为在对象上标记了一个锁
    锁对象 可以是任意类型
    多个线程对象，想要达到线程同步，需要使用同一把锁
需求：使用同步代码块解决卖票线程安全问题
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
