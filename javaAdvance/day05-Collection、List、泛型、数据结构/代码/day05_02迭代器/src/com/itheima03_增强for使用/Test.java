package com.itheima03_增强for使用;

import java.util.ArrayList;
import java.util.Collection;

/*
概述:
    增强for循环(foreach循环)，是JDK1.5以后出来的一个高级for循环，专门用来遍历数组和Collection集合
    内部基于Iterator迭代器实现，所以在遍历的过程中，不能对集合中的元素进行增删操作，否则抛出ConcurrentModificationException并发修改异常
格式:
    for(元素的数据类型  变量 : Collection集合or数组){
      	//写操作代码
    }
需求：通过ArrayList集合演示增强for循环

 */
public class Test {
    public static void main(String[] args) {
        //创建集合对象
        Collection<String> c = new ArrayList<>();
        //添加数据
        c.add("abc");
        c.add("def");
        c.add("ghi");
        //迭代数据
        for(String s:c){//java.util.ConcurrentModificationException
            System.out.println(s);
            // c.add("jkl");
        }
    }
}
