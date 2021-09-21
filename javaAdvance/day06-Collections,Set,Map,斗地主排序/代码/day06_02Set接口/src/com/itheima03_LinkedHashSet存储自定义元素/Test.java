package com.itheima03_LinkedHashSet存储自定义元素;

import java.util.LinkedHashSet;

/*
概述:
    java.util.LinkedHashSet 是HashSet的一个子类，底层采用链表+哈希表
    LinkedHashSet类在保留HashSet元素唯一的基础上，增加了有序性(双向链表)
特点:
    元素无索引,元素存取有序,元素不可重复(唯一)
需求:通过LinkedHashSet存储自定义学生类型对象

 */
public class Test {
    public static void main(String[] args) {
        LinkedHashSet<Student> lhs = new LinkedHashSet<>();
        Student s1 = new Student("张三", 18);
        Student s2 = new Student("李四", 20);
        Student s3 = new Student("张三", 20);
        Student s4 = new Student("张三", 18);
        lhs.add(s1);
        lhs.add(s2);
        lhs.add(s3);
        lhs.add(s4);
        //查看数据
        for (Student s : lhs) {
            System.out.println(s.getName() + "..." + s.getAge() + "..." + s.flag);
        }
    }
}
