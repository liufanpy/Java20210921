package com.itheima02_接口的基本实现;

public class InterImpl implements MyInter {

    public void abstractMethod() {
        System.out.println("实现类重写了接口中的抽象方法");
    }

    @Override
    public void defaultMehtod2() {
        System.out.println("实现类重写了接口中的默认方法2");
    }
}
