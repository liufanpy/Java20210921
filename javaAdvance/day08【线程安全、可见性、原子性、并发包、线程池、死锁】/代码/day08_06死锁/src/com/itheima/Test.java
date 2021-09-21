package com.itheima;

/*
什么是死锁:在多线程程序中,使用了多把锁,造成线程之间相互等待.程序不往下走了。
死锁产生条件
    有多把锁
    有多个线程
    有线程同步嵌套
需求：演示死锁代码
*/
public class Test {

    public static void main(String[] args) {
        //定义两个锁
        Object lockA = new Object();
        Object lockB = new Object();
        //通过匿名内部类创建两个线程对象，并启动
        new Thread("线程A") {
            @Override
            public void run() {
                System.out.println("线程A开始执行");
                synchronized (lockA) {
                    System.out.println("线程A获取了A锁...等待获取B锁...");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lockB) {
                        System.out.println("线程A获取了B锁...");
                    }
                    System.out.println("线程A释放了B锁...");
                }
                System.out.println("线程A释放了A锁...");
            }
        }.start();
        System.out.println("--------");
        new Thread("线程B") {
            @Override
            public void run() {
                System.out.println("线程B开始执行");
                synchronized (lockB) {
                    System.out.println("线程B获取了B锁...等待获取A锁...");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lockA) {
                        System.out.println("线程B获取了A锁...");
                    }
                    System.out.println("线程B释放了A锁...");
                }
                System.out.println("线程B释放了B锁...");
            }
        }.start();
    }
}









