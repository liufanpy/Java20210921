package com.itheima01_ConcurrentHashMap类.p02Hashtable解决线程安全问题;

import java.util.Hashtable;

public class MyThread extends Thread {
    public Hashtable<String, Integer> ht = new Hashtable<>();

    @Override
    public void run() {
        for (int i = 0; i < 50000; i++) {
            ht.put(getName() + i, i);
        }
        System.out.println("子线程添加5万次数据结束");
    }
}
