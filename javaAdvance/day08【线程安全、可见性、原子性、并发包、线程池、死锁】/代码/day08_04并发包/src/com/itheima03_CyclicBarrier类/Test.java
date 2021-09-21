package com.itheima03_CyclicBarrier类;

import java.util.concurrent.CyclicBarrier;

/*
概述:CyclicBarrier的字面意思是可循环使用（Cyclic）的屏障（Barrier）。
构造方法:public CyclicBarrier(int parties, Runnable barrierAction)// 初始化一个指定线程数量与达到拦截数量后的执行任务的屏障业务对象
常用方法:
    public int await()// 每个线程调用await方法告诉CyclicBarrier我已经到达了屏障，然后当前线程被阻塞
使用场景:CyclicBarrier可以用于多线程计算数据，最后合并计算结果的场景。
需求：定义一个开会线程，一个员工线程，演示5名员工开会，等5名员工都到了，会议开始。
*/
public class Test {
    public static void main(String[] args) {
        //创建所有人达到指定条件后的任务
        MeetingRunnable mt = new MeetingRunnable();
        //创建CyclicBarrier对象
        CyclicBarrier cb = new CyclicBarrier(5, mt);
        //创建线程对象，启动线程
        PersonThread pt1 = new PersonThread("张三", cb);
        PersonThread pt2 = new PersonThread("李四", cb);
        PersonThread pt3 = new PersonThread("王五", cb);
        PersonThread pt4 = new PersonThread("赵六", cb);
        PersonThread pt5 = new PersonThread("孙七", cb);
        pt1.start();
        pt2.start();
        pt3.start();
        pt4.start();
        pt5.start();
    }
}
