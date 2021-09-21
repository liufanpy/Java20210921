package com.itheima.demo15_装饰者设计模式;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/15 16:22
 */
// 被装饰类
public class LiuDeHua implements Star {
    @Override
    public void sing() {
        System.out.println("刘德华在唱忘情水...");
    }
    @Override
    public void dance() {
        System.out.println("刘德华在跳街舞...");
    }
}
