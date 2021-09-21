package com.itheima03_同步方法.p02同步方法中的锁验证;


/*
概述:
    静态同步方法锁对象 :方法所在类的字节码对象(类名.class)
    非静态同步方法锁对象 :this
需求:分别用静态/非静态同步方法，执行100次打印操作，证明静态和非静态方法的锁对象。
*/
public class Test {
    public static void main(String[] args) {
        //证明静态同步方法的锁是该类的字节码文件
        // method1();
        //证明非静态同步方法的锁是this
        MethodThread mt = new MethodThread();
        mt.setName("非静态方法锁:");
        mt.start();
        synchronized (mt) {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                System.out.println(Thread.currentThread().getName() + "正在打印:" + i);
            }
        }

    }

    public static void method1() {
        StaticMethodThread smt = new StaticMethodThread();
        smt.setName("静态方法锁:");
        smt.start();

        synchronized (StaticMethodThread.class) {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                System.out.println(Thread.currentThread().getName() + "正在打印:" + i);
            }
        }
    }
}
