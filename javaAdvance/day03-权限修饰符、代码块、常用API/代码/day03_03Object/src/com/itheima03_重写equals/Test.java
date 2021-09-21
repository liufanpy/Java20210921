package com.itheima03_重写equals;

/*
概述:public boolean equals(Object obj)：指示其他某个对象是否与此对象“相等”。
应用:
    equals方法用于比较两个对象地址值是否相同
    如果要改变比较规则，需要对该方法进行重写
    一般根据成员属性进行比较
自定义比较步骤
    比较两个对象的地址值是否相同，如果相同，返回true
    如果参数为空，或者类型不一致，返回false
    将参数转换为当前类型
    比较两个对象的内容是否相同，并返回比较结果
需求：通过学生类重写Object中的equals方法演示比较两个学生

 */
public class Test {
    public static void main(String[] args) {
        Student s1 = new Student("张三", 18);
        Student s2 = new Student("李四", 20);
        System.out.println(s1.equals(s2));
        Student s3 = new Student("张三", 18);
        System.out.println(s1.equals(s3));
        System.out.println("--------");
        Student s4 = new Student();//name=null  age=0
        System.out.println(s4.equals(s1));//java.lang.NullPointerException
    }
}
