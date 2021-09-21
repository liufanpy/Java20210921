package com.itheima04_Stream案例演示;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/*
需求：使用集合与Stream流两种方式，利用循环，实现如下需求
    定义两个ArrayList集合，代表两个队伍，存储多个姓名，依次进行以下操作
    第一个队伍只要名字为3个字的成员姓名；
    第一个队伍筛选之后只要前2个人；
    第二个队伍只要姓张的成员姓名；
    第二个队伍筛选之后不要前2个人；
    将两个队伍合并为一个队伍；
    根据姓名创建Person对象并存储到集合；
    打印整个队伍的Person对象信息。
*/
public class Test {
    public static void main(String[] args) {
        //普通版
        method1();
        //Stream版
        method2();
    }

    public static void method2() {
        //0. 定义两个ArrayList集合，代表两个队伍，存储多个姓名，依次进行以下操作
        List<String> listOne = new ArrayList<>();
        listOne.add("迪丽热巴");
        listOne.add("宋远桥");
        listOne.add("苏星河");
        listOne.add("老子");
        listOne.add("庄子");
        listOne.add("孙子");
        listOne.add("洪七公");
        List<String> listTwo = new ArrayList<>();
        listTwo.add("古力娜扎");
        listTwo.add("张无忌");
        listTwo.add("张三丰");
        listTwo.add("赵丽颖");
        listTwo.add("张二狗");
        listTwo.add("张天爱");
        listTwo.add("张三");

        // 第一个队伍只要名字为3个字的成员姓名；
        // 第一个队伍筛选之后只要前2个人；
        Stream<String> listOneAll = listOne.stream().filter((String name) -> {
            return name.length() == 3;
        }).limit(2);
        // 第二个队伍只要姓张的成员姓名；
        // 第二个队伍筛选之后不要前2个人；
        Stream<String> listTwoAll = listTwo.stream().filter((String name) -> {
            return name.startsWith("张");
        }).skip(2);
        // 将两个队伍合并为一个队伍；
        Stream<String> listAll = Stream.concat(listOneAll, listTwoAll);
        // 根据姓名创建Person对象并存储到集合；
        Stream<Person> listAllPerson =listAll.map((String name)->{return new Person(name)  ;});
        // 打印整个队伍的Person对象信息。
        listAllPerson.forEach((Person p)->{
            System.out.println(p);
        });

    }

    public static void method1() {
        //0. 定义两个ArrayList集合，代表两个队伍，存储多个姓名，依次进行以下操作
        List<String> listOne = new ArrayList<>();
        listOne.add("迪丽热巴");
        listOne.add("宋远桥");
        listOne.add("苏星河");
        listOne.add("老子");
        listOne.add("庄子");
        listOne.add("孙子");
        listOne.add("洪七公");
        List<String> listTwo = new ArrayList<>();
        listTwo.add("古力娜扎");
        listTwo.add("张无忌");
        listTwo.add("张三丰");
        listTwo.add("赵丽颖");
        listTwo.add("张二狗");
        listTwo.add("张天爱");
        listTwo.add("张三");
        //普通方式
        // 第一个队伍只要名字为3个字的成员姓名；
        List<String> listOne1 = new ArrayList<>();
        for (int i = 0; i < listOne.size(); i++) {
            String name = listOne.get(i);
            if (name.length() == 3) {
                listOne1.add(name);
            }
        }
        // 第一个队伍筛选之后只要前2个人；
        List<String> listOne2 = new ArrayList<>();
        for (int i = 0; i < listOne1.size(); i++) {
            String name = listOne1.get(i);
            if (i <= 1) {
                listOne2.add(name);
            }
        }
        // 第二个队伍只要姓张的成员姓名；
        List<String> listTwo1 = new ArrayList<>();
        for (int i = 0; i < listTwo.size(); i++) {
            String name = listTwo.get(i);
            if (name.startsWith("张")) {
                listTwo1.add(name);
            }
        }
        // 第二个队伍筛选之后不要前2个人；
        List<String> listTwo2 = new ArrayList<>();
        for (int i = 0; i < listTwo1.size(); i++) {
            String name = listTwo1.get(i);
            if (i >= 2) {
                listTwo2.add(name);
            }
        }
        // 将两个队伍合并为一个队伍；
        List<String> listAll = new ArrayList<>();
        for (int i = 0; i < listOne2.size(); i++) {
            String name = listOne2.get(i);
            listAll.add(name);
        }
        for (int i = 0; i < listTwo2.size(); i++) {
            String name = listTwo2.get(i);
            listAll.add(name);
        }
        // 根据姓名创建Person对象并存储到集合；
        List<Person> listAllPerson = new ArrayList<>();
        for (int i = 0; i < listAll.size(); i++) {
            String name = listAll.get(i);
            Person p = new Person(name);
            listAllPerson.add(p);
        }
        // 打印整个队伍的Person对象信息。
        System.out.println(listAllPerson);
    }
}
