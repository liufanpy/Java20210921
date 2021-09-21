package com.itheima.demo3_多例设计模式;

import java.util.ArrayList;
import java.util.Random;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/21 9:13
 */
// 多例设计模式: 保证该类只有3个对象产生
public class Person {
    // 1.将构造方法私有化,防止外界通过new调用构造方法创建对象
    private Person() {

    }

    // 2.在该类的内部创建固定数量的该类对象
    private static ArrayList<Person> list = new ArrayList<>();

    static {
        for (int i = 0; i < 3; i++) {
            // 创建该类的对象
            Person p = new Person();
            // 添加到集合中
            list.add(p);
        }
    }

    // 3.提供一个公共的静态方法随机返回一个该类的对象
    public static Person getInstance(){
        // 创建Random对象
        Random r = new Random();

        // 生成一个随机索引
        int index = r.nextInt(list.size());

        // 根据索引取对象,返回
        return list.get(index);
    }

}
