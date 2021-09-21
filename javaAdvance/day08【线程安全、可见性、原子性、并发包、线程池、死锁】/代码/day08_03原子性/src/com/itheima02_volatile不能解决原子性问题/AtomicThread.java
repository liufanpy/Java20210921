package com.itheima02_volatile不能解决原子性问题;

public class AtomicThread extends Thread {
    public volatile int count;

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            count++;
        }
        System.out.println("子线程添加完成");
    }
}
