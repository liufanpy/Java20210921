package com.itheima02_迭代器常见异常及原理;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
常见异常
    java.util.NoSuchElementException		没有集合元素异常
    ConcurrentModificationException		    并发修改异常
需求：通过ArrayList类演示迭代器常见异常
迭代器实现原理:
    - 步骤1：创建迭代器对象，初始化指针，指向0索引位置。
    - 步骤2：hasNext()判断当前指针位置是否有内容。
    - 步骤3：如果有，返回true执行next方法：获取当前位置内容，并将指针后移，回步骤2。
    - 步骤4：如果没有，返回false，表明指针已到末尾，没有可迭代元素，结束迭代。
 */
public class Test {
    public static void main(String[] args) {
        //创建集合
        Collection<String> c = new ArrayList<>();
        //添加元素
        c.add("abc");
        c.add("def");
        c.add("ghi");
        //获取迭代器对象
        Iterator<String> it = c.iterator();
        //迭代数据
        while (it.hasNext()) {
            String s =it.next();//实际开发这么干,用一个变量接收，后面重复使用这个变量
            System.out.println("操作1:" + it.next());//java.util.ConcurrentModificationException
            // System.out.println("操作2:" + it.next());//java.util.NoSuchElementException
            c.add("jkl");
        }
    }
}
