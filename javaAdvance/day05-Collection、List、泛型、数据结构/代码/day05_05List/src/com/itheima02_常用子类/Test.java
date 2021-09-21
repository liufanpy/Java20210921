package com.itheima02_常用子类;

import java.util.LinkedList;
import java.util.List;

/*
java.util.ArrayList集合数据存储的结构是数组结构
    ArrayList集合特点：查询快,增删慢,线程不安全
java.util.LinkedList集合数据存储的结构是双向链表结构
    LinkedList集合特点：查询慢,增删快,线程不安全
    LinkedList集合也可以作为堆栈，队列的结构使用
    实现原理:双向链表
LinkedList集合常见方法(了解)
    public void addFirst(E e):将指定元素插入此列表的开头
    public void addLast(E e):将指定元素添加到此列表的结尾
    public E getFirst():返回此列表的第一个元素
    public E getLast():返回此列表的最后一个元素
    public E removeFirst():移除并返回此列表的第一个元素
    public E removeLast():移除并返回此列表的最后一个元素
    public E pop():从此列表所表示的堆栈处弹出一个元素
    public void push(E e):将元素推入此列表所表示的堆栈
    public boolean isEmpty()：如果列表不包含元素，则返回true
需求：演示LinkedList类常用方法
 */
public class Test {
    public static void main(String[] args) {
        //创建集合对象
        LinkedList<String> list = new LinkedList<>();
        //添加元素
        list.add("bbb");
        list.add("bbb");
        list.add("bbb");
        System.out.println(list);
        System.out.println("--------");
        // public void addFirst(E e):将指定元素插入此列表的开头
        list.addFirst("aaa");
        System.out.println(list);
        System.out.println("--------");
        // public void addLast(E e):将指定元素添加到此列表的结尾
        list.addLast("ccc");
        System.out.println(list);
        System.out.println("--------");
        // public E getFirst():返回此列表的第一个元素
        System.out.println(list.getFirst());
        System.out.println(list);
        System.out.println("--------");
        // public E getLast():返回此列表的最后一个元素
        System.out.println(list.getLast());
        System.out.println(list);
        System.out.println("--------");
        // public E removeFirst():移除并返回此列表的第一个元素
        System.out.println(list.removeFirst());
        System.out.println(list);
        System.out.println("--------");
        // public E removeLast():移除并返回此列表的最后一个元素
        System.out.println(list.removeLast());
        System.out.println(list);
        System.out.println("--------");
        // public E pop():从此列表所表示的堆栈处弹出一个元素
        System.out.println(list.pop());
        System.out.println(list);
        System.out.println("--------");
        // public void push(E e):将元素推入此列表所表示的堆栈
        list.push("ddd");
        System.out.println(list);
        System.out.println("--------");
        // public boolean isEmpty()：如果列表不包含元素，则返回true
        System.out.println(list.isEmpty());
    }
}
