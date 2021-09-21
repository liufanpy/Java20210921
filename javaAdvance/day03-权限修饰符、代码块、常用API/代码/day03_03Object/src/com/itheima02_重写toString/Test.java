package com.itheima02_重写toString;

/*
概述:public String toString()：返回该对象的字符串表示。
应用:
    展示类中内容
    输出语句中展示的是该内容的字符串表现形式
    如果打印的的对象没有打印地址值，则说明该类已重写toString方法
需求：通过学生类重写Object中的toString方法展示学生对象内容

 */
public class Test {
    public static void main(String[] args) {
        Student s = new Student("张三", 18);
        // 输出语句中展示的是该内容的字符串表现形式
        // System.out.println(s);
        System.out.println(s.toString());
        String s2 = "abc";
        System.out.println(s2.toString());//String类中重写了toString。所以打印的不是地址值
    }
}
