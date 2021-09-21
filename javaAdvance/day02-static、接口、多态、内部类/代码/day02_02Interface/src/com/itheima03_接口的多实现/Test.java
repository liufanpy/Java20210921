package com.itheima03_接口的多实现;


/*
实现类可以同时实现多个接口的，这叫做接口的多实现。
多实现格式:
    class 类名 implements 接口名1,接口名2,接口名3... {
        // 重写接口中抽象方法【必须】 重写接口中默认方法【不重名时可选】
    }
多实现的同名成员使用特点
    静态常量  只能通过所在接口名调用。
    抽象方法  实现类为非抽象类必须重写1次(含同名)，抽象类，则可以不实现
    默认方法  实现类是否抽象都必须重写1次。
    静态方法  只能通过所在接口名调用。
需求:定义两个个父接口演示基本实现中的格式及访问规则
 */
public class Test {
    public static void main(String[] args) {
        InterImpl ii = new InterImpl();
        // 只能通过所在接口名调用。
        // System.out.println(ii.NUM);
        System.out.println(MyInterA.NUM);
        System.out.println(MyInterB.NUM);
        ii.abstractMethod();
        ii.defaultMethod();
        // 只能通过所在接口名调用。
        // ii.staticMethod();
        MyInterA.staticMethod();
        MyInterB.staticMethod();
    }
}
