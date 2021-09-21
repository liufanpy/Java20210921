package com.itheima01_权限修饰符.B;

import com.itheima01_权限修饰符.A.FuA;

public class OtherB {
    public void show(){
        FuA fa = new FuA();
        System.out.println("不同包无关类中的公共的成员变量:"+ fa.pubInt);
        // System.out.println("不同包无关类中的受保护的成员变量:"+fa.proInt);//不同包 无关类的受保护的内容不能直接访问
        // System.out.println("不同包无关类中的默认的成员变量:"+ fa.mInt);//不同包下的，无关类中的默认内容子类不能直接访问
        // System.out.println("不同包无关类中的私有成员变量:"+fa.priInt);//私有内容之内在本类中直接访问
    }
}
