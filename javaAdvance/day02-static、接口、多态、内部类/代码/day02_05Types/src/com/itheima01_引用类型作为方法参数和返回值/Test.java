package com.itheima01_引用类型作为方法参数和返回值;

/*
需求：定义如下类，演示引用类型作为方法形参和返回值类型
    人类
    属性：姓名
    行为：吃饭

 */
public class Test {
    public static void main(String[] args) {
        Person p = new Person();
        p.setName("大春");
        showPerson(p);
        System.out.println("--------");
        Person p2 = getPerson();
        p2.setName("刘煜鑫");
        showPerson(p2);
    }

    public static void showPerson(Person p) {
        System.out.println(p.getName());
        p.eat();
    }

    public static Person getPerson() {
        return new Person();
    }
}
