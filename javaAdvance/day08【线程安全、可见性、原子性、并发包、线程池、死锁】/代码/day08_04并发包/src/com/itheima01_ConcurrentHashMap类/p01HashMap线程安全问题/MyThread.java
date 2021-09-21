package com.itheima01_ConcurrentHashMap类.p01HashMap线程安全问题;

import java.util.HashMap;

public class MyThread extends Thread {
    public HashMap<String, Integer> hm = new HashMap<>();

    @Override
    public void run() {
        for (int i = 0; i < 50000; i++) {
            hm.put(getName() + i, i);
        }
        System.out.println("子线程添加5万次数据结束");
    }
}
