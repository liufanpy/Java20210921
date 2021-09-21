package com.itheima03_同步方法.p01同步方法实现;

public class TicketsRunnable implements Runnable {
    public int ticket = 100;

    @Override
    public void run() {
        while (true) {
            sellTicket();
        }
    }

    public synchronized void sellTicket() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException ie) {
        }
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "正在卖出第" + ticket + "张票");
            ticket--;
        }
    }
}
