package com.itheima.p01概述与基本实现;

/*
递归：指在当前方法内调用自己的这种现象。
    出口：递归的结束条件，确定什么时候结束递归。
    规律：确定什么时候进行递归调用。
递归格式
        public static void 方法名(形参){
            方法名(实参);
        }
注意:递归调用的次数不能过多，否则会导致内存溢出。
需求：控制一个方法重复执行1000次
    出口:最后一次，就不要再调用method方法
    规律:没有到达最后一次，继续调用method方法

 */
public class Test {
    public static void main(String[] args) {
        method(1000);
    }

    public static void method(int count) {
        System.out.println("第"+count+"次执行");
        if (count == 0) {
            return;
        }
        count--;
        method(count);
    }
}
