package com.itheima05_Exchanger类.p02Exchanger执行数据交换;


import java.util.concurrent.Exchanger;

/*
需求:定义A、B两个线程，使用Exchange模拟交换礼物
*/
public class Test {
    public static void main(String[] args) throws InterruptedException {
        //创建Exchanger对象
        Exchanger<String> ec = new Exchanger<>();
        //创建两个线程对象
        MyThread1 mt1 = new MyThread1(ec);
        mt1.start();
        Thread.sleep(3000);
        MyThread2 mt2 = new MyThread2(ec);
        mt2.start();
    }
}
