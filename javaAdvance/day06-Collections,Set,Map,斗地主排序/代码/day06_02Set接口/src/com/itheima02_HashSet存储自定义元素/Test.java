package com.itheima02_HashSet存储自定义元素;

import java.util.HashSet;

/*
概述:
    HashSet存储对象,是根据继承自Object类中的hashCode方法和equals方法的值进行判定存储
    默认的hashCode和equals方法是通过地址值计算，在实际开发中我们一般需要重写对象这两个方法
    两个对象相同，保留原来的对象。
需求:通过HashSet存储自定义学生类型对象

 */
public class Test {
    public static void main(String[] args) {
        //创建集合对象
        HashSet<Student> hs = new HashSet<>();
        //创建学生对象--学生类(重写hashCode和equals)
        Student s1 = new Student("张三", 18, "1");
        Student s2 = new Student("李四", 20);
        Student s3 = new Student("张三", 20);
        Student s4 = new Student("张三", 18, "2");
        //添加学生对象
        hs.add(s1);
        hs.add(s2);
        hs.add(s3);
        hs.add(s4);
        //查看数据
        for (Student s : hs) {
            System.out.println(s.getName() + "..." + s.getAge() + "..." + s.flag);
        }
    }
}
