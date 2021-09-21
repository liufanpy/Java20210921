package com.itheima02_线程池基本实现2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
线程池的思想
    当出现并发数量大，线程任务简单，就会造成系统短时间大量创建线程对象，造成资源浪费。
    如果可以使得创建出来的线程对象能够重复被利用，可以避免因为大量创建对象，导致内存浪费。
线程池的概念
    一个容纳多个线程的容器，其中的线程可以反复使用，省去了频繁创建线程对象的操作，无需反复创建线程而消耗过多资源。
    工作线程:线程池中存储的线程对象，在没有任务时，出于等待状态，可循环使用。
    任务队列:用于存放没有处理的任务，一种缓冲机制。
    任务接口:每个任务必须实现的接口，以供工作线程调度任务的执行。
    线程池管理器:用于创建并管理线程池，包括创建线程池，销毁线程池，添加新任务。
线程池三个好处
    降低资源消耗。
    提高响应速度。
    提高线程的可管理性。

线程池概述
    java.util.concurrent.Executor.是线程池的顶级接口。
    java.util.concurrent.ExecutorService.严格意义上讲，ExecutorService才是真正的线程池接口。
    java.util.concurrent.Executors.线程工厂类，提供了一些静态工厂，生成一些常用的线程池。
创建线程池对象
    public static ExecutorService newFixedThreadPool(int nThreads)  返回线程池对象。
常用方法
    public Future<?> submit(Runnable task):获取线程池中的某一个线程对象，并执行
    public Future<?> submit(Callable task):获取线程池中的某一个线程对象，并执行
Future接口：用来记录线程任务执行完毕后产生的结果,拥有get方法返回结果.
    V get()   : 获取计算完成的结果。

使用步骤
    创建线程池对象。
    创建Runnable/Callable接口子类对象。(task)
    提交Runnable/Callable接口子类对象。(submit(task))
    关闭线程池(一般不做)。
需求:使用子线程模拟两个教练教游泳。
*/
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //通过Callable接口实现
        // 创建线程池对象。
        ExecutorService es = Executors.newFixedThreadPool(1);
        // 创建Runnable/Callable接口子类对象。(task)
        RandomCallable rc = new RandomCallable();
        // 提交Runnable/Callable接口子类对象。(submit(task))
        Future<Integer> f = es.submit(rc);
        //通过Future对象获取多线程执行完后返回的结果
        Integer integer = f.get();
        System.out.println(integer);
        // 关闭线程池(一般不做)。
    }
}
