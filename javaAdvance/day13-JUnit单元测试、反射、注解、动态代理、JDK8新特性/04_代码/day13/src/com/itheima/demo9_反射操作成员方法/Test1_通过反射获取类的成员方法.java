package com.itheima.demo9_反射操作成员方法;

import java.lang.reflect.Method;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/18 11:19
 */
public class Test1_通过反射获取类的成员方法 {
    public static void main(String[] args) throws Exception {
        // 获取Person类的Class对象
        Class<Person> c = Person.class;

        // 需求: 通过反射获取第1个成员方法
        Method show1M = c.getDeclaredMethod("show1");
        System.out.println("show1M:" + show1M);

        // 需求: 通过反射获取第2个成员方法
        Method show2M = c.getDeclaredMethod("show2", int.class, String.class);
        System.out.println("show2M:" + show2M);

        // 需求: 通过反射获取第3个成员方法
        Method show3M = c.getDeclaredMethod("show3", int.class);
        System.out.println("show3M:" + show3M);

        // 需求: 通过反射获取第4个成员方法
        Method show4M = c.getDeclaredMethod("show4");
        System.out.println("show4M:" + show4M);

        // 需求: 通过反射获取第5个成员方法
        Method show5M = c.getDeclaredMethod("show1", int.class, String.class);
        System.out.println("show5M:" + show5M);

        System.out.println("-------------");
        // 需求: 通过反射获取所有成员方法
        Method[] arr = c.getDeclaredMethods();
        for (Method m : arr) {
            System.out.println("m:" + m);
        }

    }
}
