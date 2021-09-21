package com.itheima03_可变参数;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
概述:在JDK1.5之后，定义了可变参数，用来表示一个方法需要接受的多个同类型参数。
格式:参数类型... 形参名
注意事项:
    一个方法只能有一个可变参数
    如果方法中有多个参数，可变参数要放到最后。
应用场景:Collections工具类中的添加元素等方法:
    public static <T> boolean addAll(Collection<T> c,T...elements):往集合中添加一些元素。
需求：演示可变参数在集合工具的添加方法中的应用

 */
public class Test {
    public static void main(String[] args) {
        show(1, 2, 3, 4, 5);
        System.out.println("--------");
        show2(100, 1, 2, 3, 4, 5);
        System.out.println("--------");
        // public static <T> boolean addAll(Collection<T> c,T...elements)
        List<String> list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list);
        System.out.println("--------");
        Collections.addAll(list, "d", "e", "f");
        System.out.println(list);
    }

    public static void show(int... arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void show2(int num, int... arr) {
        System.out.println(num);
        System.out.println(Arrays.toString(arr));
    }
    //如果方法中有多个参数，可变参数要放到最后。
    // public static void show3(int... arr,int num) {
    //     System.out.println(num);
    //     System.out.println(Arrays.toString(arr));
    // }
}
