package com.itheima01_迭代器的使用;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
概述:java.util.Iterator    Collection集合元素的通用获取方式接口
集合中获取迭代器对象方法
    public Iterator<E> iterator(): 获取集合对应迭代器，遍历集合中的元素
    设计原理:提供统一获取迭代器的方式，由子类实现该方法，获取属于自己的迭代器
迭代器对象常用方法
    public E next():返回迭代的下一个元素
    public boolean hasNext():如果仍有元素可以迭代，则返回 true
需求：通过ArrayList类演示迭代器的使用

 */
public class Test {
    public static void main(String[] args) {
        //创建集合对象
        Collection<String> c = new ArrayList();
        //添加数据
        c.add("a");
        c.add("b");
        c.add("c");
        //通过集合获取迭代器对象
        Iterator<String> it = c.iterator();
        //迭代数据
        /*
        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.hasNext());
        System.out.println(it.next()); //java.util.NoSuchElementException
        */
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

}
