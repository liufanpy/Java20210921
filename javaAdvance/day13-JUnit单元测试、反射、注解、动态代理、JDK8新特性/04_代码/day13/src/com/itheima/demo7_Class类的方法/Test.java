package com.itheima.demo7_Class类的方法;

import com.itheima.demo6_反射获取字节码对象.Person;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/18 10:29
 */
public class Test {
    public static void main(String[] args) throws Exception{
        // 获取Person类字节码对象
        Class<Person> c = Person.class;

        //String getSimpleName(); 获得类名字符串：类名
        System.out.println("类名: "+c.getSimpleName());

        //String getName();  获得类全名：包名+类名
        System.out.println("类的全名: "+c.getName());

        //T newInstance() ;  创建Class对象关联类的对象---相当于调用该类的空参构造方法
        Person p = c.newInstance();// 相当于执行了new Person();

    }
}
