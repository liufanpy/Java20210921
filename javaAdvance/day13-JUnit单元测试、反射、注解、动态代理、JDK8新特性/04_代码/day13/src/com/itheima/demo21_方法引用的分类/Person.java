package com.itheima.demo21_方法引用的分类;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/18 17:19
 */
public class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
