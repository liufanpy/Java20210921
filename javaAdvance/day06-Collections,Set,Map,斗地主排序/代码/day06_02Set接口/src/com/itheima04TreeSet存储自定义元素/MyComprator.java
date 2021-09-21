package com.itheima04TreeSet存储自定义元素;

import java.util.Comparator;

public class MyComprator implements Comparator<Teacher> {
    @Override
    public int compare(Teacher o1, Teacher o2) {
        System.out.println("o1：" + o1+"---"+"o2：" + o2);
        //o1 正则添加的数据
        //o2 集合中已经添加的数据
        //(重点记忆)升序  o1  vs  o2
        //(重点记忆)降序  o2  vs  o1

        //升序
        //优先按照姓名排序
        int num = o1.getName().compareTo(o2.getName());
        num = (num == 0) ? o1.getAge() - o2.getAge() : num;
        return num;
    }
}
