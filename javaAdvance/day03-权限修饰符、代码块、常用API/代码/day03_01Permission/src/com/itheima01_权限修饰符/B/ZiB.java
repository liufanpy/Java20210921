package com.itheima01_权限修饰符.B;

import com.itheima01_权限修饰符.A.FuA;

public class ZiB extends FuA {
    public void show(){
        System.out.println("不同包的父类中的公共的成员变量:"+ pubInt);
        System.out.println("不同包的父类中的受保护的成员变量:"+proInt);
        // System.out.println("不同包的父类中的默认的成员变量:"+ mInt);//不同包下的，父类中的默认内容子类不能直接访问
        // System.out.println("不同包的父类中的私有的成员变量:"+priInt);//私有内容之内在本类中直接访问
    }
}
