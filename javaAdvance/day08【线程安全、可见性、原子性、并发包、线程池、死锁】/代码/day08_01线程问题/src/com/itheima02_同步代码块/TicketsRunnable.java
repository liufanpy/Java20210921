package com.itheima02_同步代码块;

public class TicketsRunnable implements Runnable {
    public Object lock = new Object();
    public int ticket = 100;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException ie) {
            }
            synchronized (lock) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "正在卖出第" + ticket + "张票");
                    ticket--;
                }
            }
        }
    }
}
