package com.itheima03_volatile解决可见性问题及区别;


/*
概述:volatile关键字，标记存在可见性问题变量，确保被修改后的数据被及时读取。
格式:权限修饰符 volatile 数据类型  变量名;
原理:被volatile修饰的变量，每次执行，若发现这个变量的值被改变，重新从主内存获取这个变量和其值
    读内存:当读一个 volatile 变量时，JMM 会把该线程对应的本地内存置为无效。线程之后将从主内存中读取共享变量。
    写内存:当写一个 volatile 变量时，JMM 会把该线程对应的本地内存中的共享变量值刷新到主内存。这样就保证了volatile的内存可见性。
需求：通过volatile关键字解决高并发可见性问题
volatile与synchronized的区别
    修饰成员不同
        volatile修饰成员变量和类变量
        同步机制用于方法和代码块
    采用机制不同
        使访问被volatile修饰的线程工作内存中该变量副本无效
        同步锁机制清空工作内存
    解决范围不同
        volatile只解决可见性问题
        锁机制解决原子性问题和可见性问题
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

