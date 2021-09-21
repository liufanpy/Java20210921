package com.itheima.demo10_反射操作成员变量;

import java.lang.reflect.Field;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/18 11:58
 */
public class Test2_通过反射操作类的成员变量 {
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

        // 通过反射创建Person类的对象
        Person p = c.getDeclaredConstructor().newInstance();

        // 需求: 通过反射给name属性赋值并取值
        f1.set(p, "张三");
        System.out.println("p对象的name属性值:" + f1.get(p) + ",name属性的类型:" + f1.getType());

        // 需求: 通过反射给age属性赋值并取值
        f2.set(p,18);
        System.out.println("p对象的age属性值:" + f2.get(p) + ",age属性的类型:" + f2.getType());

        // 需求: 通过反射给sex属性赋值并取值
        f3.setAccessible(true);// 取消权限检查
        f3.set(p,"男");
        System.out.println("p对象的sex属性值:" + f3.get(p) + ",sex属性的类型:" + f3.getType());
    }
}
