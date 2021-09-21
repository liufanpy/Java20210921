package com.itheima01_权限修饰符.A;

public class FuA {
    public int pubInt = 10;
    protected int proInt = 20;
    int mInt = 30;
    private int priInt = 40;

    public void show(){
        System.out.println("本类中的公共的成员变量:"+ pubInt);
        System.out.println("本类中的受保护的成员变量:"+proInt);
        System.out.println("本类中的默认的成员变量:"+ mInt);
        System.out.println("本类中的私有成员变量:"+priInt);
    }
}
