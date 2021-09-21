package com.itheima01_概述及常用功能;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
java.utils.Collections是集合工具类，用来对集合进行操作。
常用方法
    public static void shuffle(List<?> list) :打乱集合顺序。
    public static <T> void sort(List<T> list):将集合中元素按照默认规则排序。
需求：演示集合工具类中的功能
 */
public class Test {
    public static void main(String[] args) {
        //创建List集合
        List<String> list = new ArrayList<>();
        //添加数据
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list);
        //public static void shuffle(List<?> list)
        Collections.shuffle(list);
        System.out.println(list);
        // public static <T> void sort(List<T> list)
        Collections.sort(list);
        System.out.println(list);
    }
}
