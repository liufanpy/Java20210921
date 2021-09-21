package com.itheima03_线程池练习;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
需求:使用线程池方式执行任务,返回1-100的和
分析:因为需要返回求和结果,所以使用Callable方式的任务

*/
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(1);
        SumCallable sc = new SumCallable();
        Future<Integer> submit = es.submit(sc);
        Integer i = submit.get();
        System.out.println("1-100的和是:" + i);
    }
}
