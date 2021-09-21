package com.itheima03_同步方法.p01同步方法实现;


/*
概述:synchronized修饰的方法,叫做同步方法,，表示只对这个方法中的资源实行互斥访问。
格式：
    public [static] synchonized 返回值类型 方法名(){}
需求：使用同步方法解决卖票线程安全问题
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
