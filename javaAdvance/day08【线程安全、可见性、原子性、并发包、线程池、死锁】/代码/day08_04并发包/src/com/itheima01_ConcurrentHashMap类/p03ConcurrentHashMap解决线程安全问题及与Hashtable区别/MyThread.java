package com.itheima01_ConcurrentHashMap类.p03ConcurrentHashMap解决线程安全问题及与Hashtable区别;

import java.util.concurrent.ConcurrentHashMap;

public class MyThread extends Thread {
    public ConcurrentHashMap<String, Integer> chm = new ConcurrentHashMap<>();

    @Override
    public void run() {
        for (int i = 0; i < 50000; i++) {
            chm.put(getName() + i, i);
        }
        System.out.println("子线程添加5万次数据结束");
    }
}
