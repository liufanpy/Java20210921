package com.itheima05_Exchanger类.p01Exchanger概述与阻塞特性;

import java.util.concurrent.Exchanger;

/*
概述:Exchanger（交换者）是一个用于线程间协作的工具类，用于进行线程间的数据交换。
构造方法:public Exchanger() 创建用于线程间交换数据的对象
常用方法:
    public V exchange(V x)// 交换数据的方法  把参数的数据传递给另一条线程,返回另一条线程传递过来的数据
使用场景:可以做数据校对工作
需求:定义A线程，模拟送出礼物，演示exchange阻塞特性
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
