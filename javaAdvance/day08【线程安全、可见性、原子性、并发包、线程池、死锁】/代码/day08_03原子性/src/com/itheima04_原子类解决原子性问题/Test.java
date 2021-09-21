package com.itheima04_原子类解决原子性问题;


/*
概述:
    java.util.concurrent.atomic包(简称Atomic包)，java从JDK1.5开始，提供了一系列，用法简单，性能高效，线程安全的，更新变量的类，统称为原子类。
原子包中的类
    AtomicInteger 原子类型的int值		AtomicLong 原子类型的long值
    AtomicReference 原子类型的对象	AtomicReferenceArray 原子类型的对象数组
    AtomicIntegerArray 原子类型的int数组		AtomicLongArray 原子类型的long数组
构造方法:
    public AtomicInteger()    初始化一个默认值为0的原子型Integer
    public AtomicInteger(int initialValue)    初始化一个指定值的原子型Integer
常用方法
    int get():   		获取值
    int getAndIncrement():	以原子方式将当前值加1，注意，这里返回的是自增前的值。
    int incrementAndGet():     	以原子方式将当前值加1，注意，这里返回的是自增后的值。
    int addAndGet(int data):	以原子方式将输入的数值与实例中的值相加，并返回结果。
    int getAndSet(int value):   	以原子方式设置为newValue的值，并返回旧值。
需求：使用AtomicInteger对解决高并发原子性问题
*/
public class Test {
    public static void main(String[] args) {
        AtomicThread at = new AtomicThread();
        at.start();
        //主线程中也对该变量增加10000次
        for (int i = 0; i < 10000; i++) {
                at.count.getAndIncrement();
        }
        //为了确保子线程执行完成，所以需要在这里睡一会
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("count的最终结果是:" + at.count);
    }
}
