package com.itheima01_线程安全问题;

public class TicketsRunnable implements Runnable {
    public int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
              try {
                  Thread.sleep(500);
              }catch (InterruptedException ie){
              }
                System.out.println(Thread.currentThread().getName() + "正在卖出第" + ticket + "张票");
                ticket--;
            }
        }
    }
}
