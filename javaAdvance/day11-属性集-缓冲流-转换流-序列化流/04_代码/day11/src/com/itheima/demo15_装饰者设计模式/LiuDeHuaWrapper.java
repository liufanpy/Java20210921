package com.itheima.demo15_装饰者设计模式;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/15 16:26
 */
// 装饰类
public class LiuDeHuaWrapper implements Star{

    LiuDeHua ldh;

    public LiuDeHuaWrapper(LiuDeHua ldh) {
        this.ldh = ldh;
    }

    @Override
    public void sing() {
        // 增强
        System.out.println("刘德华在唱忘情水");
        System.out.println("刘德华在唱冰雨");
        System.out.println("刘德华在唱练习");
        System.out.println("刘德华在唱笨小孩...");
        System.out.println("刘德华在...");
    }

    @Override
    public void dance() {
        // 不增强-->执行LiuDeHua里面原有的方法
        ldh.dance();
    }
}
