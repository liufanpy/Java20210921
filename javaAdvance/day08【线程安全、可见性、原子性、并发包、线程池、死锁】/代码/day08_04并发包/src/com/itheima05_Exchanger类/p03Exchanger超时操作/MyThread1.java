package com.itheima05_Exchanger类.p03Exchanger超时操作;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class MyThread1 extends Thread {
    public Exchanger<String> ec;

    public MyThread1(Exchanger<String> ec) {
        this.ec = ec;
    }

    @Override
    public void run() {
        System.out.println("线程1提交数据给线程2，并等待线程2返回数据");

        try {
            ec.exchange("2号线程，你好呀", 3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            // e.printStackTrace();
            System.out.println("等待数据超时，看一下那哥们还醒着没...");
        }

        System.out.println("1号线程拿到了2号线程返回的数据");
    }
}
