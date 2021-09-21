package com.itheima.demo11_序列化的注意事项;

import java.io.Serializable;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/15 15:21
 */
public class Student implements Serializable {// 被序列化的对象所属的类一定要实现Serializable接口(标记接口)
    String name;
    // 如果被序列化的对象的属性不想被序列化,那么该属性就需要使用transient关键字修饰,表示瞬态
    transient int age;
    // 被序列化的对象所有的属性也是要可以被序列化的
    Pet pet;

    public Student(String name, int age,Pet pet) {
        this.name = name;
        this.age = age;
        this.pet = pet;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", pet=" + pet +
                '}';
    }
}
