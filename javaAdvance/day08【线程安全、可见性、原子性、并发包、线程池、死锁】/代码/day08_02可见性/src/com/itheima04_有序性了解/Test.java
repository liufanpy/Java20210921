package com.itheima04_有序性了解;

/*
@author  jolfe
@date  2021/1/18
正常情况:  0 false ;  10,false; 10,true
重拍后的异常情况:  true,0 ;
*/
public class Test {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        mt.start();
        System.out.println(mt.i1);
        System.out.println(mt.b1);
    }
}
