package com.itheima02_接口的基本实现;

/*
概述
    类与接口的关系为实现关系，即类实现接口，该类可以称为接口的实现类。
    实现的动作类似继承，只是关键字不同，实现使用 implements关键字。
    实现情况分类：非抽象类实现接口、抽象类实现接口。
基本实现的格式:
    非抽象类实现接口
        public class 类名 implements 接口名 {// 重写接口中抽象方法【必须】}
    抽象类实现接口
        public abstract class 类名 implements 接口名 {//重写接口中默认方法【可选】}
接口中成员的使用特点
    静态常量  	通过所在接口名调用(推荐)或实现类直接访问。
    抽象方法	实现类为非抽象类必须重写，为抽象类，则可以不实现
    默认方法	实现类可以直接继承，可以重写，通过实现类的对象来调用。
    静态方法	只能通过所在接口名调用
需求:定义一个父接口演示基本实现中的格式及访问规则

 */
public class Test {
    public static void main(String[] args) {
        InterImpl ii = new InterImpl();
        // 通过所在接口名调用(推荐)或实现类直接访问。
        System.out.println(ii.NUM);
        System.out.println(MyInter.NUM);
        // 实现类可以直接继承，可以重写，通过实现类的对象来调用。
        ii.defaultMehtod();
        ii.defaultMehtod2();
        //只能通过所在接口名调用
        // ii.staticMethod();
        MyInter.staticMethod();
    }
}
