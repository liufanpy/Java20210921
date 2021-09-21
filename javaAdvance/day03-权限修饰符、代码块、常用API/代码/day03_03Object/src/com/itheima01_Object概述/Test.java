package com.itheima01_Object概述;

/*
概述:
java.lang.Object 类是Java语言中的根类，即所有类的父类。
常用方法(Object中包含11个)
    public String toString()： 返回该对象的字符串表示。
        默认返回：对象的类型名+@+内存地址值字符串形式。
    public boolean equals(Object obj)：指示其他某个对象是否与此对象“相等”。
        默认返回:通过==运算符比较两个对象地址值是否相同的布尔结果
需求：通过定义人类和学生类，展示toString方法和equals方法的直接与间接继承

 */
public class Test {
    public static void main(String[] args) {
        Person p = new Person();
        System.out.println(p.toString());
        Student s= new Student();
        System.out.println(s);

        System.out.println(p.equals(s));
        System.out.println(p.equals(p));
    }
}
