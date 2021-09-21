package com.itheima05_接口的多继承;

public interface MyInterA {

    //默认方法
    public default void defaultMethod() {
        System.out.println("A接口中的默认方法");
    }
}
