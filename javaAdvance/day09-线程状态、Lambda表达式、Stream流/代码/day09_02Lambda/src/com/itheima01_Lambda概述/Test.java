package com.itheima01_Lambda概述;

/*
概述
    JDK8开始一个新语法。它是一种“代替语法”。
    Lambda表达式,替换以前的接口对象实现 ，本质是一个匿名内部类的简易实现。
编程思想
    “面向对象”的编程思想:必须依靠对象,通过对象调用方法来完成功能
        例如:在调用Thread()的构造方法： 1).先定义Runnable实现类；2).创建实现类对象；3).传入实现类对象；
    函数式编程思想：在写法上要比较简洁，注重代码的实现过程。
        例如:在调用Thread()的构造方法：不需要定义实现类;不需要创建具体的子类对象;只需要传入一个“方法”即可。
需求:通过Runnable做100次循环遍历，分别演示面向对象编程(自定义实现类、匿名内部类、匿名内部类简化)与函数式编程。
*/
public class Test {
    public static void main(String[] args) {
        //自定义实现类
        // MyRunnable mr1 = new MyRunnable();
        // Thread t1 = new Thread(mr1, "线程1");
        // t1.start();
        //匿名内部类
        // Runnable mr2 = new Runnable() {
        //     @Override
        //     public void run() {
        //         for (int i = 0; i < 100; i++) {
        //             System.out.println(Thread.currentThread().getName() + "第" + i + "次运行");
        //         }
        //     }
        // };
        // Thread t2 = new Thread(mr2, "线程2");
        // t2.start();
        // 匿名内部类简化
        // Thread t3 = new Thread(new Runnable() {
        //     @Override
        //     public void run() {
        //         for (int i = 0; i < 100; i++) {
        //             System.out.println(Thread.currentThread().getName() + "第" + i + "次运行");
        //         }
        //     }
        // }, "线程3");
        // t3.start();
        // 函数式编程
        Thread t4 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "第" + i + "次运行");
            }
        }, "线程4");
        t4.start();
    }
}
