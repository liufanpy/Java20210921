package com.itheima04_LinkedHashMap存储自定义类型;


import java.util.LinkedHashMap;
import java.util.Set;

/*
概述:LinkedHashMap是HashMap子类，底层由链表和哈希表组合。要保证map中存放的key和取出的顺序一致，可以使用java.util.LinkedHashMap集合来存放
需求：使用LinkedHashMap类存储自定义学生类(学生姓名相同并且年龄相同视为同一名学生)

 */
public class Test {
    public static void main(String[] args) {
        //创建集合对象
        LinkedHashMap<Student, String> lhm = new LinkedHashMap<>();
        //创建学生对象
        Student s1 = new Student("张三", 18);
        Student s2 = new Student("李四", 20);
        Student s3 = new Student("张三", 20);
        Student s4 = new Student("张三", 18);
        //添加学生对象和对应的地址
        lhm.put(s1, "北京");
        lhm.put(s2, "上海");
        lhm.put(s3, "广州");
        lhm.put(s4, "深圳");
        //遍历数据
        Set<Student> stus = lhm.keySet();
        for (Student key : stus) {
            String value = lhm.get(key);
            System.out.println(key + "---" + value);
        }
    }
}
