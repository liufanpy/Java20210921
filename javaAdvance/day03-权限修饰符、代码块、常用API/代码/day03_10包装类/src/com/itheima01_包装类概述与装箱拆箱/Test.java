package com.itheima01_包装类概述与装箱拆箱;

/*
概述:
    Java提供了两个类型系统，基本类型与引用类型，基本类型效率更高。
    为了便于操作，java为在lang包下为基本类型创建了对应的引用类型，称为包装类
    由于分类较多，接下来的讲解统一以Integer为例类。
包装类分类
    | 类型   | byte | short | int     | long | float | double | char      | boolean |
    | ------ | ---- | ----- | ------- | ---- | ----- | ------ | --------- | ------- |
    | 包装类 | Byte | Short | Integer | Long | Float | Double | Character | Boolean |
构造方法
    public Integer(int value)  根据 int 值创建 Integer 对象(过时)
    public Integer(String s)  根据 String 值创建 Integer 对象(过时)
常用方法
    public static Integer valueOf(int i)  返回表示指定的 int 值的 Integer   实例
    public static Integer valueOf(String s)  返回保存指定String值的 Integer 对象
    public static int intValue() 返回Integer对象的int形式
装箱与拆箱概述:
    装箱：从基本类型转换为对应的包装类对象(构造方法/valueOf)。
    拆箱：从包装类对象转换为对应的基本类型(intValue)
需求：演示装箱与拆箱

 */
public class Test {
    public static void main(String[] args) {
        // 装箱:基本类型--->包装类
        int i = 10;
        Integer ii1 = new Integer(i);
        System.out.println(ii1);
        String i2 = "20";
        Integer ii2 = new Integer(i2);
        System.out.println(ii2);
        int i3 = 30;
        Integer ii3 = Integer.valueOf(i3);
        System.out.println(ii3);
        String i4 = "40";
        Integer ii4 = Integer.valueOf(i4);
        System.out.println(ii4);
        System.out.println("--------");
        // 拆箱  包装类 ---->基本数据类型
        Integer ii5 = new Integer(10);

        int i5 = ii5.intValue();
        System.out.println(i5);

        // System.out.println(Integer.toBinaryString(10));
    }
}

