package comitheima01_多线程与Thread类概述;

/*
并行与并发
    并行：指两个或多个事件在同一时刻发生（同时执行），微观上的同时运行，多个 CPU 系统中，执行多个程序，每一时刻可以同时执行多个线程
    并发：指两个或多个事件在同一个时间段内发生(交替执行)，宏观上的同时运行，单个CPU系统中，执行多个程序，每一时刻只能执行一个线程，感觉是同时运行
进程与线程
    进程:是程序在内存中的一次执行过程，是系统运行程序的基本单位，系统运行一个程序即是一个进程从创建、运行到消亡的过程一个应用程序可以同时运行多个进程
    线程：线程是进程中的一个执行单元，负责当前进程中程序的具体执行，一个进程中至少有一个线程，如果有多个线程，该应用被称为多线程应用
进程与线程的区别
    进程：有独立的内存空间，进程中的数据存放空间（堆空间和栈空间）是独立的，至少有一个线程
    线程：堆空间是共享的，栈空间是独立的，线程消耗的资源比进程小的多
线程调度
    当一个CPU时，以某种顺序执行多个线程，我们把这种情况称之为线程调度
    随机性:进程中的多个线程，本质上是依赖于并发式运行，具体哪个线程什么时候被CPU调用执行，程序员并不能直接完全决定
    分时调度:所有线程轮流使用 CPU 的使用权，平均分配每个线程占用 CPU 的时间
    抢占式调度:优先让优先级高的线程使用 CPU，如果线程的优先级相同，那么会随机选择一个(线程随机性)，Java使用的为抢占式调度

Thread概述:
    java.lang.Thread类代表线程，所有的线程对象都必须是Thread类或其子类的实例
    每个线程的作用是完成一定的任务，实际上就是执行一段程序流即一段顺序执行的代码
    Java使用线程执行体来代表这段程序流，在Tread线程中，使用run()方法代表线程执行体
构造方法
    public Thread():分配一个新的线程对象
    public Thread(String name):分配一个指定名字的新的线程对象
    public Thread(Runnable target):分配一个带有指定目标新的线程对象
    public Thread(Runnable target,String name):分配一个带有指定目标新的线程对象并指定名字
常用方法
    public String getName():获取当前线程名称
    public void start():导致此线程开始执行; Java虚拟机调用此线程的run方法
    public void run():此线程要执行的任务在此处定义代码
    public static void sleep(long millis):使当前正在执行的线程以指定的毫秒数暂停执行
    public static Thread currentThread()  :返回对当前正在执行的线程对象的引用


 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread("我的第一个线程");
        t.start();
        Thread.sleep(3000);
        System.out.println(t.getName());

        System.out.println(Thread.currentThread().getName());
    }
}
