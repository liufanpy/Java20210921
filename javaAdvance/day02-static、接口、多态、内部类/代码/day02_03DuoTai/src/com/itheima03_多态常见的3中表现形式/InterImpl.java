package com.itheima03_多态常见的3中表现形式;

public class InterImpl implements MyInter {
    @Override
    public void method() {
        System.out.println("实现类重写父接口中的method方法");
    }
}
