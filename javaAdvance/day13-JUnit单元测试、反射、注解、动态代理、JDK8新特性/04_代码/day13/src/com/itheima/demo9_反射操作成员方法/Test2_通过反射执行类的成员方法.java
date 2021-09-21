package com.itheima.demo9_反射操作成员方法;

import java.lang.reflect.Method;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/18 11:19
 */
public class Test2_通过反射执行类的成员方法 {
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

        // 通过反射获取Person类的对象
        Person p = c.getDeclaredConstructor().newInstance();

        // 需求: 通过反射执行show1M封装的成员方法
        show1M.invoke(p);// 相当于执行 p.show1();

        // 需求: 通过反射执行show2M封装的成员方法
        Object res1 = show2M.invoke(p, 100, "java");// 相当于执行  res1 = p.show2(100, "java");
        System.out.println("res1:"+res1);

        // 需求: 通过反射执行show3M封装的成员方法
        show3M.invoke(p,200);// 相当于执行 p.show3(200);

        // 需求: 通过反射执行show4M封装的成员方法
        Object res2 = show4M.invoke(p);// 相当于执行 res2 = p.show4()
        System.out.println("res2:"+res2);

        // 需求: 通过反射执行show5M封装的成员方法
        show5M.setAccessible(true);
        Object res3 = show5M.invoke(p, 300, "php");// 相当于执行  res3 = p.show1(300, "php")
        System.out.println("res3:"+res3);

    }
}
