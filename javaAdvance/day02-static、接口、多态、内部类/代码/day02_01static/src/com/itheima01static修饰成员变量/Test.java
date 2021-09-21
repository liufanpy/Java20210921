package com.itheima01static修饰成员变量;

/*
概念:static是静态修饰符，表示静态的意思,可以修饰成员变量和成员方法以及代码块。
理解:static修饰成员位置变量，称为类变量。该类的每个对象都共享同一个类变量的值。任何对象都可更改该变量的值，且可在不创建该类对象情况下对该变量操作。
定义格式:
    修饰符 static 数据类型 变量名；
使用格式:
    类名.类变量名；
需求:定义一个中国人类，利用类变量定义所有人的国籍。

 */
public class Test {
    public static void main(String[] args) {
        ChinesePeople cp1 = new ChinesePeople("王维康", 18);
        System.out.println("name：" + cp1.name + ",age=" + cp1.age +",country="+ cp1.country);
        ChinesePeople cp2 = new ChinesePeople("李震", 20);
        System.out.println("name：" + cp2.name + ",age=" + cp2.age +",country="+ cp2.country);
        System.out.println("--------");
        // cp1.country="中国";
        ChinesePeople.country="中国";
        System.out.println("name：" + cp1.name + ",age=" + cp1.age +",country="+ cp1.country);
        System.out.println("name：" + cp2.name + ",age=" + cp2.age +",country="+ cp2.country);
    }
}
