package com.itheima05_接口的多继承;

public interface MyInterC extends MyInterA, MyInterB {
    @Override
    public default void defaultMethod() {
        System.out.println("子接口重写父接口中的同名默认方法");
    }
}
