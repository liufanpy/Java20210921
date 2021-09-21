package com.itheima06_抽象类和接口的练习;

public class JiDuDog extends Dog implements JiDuInter {
    @Override
    public void eat() {
        System.out.println("吃军粮");
    }

    @Override
    public void jiDu() {
        System.out.println("用鼻子搜索毒品");
    }
}
