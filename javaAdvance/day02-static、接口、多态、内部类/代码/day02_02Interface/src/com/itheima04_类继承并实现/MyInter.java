package com.itheima04_类继承并实现;

public interface MyInter {
    public default  void defaultMethod(){
        System.out.println("接口中的默认方法");
    }
    public static void staticMethod(){
        System.out.println("接口中的静态方法");
    }
}
