package com.itheima01_概述与常用方法;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
概述:
    java.util.Map双列集合的顶层接口，用来存储具备映射关系对象的集合接口定义。
    Map集合中存储的内容根据映射关系分为两部分，称为键值对。
        键(Key)不能包含重复的键，
        值(Value)可以重复；
        每个键只能对应一个值。
Map集合与Collection集合区别
    Collection集合中的元素，是以单个的形式存储。称为单列集合
    Map集合中的元素，是以键值对的形式存储。称为双列集合
Map常用子类
    HashMap<K,V>
        存储数据采用的哈希表结构，元素的存取顺序不能保证一致。
        要保证键的唯一、不重复，需要重写键的hashCode()方法、equals()方法。
    LinkedHashMap<K,V>
        HashMap的子类，存储数据采用的哈希表结构+链表结构。
        通过链表结构可以保证元素的存取顺序一致；
        通过哈希表结构可以保证键唯一、不重复，需要重写键的hashCode()方法、equals()方法。
    TreeMap<K,V>
        TreeMap集合和Map相比没有特有的功能，底层的数据结构是红黑树；
        可以对元素的键进行排序，排序方式有两种:自然排序和比较器排序
方法介绍
    public V put(K key, V value):  把指定的键与值添加到Map集合中
        若键(key)在集合中不存在，添加指定的键和值到集合中，返回null
        若键(key)在集合中存在，对应键的原值被新值替代，返回该键对应的原值。
    public V remove(Object key): 把指定的键对应的键值对元素在Map集合删除，返回被删除元素的值
    public V get(Object key) 根据指定的键，在Map集合中获取对应的值。
    public Set<K> keySet(): 获取Map集合中所有的键，存储到Set集合中。
    public Set<Map.Entry<K,V>> entrySet(): 获取到Map集合中所有的键值对对象的集合(Set集合)。
    public boolean containKey(Object key):判断该集合中是否有此键。
需求：通过HashMap演示Map集合常用方法

 */
public class Test {
    public static void main(String[] args) {
        //创建一个Map集合对象
        Map<Integer, String> m = new HashMap<>();
        //public V put(K key, V value)
        // System.out.println(m.put(1, "a"));
        // System.out.println(m.put(1, "b"));
        m.put(1, "a");
        m.put(2, "b");
        m.put(3, "c");
        System.out.println(m);
        System.out.println("--------");
        // public V remove(Object key)
        System.out.println(m.remove(1));
        System.out.println(m.remove(4));
        System.out.println(m);
        System.out.println("--------");
        // public V get(Object key)
        System.out.println(m.get(1));
        System.out.println(m.get(2));
        System.out.println(m.get(3));
        System.out.println("--------");
        // public Set<K> keySet()
        Set<Integer> set = m.keySet();
        System.out.println(set);
        System.out.println("--------");
        // public Set<Map.Entry<K,V>> entrySet()
        Set<Map.Entry<Integer, String>> entries = m.entrySet();
        System.out.println(entries);
        System.out.println("--------");
        // public boolean containKey(Object key)
        System.out.println(m.containsKey(1));
        System.out.println(m.containsKey(2));
    }
}
