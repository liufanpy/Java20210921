package com.itheima03_线程同步解决原子性问题;

public class AtomicThread extends Thread {
    public int count;

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (this) {
                count++;
            }
        }
        System.out.println("子线程添加完成");
    }
}
