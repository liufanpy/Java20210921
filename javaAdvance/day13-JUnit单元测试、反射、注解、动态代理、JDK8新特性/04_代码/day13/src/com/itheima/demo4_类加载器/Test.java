package com.itheima.demo4_类加载器;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/18 9:53
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("Person类的类加载器: "+Person.class.getClassLoader());
    }
}
