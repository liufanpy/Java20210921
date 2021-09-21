package com.itheima01_代码块;

/*
常见使用:构造代码块、静态代码块
    构造代码块：就是定义在成员位置的代码块。
        格式:{  //执行语句  }
        执行时机:每次创建对象都会执行构造代码块,优先于构造方法执行
    静态代码块：就是定义在成员位置使用static修饰的代码块。
        格式:static{  //执行语句  }
        执行时机:每次创建对象都会执行构造代码块,优先于构造方法执行

执行顺序:静态代码块--构造代码块--构造方法
留个问题:静态代码块--构造代码块--构造方法  main方法在哪个位置？
需求：在Person类中定义构造代码块和静态代码块，观察执行效果


 */
public class Test {
    public static void main(String[] args) {

        Person p = new Person();
        System.out.println("--------");
        Person p2 = new Person();

    }
}
