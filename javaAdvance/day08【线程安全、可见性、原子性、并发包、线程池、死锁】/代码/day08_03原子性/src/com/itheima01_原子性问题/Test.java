package com.itheima01_原子性问题;

/*
概述:原子性是指在一组符合一定逻辑的操作，要么所有的操作都得到了执行不被中断，要么所有的操作都不执行，多个操作是一个不可以分割的整体。
    举例:张三账户给李四1000元。`张三账户扣除1000元`，`李四账户增加1000元`，这两个动作要么都发生，要么都不发生。
需求:通过主线程和子线程对一个变量各递增10000次，预期得到结果20000。
原子性问题总结:
    执行结果与预期结果存在误差
分析:
    count++操作包含3个步骤
        从主内存中读取数据到工作内存
        对工作内存中的数据进行++操作
        将工作内存中的数据写回到主内存
    count+没有被保障是一个原子性操作，也就是在以上3个步骤，随时会被另一个线程打断，从而导致不可预计的线程安全问题出现。
*/
public class Test {
    public static void main(String[] args) {
        AtomicThread at = new AtomicThread();
        at.start();
        //主线程中也对该变量增加10000次
        for (int i = 0; i < 10000; i++) {
            at.count++;
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
