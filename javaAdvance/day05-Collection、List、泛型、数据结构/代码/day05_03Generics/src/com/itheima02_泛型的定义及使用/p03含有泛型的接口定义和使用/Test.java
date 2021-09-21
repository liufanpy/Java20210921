package com.itheima02_泛型的定义及使用.p03含有泛型的接口定义和使用;

/*
概述:泛型接口约束实现类是含有泛型的类型，实现类要么保留泛型，要么指定泛型的数据类型
定义格式
    修饰符 interface 接口名 <代表泛型的变量> { }
使用格式
    修饰符 class 类名 implements  接口名 <数据类型> { }
    修饰符 class 类名<代表泛型的变量> implements  接口名 <代表泛型的变量> { }
需求：定义泛型接口,将泛型接口应用到方法的返回值类型与参数中

 */
public class Test {
    public static void main(String[] args) {
        //实现类指定了数据类型
        GenericsInterImpl1 gii1 = new GenericsInterImpl1();
        gii1.show("abc");
        String s1 = gii1.get();
        System.out.println(s1);
        System.out.println("--------");
        GenericsInterImpl2<String> gii2 = new GenericsInterImpl2();
        gii2.show("def");
        String s2 = gii2.get();
        System.out.println(s2);
    }
}
