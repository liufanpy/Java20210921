package com.itheima.demo8_lombok的使用;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/21 10:49
 */
public class Test {
    public static void main(String[] args) {
        // 创建Student对象--满参
        Student stu1 = new Student("李四",18,100);

        // 创建Student对象--空参
        Student stu2 = new Student();
        stu2.setName("李四");
        stu2.setAge(18);
        stu2.setScore(100);
        System.out.println(stu2.getName()+","+stu2.getAge()+","+stu2.getScore());

        System.out.println(stu1);
        System.out.println(stu2);

        System.out.println(stu1.equals(stu2));// true
        System.out.println(stu1.hashCode());// 相同的哈希值
        System.out.println(stu2.hashCode());// 相同的哈希值

    }
}
