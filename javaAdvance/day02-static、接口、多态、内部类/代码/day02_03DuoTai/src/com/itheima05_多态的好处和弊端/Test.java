package com.itheima05_多态的好处和弊端;

/*
多态的好处
    可以将方法的参数定义为父类引用，使程序编写的更简单，提高程序的灵活性，扩展性
多态的弊端
    无法访问子类/实现类的独有方法
需求：通过如下类演示形参多态好处和弊端
Fu类
    行为:method
Zi类
    行为:method   show


 */
public class Test {
    public static void main(String[] args) {
        //多态的格式
        Fu f = new Zi();
        f.method();
        //父类引用调用子类特有的show方法,因为编译看左边，父类中没有show方法，所以编译报错
        // f.show();
    }
}
