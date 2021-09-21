package com.itheima01_原子性问题;

public class AtomicThread extends Thread {
    public int count;

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            count++;
        }
        System.out.println("子线程添加完成");
    }
}
