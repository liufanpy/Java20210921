package com.itheima05_Exchanger类.p02Exchanger执行数据交换;

import java.util.concurrent.Exchanger;

public class MyThread2 extends Thread {
    public Exchanger<String> ec;

    public MyThread2(Exchanger<String> ec) {
        this.ec = ec;
    }

    @Override
    public void run() {
        System.out.println("线程2提交数据给线程1，并等待线程1返回数据");
        String message = null;
        try {
            message = ec.exchange("1号线程，你也好");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("2号线程拿到了1号线程返回的数据:" + message);
    }
}
