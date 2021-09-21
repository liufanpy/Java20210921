package com.itheima04_Semaphore类;

import java.util.concurrent.Semaphore;

public class MyThread extends Thread {
    public Semaphore sh;

    public MyThread(Semaphore sh) {
        this.sh = sh;
    }

    @Override
    public void run() {
        try {
            sh.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getName() + "开始时间：" + System.currentTimeMillis());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getName() + "结束时间：" + System.currentTimeMillis());
        sh.release();
    }
}
