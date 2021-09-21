package com.itheima.demo13_使用注解;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/18 14:41
 */
// 带属性注解
public @interface MyAnnotation02 {
    String name();
    int age();
    double[] arr();
}
