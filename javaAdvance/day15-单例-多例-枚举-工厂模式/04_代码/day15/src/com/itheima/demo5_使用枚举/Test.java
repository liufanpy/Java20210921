package com.itheima.demo5_使用枚举;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/21 9:52
 */
public class Test {
    public static void main(String[] args) {
        // 格式: 枚举类型.枚举值
        // 创建Person对象
        Person p1 = new Person();
        p1.setName("张三");
        p1.setSex(Sex.BOY);

        // 创建Person对象
        Person p2 = new Person("李四", Sex.GIRL);

        // 打印输出
        System.out.println("p1:" + p1);
        System.out.println("p2:" + p2);
    }
}
