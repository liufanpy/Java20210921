package com.itheima05_接口的多继承;

public interface MyInterB {

    //默认方法
    public default void defaultMethod() {
        System.out.println("B接口中的默认方法");
    }
}
