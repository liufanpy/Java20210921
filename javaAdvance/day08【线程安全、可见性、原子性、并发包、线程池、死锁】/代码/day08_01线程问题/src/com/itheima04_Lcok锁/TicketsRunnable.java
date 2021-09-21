package com.itheima04_Lcok锁;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketsRunnable implements Runnable {
    Lock lock = new ReentrantLock();
    public int ticket = 100;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ie) {
            }
            lock.lock();
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "正在卖出第" + ticket + "张票");
                ticket--;
            }
            lock.unlock();
        }
    }
}
