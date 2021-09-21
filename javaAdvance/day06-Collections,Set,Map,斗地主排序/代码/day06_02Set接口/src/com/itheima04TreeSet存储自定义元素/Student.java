package com.itheima04TreeSet存储自定义元素;

import java.util.Objects;

public class Student implements Comparable<Student> {
    String num;
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student(String num, String name, int age) {
        this.num = num;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "num='" + num + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Student s) {
        //this代表的是正则添加的元素
        //s 代表的是集合中已经存储的元素

        // 返回值:
        //正数  添加的放到 被比较元素的后面
        //0    代表两个内容相同，不添加
        //负数  添加的放到 被比较元素的前面
        //(重点记忆)升序  this  vs  s
        //(重点记忆)降序  s  vs  this
        // System.out.println("this：" + this+"---"+"s：" +s);
        //考虑到 要用过姓名和年龄综合排序，所以需要使用这两个内容得到最终的num值
        //考虑到 排序，有可能优先按照姓名排序，也有可能优先按照年龄排序
        //想用谁优先做比较，就把谁放到前面，优先比较差值
        //优先按照年龄排序
        /*
        int num = s.age-this.age;
        // num =(num==0)?s.name.compareTo(this.name):s.age-this.age;
        num =(num==0)?s.name.compareTo(this.name):num;
        return num;
        */
        // return  (s.age-this.age==0)?s.name.compareTo(this.name):s.age-this.age;
        return (s.name.compareTo(this.name) == 0) ? s.age - this.age : s.name.compareTo(this.name);
    }
}
