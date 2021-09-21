package com.itheima02_线程同步解决可见性问题;


/*
原理：被线程同步方式处理的变量，每次执行，会先将工作内存中所有副本清空，重新从主内存获取对应的变量和其值
    当线程释放锁时，JMM会把该线程对应的工作内存中的共享变量刷新到主内存中，以确保之后的线程可以获取到最新的值。
    当线程获取锁时，JMM会把该线程对应的本地内存置为无效。从而使得被监视器保护的临界区代码必须要从主内存中去读取共享变量。
需求：通过同步代码块解决高并发可见性问题

*/
public class Test {
    public static void main(String[] args) {
        VolatileThread vt = new VolatileThread();
        vt.start();

        while (true) {
            synchronized (vt) {
                if (VolatileThread.flag) {

                    System.out.println("我进来了...");
                    break;
                }
            }
        }
        System.out.println("结束");
    }
}
