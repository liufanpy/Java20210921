package com.itheima04_Semaphore类;

import java.util.concurrent.Semaphore;

/*
概述:Semaphore的主要作用是控制线程的并发数量,控制指定个线程可以同时访问一个方操作。
构造方法:public Semaphore(int permits) 创建线程并发数量对象  permits 表示许可线程的数量
常用方法:
    public void acquire() throws InterruptedException	表示获取许可
    public void release()	 表示释放许可
需求：获取线程的开始和结束时间，演示同一时间内，两个线程完成指定任务。
*/
public class Test {
    public static void main(String[] args) {
        //创建Semaphore对象
        Semaphore sh = new Semaphore(2);
        //通过循环创建多个MyThread线程对象，并启动
        for (int i = 0; i < 10; i++) {
            new MyThread(sh).start();
        }
    }
}
