package com.itheima04_Objects;

import java.util.Objects;

/*
概述:
    java.util.Objects：JDK7中添加，用来操作对象的工具类。
    由nullsave（空指针安全的)或nulltolerant（容忍空指针的)两类方法组成
    用于计算对象的hashCode值、返回对象的字符串表示形式、比较两个对象等。
常见功能:
    public static boolean equals(Object a, Object b):判断两个对象是否相等。
    源码
        public static boolean equals(Object a, Object b) {
            return (a == b) || (a != null && a.equals(b));
        }
需求：演示Objects类与Object类中equals方法使用区别
 */
public class Test {
    public static void main(String[] args) {
        String s1 =null;
        String s2="abc";
        // System.out.println(s1.equals(s2));//java.lang.NullPointerException
        System.out.println(Objects.equals(s1, s2));

    }

}
