package com.itheima05_TreeMap存储自定义类型;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/*
概述:
    TreeMap是Map子类，底层由红黑树实现，可以对元素的键进行排序。
    TreeMap集合存储的对象如果作为键，必须拥有排序规则(比较器)，否则会报出异常
自然排序:
    对象类实现 java.lang.Comparable接口，重写compare方法，使用TreeMap无参构造创建集合对象
比较器排序:
    创建重写compare方法的Comparator接口子类对象,作为参数传递给TreeMap构造方法【TreeMap(Comparator<? super K> comparator)】
需求：通过TreeMap存储自定义学生类和老师类型对象演示两种排序方式


 */
public class Test {
    public static void main(String[] args) {
        //自然排序
        /*TreeMap<Student, String> ts = new TreeMap<>();
        ts.put(new Student("张三", 18), "北京");
        ts.put(new Student("李四", 20), "上海");
        ts.put(new Student("张三", 20), "广州");
        ts.put(new Student("张三", 18), "深圳");
        //遍历
        Set<Map.Entry<Student, String>> entries = ts.entrySet();
        for (Map.Entry<Student, String> entry : entries) {
            Student key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "---" + value);
        }*/
        System.out.println("--------");
        // 比较器排序
        MyComparator mc = new MyComparator();
        TreeMap<Teacher, String> ts2 = new TreeMap<>(mc);
        ts2.put(new Teacher("张三", 18), "北京");
        ts2.put(new Teacher("李四", 20), "上海");
        ts2.put(new Teacher("张三", 20), "广州");
        ts2.put(new Teacher("张三", 18), "深圳");
        //遍历
        Set<Map.Entry<Teacher, String>> entries2 = ts2.entrySet();
        for (Map.Entry<Teacher, String> entry : entries2) {
            Teacher key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "---" + value);
        }
    }
}
