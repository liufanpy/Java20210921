package com.itheima05_多态的好处和弊端;

public class Zi extends Fu {
    @Override
    public void method() {
        System.out.println("子类重写了父类中的method方法");
    }

    public void show() {
        System.out.println("子类特有的show方法");
    }
}
