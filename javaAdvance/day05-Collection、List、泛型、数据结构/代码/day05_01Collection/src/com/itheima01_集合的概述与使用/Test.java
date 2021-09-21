package com.itheima01_集合的概述与使用;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/*
集合:是java中提供的一种容器，可以用来存储多个引用数据类型的数据
集合分类:单列集合、双列集合
集合与数组的区别
    长度
      数组的长度是固定的
      集合的长度是可变的
    存储范围
      数组可以存储基本类型+引用类型
      集合只能存储引用类型
    存储内容
      数组需指定存储类型
      集合默认存储Object类型(任意内容)，也可以使用泛型指定要存储的内容类型
      开发中无论是数组还是集合，一般情况建议一个集合\数组存储同一种数据类型
java.util.Collection：java.util.Collection：单列集合类的根接口，用于存储一系列符合某种规则的元素，以单个对象作为存储元素的集合类型。
单列集合继承体系
    java.util.List	有序单列集合接口
        特点:元素有索引，元素有序(先进先出)、元素可重复
            java.util.ArrayList 	数组结构，查询快,增删慢,线程不安全
            java.util.LinkedList    链表结构，查询慢,增删快,线程不安全
            java.util.Vector    	数组结构，查询较快,增删慢,线程安全
    java.util.Set 	 无序单列集合接口
        特点：元素无索引，元素无序、元素不可重复
            java.util.HashSet		哈希结构，不可排序
            java.util.LinkedHashSet		链表+哈希表结构，可排序
            java.util.TreeSet		二叉树结构，可排序
构造方法:由于Collection是一个接口，不能创建对象，需要使用其子类ArrayLiist等类型来创建对象。
常用功能
        public boolean add(E e)：  把给定的对象添加到当前集合中
        public boolean remove(E e): 把给定的对象在当前集合中删除
        public boolean contains(Object obj): 判断当前集合是否包含给定的对象
        public boolean isEmpty(): 判断当前集合是否为空
        public int size(): 返回集合中元素的个数
        public Object[] toArray(): 把集合中的元素，存储到数组中
        public void clear():清空集合中所有的元素
需求：通过ArrayList类演示单列集合常用功能
 */
public class Test {
    public static void main(String[] args) {
        //创建集合对象
        //不加泛型，代表存储的类型是Object类型，可以存储任意类型数据
        // Collection c  = new ArrayList();
        Collection<String> c = new ArrayList();
        //添加数据
        c.add("姜鹏程");
        // c.add(10);
        // c.add(10.0);
        c.add("欧阳毅文");
        c.add("李震");
        System.out.println(c);
        System.out.println("--------");
        // public boolean remove(E e): 把给定的对象在当前集合中删除
        System.out.println("remove："+c.remove("李震"));
        System.out.println("remove："+c.remove("lizhen"));
        System.out.println(c);
        System.out.println("--------");
        // public boolean contains(Object obj): 判断当前集合是否包含给定的对象
        System.out.println("contains："+c.contains("姜鹏程"));
        System.out.println("contains："+c.contains("jiangpengcheng"));
        System.out.println("--------");
        // public boolean isEmpty(): 判断当前集合是否为空
        System.out.println("isEmpty："+c.isEmpty());
        System.out.println("--------");
        // public int size(): 返回集合中元素的个数
        System.out.println("size："+c.size());
        System.out.println("--------");
        // public Object[] toArray(): 把集合中的元素，存储到数组中
        Object[] orr = c.toArray();
        System.out.println("toArray："+Arrays.toString(orr));
        System.out.println("--------");
        // public void clear():清空集合中所有的元素
        c.clear();
        System.out.println("isEmpty："+c.isEmpty());
        System.out.println("size："+c.size());
    }
}
