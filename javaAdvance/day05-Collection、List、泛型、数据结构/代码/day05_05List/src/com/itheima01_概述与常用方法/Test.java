package com.itheima01_概述与常用方法;

import java.util.ArrayList;
import java.util.List;

/*
`java.util.List`接口继承自`Collection`接口，是单列集合的一个重要分支，实现了`List`接口的类称为List集合。
List接口特点
    它是一个元素存取有序的集合
    它是一个带有索引的集合，通过索引就可以精确的操作集合中的元素
    集合中可以有重复的元素，通过元素的equals方法，来比较是否为重复的元素
常用方法
    public void add(int index, E element): 将指定的元素，添加到该集合中的指定位置上
    public E get(int index):返回集合中指定位置的元素
    public E remove(int index): 移除列表中指定位置的元素, 返回的是被移除的元素
    public E set(int index, E element):用指定元素替换集合中指定位置的元素,返回修改前的元素
需求：通过ArrayList类演示常用方法
 */
public class Test {
    public static void main(String[] args) {
        //创建List集合对象
        List<String> list = new ArrayList();
        //添加元素
        list.add("abc");
        list.add("def");
        System.out.println(list);
        System.out.println("--------");
        // public void add(int index, E element): 将指定的元素，添加到该集合中的指定位置上
        list.add(0,"欧阳毅文");
        System.out.println(list);
        System.out.println("--------");
        // public E get(int index):返回集合中指定位置的元素
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        // System.out.println(list.get(3));
        System.out.println("--------");
        //public E remove(int index): 移除列表中指定位置的元素, 返回的是被移除的元素
        list.remove(1);
        System.out.println(list);
        System.out.println("--------");
        // public E set(int index, E element):用指定元素替换集合中指定位置的元素,返回修改前的元素
        list.set(1,"李震");
        System.out.println(list);
    }
}
