package comitheima02_自定义线程类创建线程;

/*
步骤
    定义Thread类的子类，并重写该类的run()方法
    创建Thread子类的实例，即创建了线程对象
    调用线程对象的start()方法来启动该线程
需求：通过继承Thread类方式创建线程对象

 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        //创建线程对象
        MyThread mt = new MyThread("gogogo:");
        //启动线程
        mt.start();

        //主线程中也开始打印100个数
        for (int i = 0; i < 100; i++) {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + ":i=" + i);
        }
    }
}
