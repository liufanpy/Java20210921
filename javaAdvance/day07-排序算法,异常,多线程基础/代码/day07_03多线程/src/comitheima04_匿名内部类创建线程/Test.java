package comitheima04_匿名内部类创建线程;

/*
概述:匿名内部类方式，可以方便的实现每个线程执行不同的线程任务操作。
实现方式:
    使用匿名内部类的方式实现Runnable接口
    重写Runnable接口中的run方法
    将匿名内部类创建的接口对象传入Thread对象
    调用start方法执行线程
需求：通过匿名内部类创建多线程对象执行操作

 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
/*        //用匿名内部类创建一个Runnable的实现类对象
        Runnable r = new Runnable() {
            //重写方法

            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ie) {

                    }
                    System.out.println(Thread.currentThread().getName() + "i=" + i);
                }
            }
        };
        //创建线程对象
        Thread t = new Thread(r, "gogogo:");*/
        Thread t = new Thread(new Runnable() {
            //重写方法

            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ie) {

                    }
                    System.out.println(Thread.currentThread().getName() + "i=" + i);
                }
            }
        }, "gogogo:");
        //启动线程
        t.start();


        //主线程中也开始打印100个数
        for (int i = 0; i < 100; i++) {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + ":i=" + i);
        }
    }
}
