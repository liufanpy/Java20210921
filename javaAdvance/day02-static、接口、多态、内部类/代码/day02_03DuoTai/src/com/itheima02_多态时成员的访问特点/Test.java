package com.itheima02_多态时成员的访问特点;

/*
多态时访问特点
    成员变量:编译看左边,运行看左边  访问的是父类的成员变量
    成员方法:编译看左边,运行看右边  编译时找父类,运行时看子类
    静态方法:编译看左边,运行看左边  访问的是父类的静态方法
需求：定义子父类，演示多态时成员访问特点


 */
public class Test {
    public static void main(String[] args) {
        //父类引用指向子类对象
        Fu f = new Zi();
        // 成员变量:编译看左边,运行看左边
        System.out.println(f.num);
        // System.out.println(f.num2);编译看左边，父类中没有num2,所以编译报错
        // 成员方法:编译看左边,运行看右边
        f.method();
        // f.show();编译看左边，父类中没有show,所以编译报错
        // 静态方法:编译看左边,运行看左边
        f.staticMethod();
    }
}
