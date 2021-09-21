package com.itheima.demo6_反射获取字节码对象;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/18 10:18
 */
public class Test {
    public static void main(String[] args)throws Exception {
        // 1.方式一: 类名.class
        Class<Person> c1 = Person.class;

        // 2.方式二: 对象名.getClass();
        Person p = new Person();
        Class<? extends Person> c2 = p.getClass();

        // 3.方式三: Class.forName("类的全名(包名+类名)")
        Class<?> c3 = Class.forName("com.itheima.demo6_反射获取字节码对象.Person");

        // 注意: 类的字节码对象在内存中只有一份，多次获取，拿到的都是同一个字节码对象
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c1==c2);// true
        System.out.println(c2==c3);// true


    }

}
