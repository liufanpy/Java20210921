package com.itheima.demo12_定义注解;

import java.util.Scanner;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/18 14:36
 */
// 带属性的注解
public @interface MyAnnotation02 {
    // 属性: 数据类型 属性名();
    // - 基本类型
    int num();
    double numD();

    // - String类型
    String str();

    // - Class类型
    Class c();

    // - 注解类型
    MyAnnotation01 ma();

    // - 枚举类型
    Gender g();

    // - 以及以上五种类型的一维数组类型
    int[] arr1();
    String[] arr2();
    Class[] arr3();
    MyAnnotation01[] arr4();
    Gender[] arr5();

}
