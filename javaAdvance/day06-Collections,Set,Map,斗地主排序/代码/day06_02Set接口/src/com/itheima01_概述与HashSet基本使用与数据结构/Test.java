package com.itheima01_概述与HashSet基本使用与数据结构;

import java.util.HashSet;
import java.util.Set;

/*
概述:
    java.util.Set接口继承自Collection接口，是单列集合的一个重要分支。
    实现了Set接口的对象称为Set集合。
    Set集合无索引，只能是用增强for和迭代器遍历
Set集合特点
    元素无索引,元素存取无序,元素不可重复(唯一)
常用子类
    java.util.HashSet：哈希表结构集合
    java.util.LinkedHashSet：链表结构集合
    java.util.TreeSet：树结构集合

HashSet概述:
    java.util.HashSet是Set接口的一个实现类
    底层的实现其实是一个java.util.HashMap支持
    根据对象的哈希值来确定元素在集合中的存储位置，具有良好的存储和查找性能
特点
    元素无索引,元素存取无序,元素不可重复(唯一)
需求：在测试类中演示HashSet的基本使用

数据结构
    JDK1.8之前，哈希表底层采用数组+链表，
    JDK1.8开始，哈希表存储采用数组+链表+红黑树。
元素唯一代码原理:
    hashCode决定存储的列数(相同则一列)，equals是否存在相同元素
    jdk8为提高查询效率，当一列数据达到8个且总数据达到64个，则增加数组长度，重新排列数据数据


 */
public class Test {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<>();
        hs.add("a");
        hs.add("a");
        hs.add("a");
        hs.add("b");
        hs.add("c");
        System.out.println(hs);

        System.out.println("Aa".hashCode());
        System.out.println("BB".hashCode());
    }
}
