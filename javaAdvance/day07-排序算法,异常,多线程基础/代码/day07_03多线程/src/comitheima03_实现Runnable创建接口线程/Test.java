package comitheima03_实现Runnable创建接口线程;

/*
步骤
    定义Runnable接口的实现类，并重写该接口的run()方法。
    创建Runnable实现类的实例，作为Thread的构造参数创建Thread对象。
    调用Thread线程对象的start()方法来启动线程
需求：通过实现Runnable方式部类创建对象

使用Runnable的优势
    Runnable适合多个相同的程序代码的线程去共享同一个资源
    Runnable可以避免java中的单继承的局限性
    Runnable方式增加程序的健壮性，实现解耦操作，代码既可以被多个线程使用又保持了与线程的独立性
    线程池只能放入实现Runable或Callable类线程，不能直接Thread或其子类


 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        //创建实现类对象
        MyRunnable mr = new MyRunnable();
        //创建线程对象，并将Runnable实现类对象作为参数
        Thread t = new Thread(mr, "gogogo:");
        t.start();

        //主线程中也开始打印100个数
        for (int i = 0; i < 100; i++) {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + ":i=" + i);
        }
    }
}
