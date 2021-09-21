package com.itheima02_泛型的定义及使用.p01含有泛型的类的定义和使用;

/*
概述:泛型是数据类型的一部分，将类名与泛型合并一起看做数据类型，定义对象时，确定泛型类型。
定义格式
    修饰符 class 类名<代表泛型的变量> { }
使用格式
    属性类型<泛型类型> 变量名  = new 数据类型<泛型类型>();
    属性类型<泛型类型> 变量名  = new 数据类型<>();
需求：定义带有泛型的类，并将该泛型应用到参数和返回值类型中

 */
public class Test {
    public static void main(String[] args) {
        // GenericsClass<String> gc = new GenericsClass();
        // GenericsClass<String> gc = new GenericsClass<String>();
        GenericsClass<String> gc = new GenericsClass<>();

        // gc.show(10);
        gc.show("abc");
        String s = gc.get();
        System.out.println(s);
    }
}
