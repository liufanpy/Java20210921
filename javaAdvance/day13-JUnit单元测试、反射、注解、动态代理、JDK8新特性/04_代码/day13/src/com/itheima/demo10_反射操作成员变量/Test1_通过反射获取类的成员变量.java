package com.itheima.demo10_反射操作成员变量;

import java.lang.reflect.Field;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/18 11:58
 */
public class Test1_通过反射获取类的成员变量 {
    public static void main(String[] args) throws Exception {
        // 获取Person类的Class对象
        Class<Person> c = Person.class;

        // 需求: 通过反射获取第1个成员变量
        Field f1 = c.getDeclaredField("name");
        System.out.println("f1:" + f1);

        // 需求: 通过反射获取第2个成员变量
        Field f2 = c.getDeclaredField("age");
        System.out.println("f2:" + f2);

        // 需求: 通过反射获取第3个成员变量
        Field f3 = c.getDeclaredField("sex");
        System.out.println("f3:" + f3);

        System.out.println("-----");

        // 需求: 通过反射获取所有成员变量
        Field[] arr = c.getDeclaredFields();
        for (Field field : arr) {
            System.out.println("field:" + field);
        }
    }
}
