package com.itheima05_TreeMap存储自定义类型;

public class Student implements Comparable<Student> {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
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
    public int compareTo(Student s) {
        //this 正在添加的     s代表的是已存在
        //升序  this  vs  s
        //降序  s  vs  this

        int num = this.name.compareTo(s.name);
        num = (num == 0) ? this.age - s.age : num;
        return num;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
