package com.itheima04TreeSet存储自定义元素;

import java.util.TreeSet;

/*
概述:
    TreeSet集合是Set接口的一个实现类，底层依赖于TreeMap,是一种基于红黑树的实现
    TreeSet集合存储的对象必须拥有排序规则(比较器)，否则会报出异常。
自然排序:
    对象类实现 java.lang.Comparable接口，重写compare方法，使用TreeSet无参构造创建集合对象
比较器排序:
    创建重写compare方法的Comparator接口实现类对象,使用TreeSet有参构造【TreeSet(Comparator<E> comparator)】创建集合对象
特点
    元素无索引,元素存取无序,元素不可重复(唯一)，元素可排序
需求：通过TreeSet存储自定义学生类和老师类型对象演示两种排序方式

 */
public class Test {
    public static void main(String[] args) {
        // 自然排序
        TreeSet<Student> ts = new TreeSet<>();
        // Student s = new Student("张三", 18);
        // ts.add(s);
        //Student cannot be cast to class java.lang.Comparable
        ts.add(new Student("1", "zhangsan", 18));
        System.out.println("--------");
        ts.add(new Student("2", "lisi", 20));
        System.out.println("--------");
        ts.add(new Student("3", "zhangsan", 20));
        System.out.println("--------");
        ts.add(new Student("4", "zhangsan", 18));

        for (Student s : ts) {
            System.out.println(s);
        }

        // 比较器排序
        MyComprator mc = new MyComprator();
        TreeSet<Teacher> ts2 = new TreeSet<>( mc);
        ts2.add(new Teacher("zhangsan", 18));
        System.out.println("--------");
        ts2.add(new Teacher("lisi", 20));
        System.out.println("--------");
        ts2.add(new Teacher("zhangsan", 20));
        System.out.println("--------");
        ts2.add(new Teacher("zhangsan", 18));
        for (Teacher s : ts2) {
            System.out.println(s);
        }
    }
}
