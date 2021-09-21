package com.itheima01_可见性问题;

/*
概述
    高并发,是多个线程的一种高频运行状态,多线程中的很多问题都是基于高并发的环境而产生.
    可见性，表示所有的子线程对于主内存中共享变量的变化保持可见。
JMM内存模型:(Java Memory Model)Java内存模型,是java虚拟机规范中所定义的一种内存模型。
            该模型描述了Java程序中各种变量(线程共享变量)的访问规则，
            以及在JVM中将变量存储到内存和从内存中读取变量这样的底层细节。
需求：通过线程中定义的开关变量演示高并发可见性问题
可见性问题总结
    主线程中告诉读取的开关变量的值并没有随着线程的执行发生改变。
可见性问题分析
    VolatileThread线程从主内存读取到数据放入其对应的工作内存,flag的值为false
    此时main方法读取到了flag的值为false,且高速执行循环
    VolatileThread线程将flag的值更改为true
    main函数里面的while(true)调用的是系统比较底层的代码，速度快，快到没有时间再去读取主存中的值，导致while(true)读取到的值一直是false。

*/
public class Test {
    public static void main(String[] args) {
        VolatileThread vt = new VolatileThread();
        vt.start();

        while (true) {
            if (VolatileThread.flag) {
                System.out.println("我进来了...");
                break;
            }
        }
        System.out.println("结束");
    }
}
