package com.itheima01_权限修饰符.A;

public class ZiA extends FuA {
    public void show(){
        System.out.println("父类中的公共的成员变量:"+ pubInt);
        System.out.println("父类中的受保护的成员变量:"+proInt);
        System.out.println("父类中的默认的成员变量:"+ mInt);
        // System.out.println("父类中的私有的成员变量:"+priInt);//私有内容之内在本类中直接访问
    }
}
