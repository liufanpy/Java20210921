package com.itheima04static在开发中的应用;

/*
应用场景:开发项目中，通常需要一些“全局变量”或“全局方法”。这些全局变量和方法，可以单独定义在一个类中，并声明为static(静态)的，方便通过类名访问，这样的类被称为工具类。
需求:在一个工具类中，定义一个π变量和获取数组最大值方法

 */
public class Test {
    public static void main(String[] args) {
        System.out.println(MathUtils.PI);
        int[] arr = {1, 4, 7, 9, 10};
        int max = MathUtils.getMax(arr);
        System.out.println(max);
    }
}
