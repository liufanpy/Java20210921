package com.itheima05_TreeMap存储自定义类型;

import java.util.Comparator;

public class MyComparator implements Comparator<Teacher> {
    @Override
    public int compare(Teacher t1, Teacher t2) {
        //t1 正在添加的     t2代表的是已存在
        //升序 t1  vs  t2
        //降序  t2  vs  t1

        int num = t2.getName().compareTo(t1.getName());
        num = (num == 0) ? t2.getAge() - t1.getAge() : num;
        return num;
    }
}
