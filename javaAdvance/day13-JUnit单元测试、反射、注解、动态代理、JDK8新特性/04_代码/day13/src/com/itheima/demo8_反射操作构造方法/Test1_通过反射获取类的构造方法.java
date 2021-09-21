package com.itheima.demo8_反射操作构造方法;

import java.lang.reflect.Constructor;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/18 10:54
 */
public class Test1_通过反射获取类的构造方法 {

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

        // 需求5:通过反射获取所有构造方法
        Constructor<?>[] arr = c.getDeclaredConstructors();
        for (Constructor<?> con : arr) {
            System.out.println("con:" + con);
        }

    }

}
