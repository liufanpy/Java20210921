package com.itheima01_String引入;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
概述
    java.util.stream.Stream<T>是Java 8新加入的最常用的流接口（不是函数式接口）。
    JDK8中为了支持Lambda，制作了一些应用—Stream就是一个典型的应用。
    Stream流：是一个接口，功能类似于迭代器，但更强大，可以对数据进行过滤、筛选、汇总等操作。
需求：使用集合与Stream流中的方法完成下列需求
    定义一个集合，存储若干姓名
    将List集合中姓张的的元素过滤到一个新的集合中
    然后将过滤出来的姓张的元素中过滤出长度为3的元素,存储到一个新的集合中

*/
public class Test {
    public static void main(String[] args) {
        //普通方式
        method1();
        // Stream流
        // 定义一个集合，存储若干姓名
        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("赵六");
        list.add("孙七");
        list.add("周八");
        list.add("张三丰");
        
        list.stream().filter((String name) -> {
            return name.startsWith("张");
        }).filter((String name) -> {
            return name.length() == 3;
        }).forEach((String name) -> {
            System.out.println(name);
        });
    }

    public static void method1() {
        // 定义一个集合，存储若干姓名
        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("赵六");
        list.add("孙七");
        list.add("周八");
        list.add("张三丰");
        // 将List集合中姓张的的元素过滤到一个新的集合中
        List<String> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String name = list.get(i);
            if (name.startsWith("张")) {
                list1.add(name);
            }
        }
        // 然后将过滤出来的姓张的元素中过滤出长度为3的元素,存储到一个新的集合中
        List<String> list2 = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            String name = list1.get(i);
            if (name.length() == 3) {
                list2.add(name);
            }
        }
        System.out.println(list2);
    }
}
