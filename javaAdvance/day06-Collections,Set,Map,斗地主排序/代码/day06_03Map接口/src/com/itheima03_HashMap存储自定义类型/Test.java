package com.itheima03_HashMap存储自定义类型;

import java.util.HashMap;
import java.util.Set;

/*
概述:当给HashMap中存放自定义对象时，如果自定义对象作为key存在，这时要保证对象唯一，必须复写对象的hashCode和equals方法
需求：将包含姓名和年龄的学生对象作为键, 家庭住址作为值，存储到map集合中(学生姓名相同并且年龄相同视为同一名学生)。

 */
public class Test {
    public static void main(String[] args) {
        //创建集合对象
        HashMap<Student, String> hm = new HashMap<>();
        //创建学生对象
        Student s1 = new Student("张三", 18);
        Student s2 = new Student("李四", 20);
        Student s3 = new Student("张三", 20);
        Student s4 = new Student("张三", 18);
        //添加学生对象和对应的地址
        hm.put(s1, "北京");
        hm.put(s2, "上海");
        hm.put(s3, "广州");
        hm.put(s4, "深圳");
        //遍历数据
        Set<Student> stus = hm.keySet();
        for (Student key : stus) {
            String value = hm.get(key);
            System.out.println(key + "---" + value);
        }
    }
}
