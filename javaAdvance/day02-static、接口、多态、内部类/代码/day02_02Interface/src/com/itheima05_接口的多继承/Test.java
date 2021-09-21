package com.itheima05_接口的多继承;

/*
接口与接口之间是继承关系，且支持多继承。
多继承格式:
    权限修饰符 interface 子接口名 extends 父接口名1,父接口名2,...{
    }
多继承访问规则:
    如果父接口中的默认方法有重名的，那么子接口需要重写一次。
需求：定义两个父接口一个子接口演示接口的继承

 */
public class Test {
    public static void main(String[] args) {
        InterImpl ii = new InterImpl();
        ii.defaultMethod();
    }
}
