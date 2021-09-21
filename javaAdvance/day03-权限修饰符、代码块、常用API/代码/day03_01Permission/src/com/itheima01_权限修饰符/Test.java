package com.itheima01_权限修饰符;

import com.itheima01_权限修饰符.A.FuA;
import com.itheima01_权限修饰符.A.OtherA;
import com.itheima01_权限修饰符.A.ZiA;
import com.itheima01_权限修饰符.B.OtherB;
import com.itheima01_权限修饰符.B.ZiB;

/*
权限修饰符分类
    public	：公共的。
    protected ：受保护的
    (default) ：默认的
    private   ：私有的需求:按照类的格式定义如下类

权限修饰符使用
    范围      	    public	    protected	    默认	     private
    同一类中          true        true           true       true
    同一包中          true        true           true
    不同包的子类       true        true
    不同包中的无关类    true

需求：根据如下分类演示不同权限修饰符修饰变量的使用
    包A
        Fu类
        ZiA类
        OthoerA类
    包B
        ZiB类
        OthoerB类

权限修饰符使用规则
    类：public   默认 ，一般用public。
    成员都可使用public   protected   默认  private
        成员内部类，一般用 private，隐藏细节。
        修饰成员变量 ：一般用 private，隐藏细节。
        修饰成员方法：一般用public，方便调用方法
        修饰构造方法：一般用public ，方便创建对象

 */
 public class Test {
    public static void main(String[] args) {
        FuA fa = new FuA();
        fa.show();
        System.out.println("--------");
        OtherA oa = new OtherA();
        oa.show();
        System.out.println("--------");
        ZiA za = new ZiA();
        za.show();
        System.out.println("--------");
        ZiB zb = new ZiB();
        zb.show();
        System.out.println("--------");
        OtherB ob = new OtherB();
        ob.show();
    }
}

