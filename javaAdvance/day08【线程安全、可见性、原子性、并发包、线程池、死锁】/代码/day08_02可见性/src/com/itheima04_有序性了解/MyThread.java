package com.itheima04_有序性了解;

/*
有序性不容易被演示，这里只做了解。
*/
public class MyThread extends Thread {
    int i1 = 0;
    boolean b1 = false;

    @Override
    public void run() {
        i1 = 10;
        b1 = true;

    }
}
