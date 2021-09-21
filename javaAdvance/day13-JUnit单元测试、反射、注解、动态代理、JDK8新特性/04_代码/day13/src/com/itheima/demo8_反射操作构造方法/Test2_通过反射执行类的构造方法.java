package com.itheima.demo8_反射操作构造方法;

import java.lang.reflect.Constructor;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/18 10:54
 */
public class Test2_通过反射执行类的构造方法 {

    public static void main(String[] args) throws Exception {
        // 获取类的Class对象
        Class<Person> c = Person.class;

        // 需求1:通过反射获取第1个构造方法
        Constructor<Person> con1 = c.getDeclaredConstructor();
        System.out.println("con1:" + con1);

        // 需求2:通过反射获取第2个构造方法
        Constructor<Person> con2 = c.getDeclaredConstructor(String.class, int.class);
        System.out.println("con2:" + con2);

        // 需求3:通过反射获取第3个构造方法
        Constructor<Person> con3 = c.getDeclaredConstructor(int.class);
        System.out.println("con3:" + con3);

        // 需求4:通过反射获取第4个构造方法
        Constructor<Person> con4 = c.getDeclaredConstructor(String.class);
        System.out.println("con4:" + con4);

        System.out.println("-------------------");

        // 需求: 通过反射执行con1表示的构造方法来创建Person对象
        Person p1 = con1.newInstance();
        System.out.println("p1:" + p1);

        // 需求: 通过反射执行con2表示的构造方法来创建Person对象
        Person p2 = con2.newInstance("张三", 18);
        System.out.println("p2:" + p2);

        // 需求: 通过反射执行con3表示的构造方法来创建Person对象
        Person p3 = con3.newInstance(19);
        System.out.println("p3:" + p3);

        // 需求: 通过反射执行con4表示的构造方法来创建Person对象
        // 暴力反射:取消权限检查
        con4.setAccessible(true);
        Person p4 = con4.newInstance("王五");
        System.out.println("p4:" + p4);

    }

}
