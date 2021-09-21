package com.itheima01_泛型概述与应用;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
泛型：JDK5之后，新增了泛型(Generic)语法，可以在类、接口或方法中预支地使用未知的类型
泛型的应用
    泛型使开发者在设计API时可以指定类或方法支持泛型，使得API开发与使用变得更为简洁，并得到了编译时期的语法检查。
    集合中默认以Object类型存储数据，这样不便于管理数据，容易造成转换异常(ClassCastException)通常Collection利用泛型，存储同一类型对象。
泛型的好处
    将运行时期的ClassCastException，转移到了编译时期
    避免了类型强转的麻烦
需求：使用ArrayList集合存储内容，通过遍历，将元素转回字符串类型

 */
public class Test {
    public static void main(String[] args) {
        // 将运行时期的ClassCastException，转移到了编译时期
        Collection<String> c = new ArrayList<>();
        c.add("abc");
        // c.add(10);
        // c.add('a');
        show(c);

    }

    public static void show(Collection<String> c) {
        // Iterator it = c.iterator();
        //避免了类型强转的麻烦
        Iterator<String> it = c.iterator();
        while (it.hasNext()) {
            String s = it.next();//java.lang.ClassCastException
        }
    }
}
