package com.itheima02_比较器的使用;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
概述:public interface Comparator<T>  定义比较对象规则的接口
常用方法:
    public int compare(T  o1,T  o2) 比较用来排序的两个参数
应用场景:Collections工具类中的排序静态排序方法:
    <T> void sort(List<T> list，Comparator<? super T> ):将集合中元素按照指定规则排序。
需求：演示Comparator在集合工具类排序功能中的使用

 */
public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(3);
        System.out.println(list);
        //进行排序
        // <T> void sort(List<T> list，Comparator<? super T> )
        MyComparator mc = new MyComparator();
        Collections.sort(list, mc);
        System.out.println(list);
    }
}
