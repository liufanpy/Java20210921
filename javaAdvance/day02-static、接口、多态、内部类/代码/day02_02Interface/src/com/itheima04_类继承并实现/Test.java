package com.itheima04_类继承并实现;

/*
实现类可以在继承一个类的同事，实现多个接口。
多实现格式:[ ]表示可选操作
    class 类名 [extends 父类名] implements 接口名1,接口名2,接口名3... {
        // 重写接口中抽象方法【必须】 重写接口中默认方法【不重名时可选】
    }
继承并实现同名成员使用特点
    静态常量  同多实现。
    抽象方法  同多实现。
    父类与接口成员/默认方法相同，子类优先继承及使用类中的成员方法
    父类与接口静态方法相同，子类优先使用父类中的静态方法，且可以不通过所在类名调用。
需求：定义一个接口和一个父类及一个实现类，演示优先级的问题

 */
public class Test {
    public static void main(String[] args) {
        Zi z = new Zi();
        z.defaultMethod();
        z.staticMethod();//了解
        Fu.staticMethod();
        // Zi.staticMethod(); 了解
    }
}
