package com.itheima03_volatile解决可见性问题及区别;

public class VolatileThread extends Thread {
    public static volatile boolean flag = false;

    @Override
    public void run() {
        System.out.println("子线程启动");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("falg的值已被修改为true");
    }
}
