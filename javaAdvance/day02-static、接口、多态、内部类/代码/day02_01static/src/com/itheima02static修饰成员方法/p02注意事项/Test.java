package com.itheima02static修饰成员方法.p02注意事项;

/*
注意事项:
    静态方法可以直接访问类变量和静态方法。
    静态方法不能直接访问普通成员变量或成员方法。
    成员方法可以直接访问类变量或静态方法。
    静态方法中，不能使用this关键字。
需求：通过测试类演示静态方法注意事项

 */
public class Test {
    static int num=10;
    int num2=999;
    public static void main(String[] args) {
        //静态方法可以直接访问类变量和静态方法。
        System.out.println(num);
        staticMethod();
        //静态方法不能直接访问普通成员变量或成员方法。
        // System.out.println(num2);
        // method();
    }

    public static void staticMethod(){
        System.out.println("我是一个静态方法");
    }
    public  void method(){
        System.out.println("我是一个非静态方法");
    }
    public void show(){
        //成员方法可以直接访问类变量或静态方法。
        System.out.println(num);
        staticMethod();
    }
}
