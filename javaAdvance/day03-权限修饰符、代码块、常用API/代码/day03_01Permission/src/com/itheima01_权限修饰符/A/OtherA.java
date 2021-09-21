package com.itheima01_权限修饰符.A;

public class OtherA {
    public void show(){
        FuA fa = new FuA();
        System.out.println("同包无关类中的公共的成员变量:"+ fa.pubInt);
        System.out.println("同包无关类中的受保护的成员变量:"+fa.proInt);
        System.out.println("同包无关类中的默认的成员变量:"+ fa.mInt);
        // System.out.println("同包无关类中的私有成员变量:"+fa.priInt);//私有内容之内在本类中直接访问
    }
}
