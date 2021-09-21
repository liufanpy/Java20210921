package com.itheima01_代码块;

public class Person {
    static {
        System.out.println("我是一个静态代码块");
    }

    {
        System.out.println("我是一个构造代码块");
    }

    public Person() {
        //留个问题: 先执行super 还是先执行本类的构造代码块？
        super();
        System.out.println("我是一个无参构造方法");
    }
}
