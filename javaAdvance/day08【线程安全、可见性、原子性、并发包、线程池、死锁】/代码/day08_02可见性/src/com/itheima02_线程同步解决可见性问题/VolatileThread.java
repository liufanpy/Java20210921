package com.itheima02_线程同步解决可见性问题;

public class VolatileThread extends Thread {
    public static boolean flag = false;

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
