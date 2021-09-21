package com.itheima05_Exchanger类.p03Exchanger超时操作;


import java.util.concurrent.Exchanger;

/*
概述:在交换数据时，不可能让程序一直等待下去，就需要告诉程序一个等待时间。
常用方法:public V exchange(V x, long timeout, TimeUnit unit)
    x - 要交换的对象
    timeout - 等待的最长时间
    unit - timeout参数的时间单位(TimeUnit.SECONDS 秒单位)
需求:定义A、B两个线程，使用Exchange模拟交换礼物的超时处理
*/
public class Test {
    public static void main(String[] args) {
        //创建Exchanger对象
        Exchanger<String> ec = new Exchanger<>();
        //创建线程对象
        MyThread1 mt = new MyThread1(ec);
        mt.start();
    }
}
