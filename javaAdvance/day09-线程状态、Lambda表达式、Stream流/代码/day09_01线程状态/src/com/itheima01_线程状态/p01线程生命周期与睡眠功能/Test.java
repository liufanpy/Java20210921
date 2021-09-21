package com.itheima01_线程状态.p01线程生命周期与睡眠功能;

/*
当线程被创建并启动以后，它既不是一启动就进入了执行状态，也不是一直处于执行状态。
在API中java.lang.Thread.State这个枚举中给出了六种线程状态
线程状态相关中的方法:
    Thread类的计时等待方法.
		public static void  sleep(long time)  让当前线程进入到睡眠状态，到毫秒后自动醒来继续执行。
    Object类的等待唤醒方法
		public void wait()  让当前线程进入到等待状态 此方法必须锁对象调用.
		public void notify()  唤醒当前锁对象上等待状态的线程  此方法必须锁对象调用.
需求:通过测试类演示sleep方法的使用

*/
public class Test {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("等3秒...");
        Thread.sleep(3000);
        System.out.println("3秒到了...");
    }
}
