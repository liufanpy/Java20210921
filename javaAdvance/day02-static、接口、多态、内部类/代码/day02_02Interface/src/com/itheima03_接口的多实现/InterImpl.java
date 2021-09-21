package com.itheima03_接口的多实现;

public class InterImpl implements MyInterA, MyInterB {

    //重写两个父接口中的同名抽象方法
    public void abstractMethod() {
        System.out.println("实现类重写父接口中的同名抽象方法");
    }

    //重写两个父接口中的同名默认犯法
    public void defaultMethod() {
        System.out.println("实现类重写父接口中的同名默认方法");
    }
}
