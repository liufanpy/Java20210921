package com.itheima.demo15_装饰者设计模式;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/15 16:22
 */
public class Test {
    public static void main(String[] args) {
        /*
            概述:装饰模式指的是在不改变原类, 不使用继承的基础上，动态地扩展一个对象的功能。
            使用步骤:
                1.装饰类和被装饰类需要实现同一个接口
                2.装饰类中需要获取被装饰类的引用(被装饰类的对象的地址)
                3.在装饰类中对需要增强的方法进行增强
                4.在装饰类中对不需要增强的方法,就调用被装饰类中原有的方法
         */
        // 创建LiuDeHua对象
        LiuDeHua ldh = new LiuDeHua();
        // 表演
        // ldh.sing();
        // ldh.dance();

        // 创建LiuDeHuaWrapper对象
        LiuDeHuaWrapper ldhW = new LiuDeHuaWrapper(ldh);
        ldhW.sing();
        ldhW.dance();
    }
}
