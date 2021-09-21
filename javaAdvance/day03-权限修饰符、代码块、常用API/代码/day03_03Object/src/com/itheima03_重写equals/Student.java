package com.itheima03_重写equals;

import java.util.Objects;

public class Student {
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

    /*@Override
    public boolean equals(Object o) {//  this    o-- 学生对象
        // 比较两个对象的地址值是否相同，如果相同，返回true
        if (this == o) {
            return true;
        }
        // 如果参数为空，或者类型不一致，返回false
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        // 将参数转换为当前类型
        Student s = (Student) o;//向下转型
        // 比较两个对象的内容是否相同，并返回比较结果
        //这里this的name有可能为null,就会造成空指针异常
        return this.name.equals(s.name) && this.age == s.age;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name);
    }


}
