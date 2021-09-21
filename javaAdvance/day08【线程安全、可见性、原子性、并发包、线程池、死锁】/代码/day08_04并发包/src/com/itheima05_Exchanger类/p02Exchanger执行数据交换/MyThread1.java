package com.itheima05_Exchanger类.p02Exchanger执行数据交换;

import java.util.concurrent.Exchanger;

public class MyThread1 extends Thread {
    public Exchanger<String> ec;

    public MyThread1(Exchanger<String> ec) {
        this.ec = ec;
    }

    @Override
    public void run() {
        System.out.println("线程1提交数据给线程2，并等待线程2返回数据");
        String message = null;
        try {
            message = ec.exchange("2号线程，你好呀");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("1号线程拿到了2号线程返回的数据:" + message);
    }
}
