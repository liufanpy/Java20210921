package com.itheima04_原子类解决原子性问题;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicThread extends Thread {
    public AtomicInteger count = new AtomicInteger();//count=0;

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            count.getAndIncrement();
        }
        System.out.println("子线程添加完成");
    }
}
