package com.itheima.servlet03;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/*
    注解：
        1. 应用在什么位置
        2. 能保留到什么时候
        3. 属性：
            value
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping {

    /*
        注解的value属性 ： 这个注解写在方法上的时候，可以在括号里面写上value的值
            而value的值，就相当于是这个方法的映射地址路径。
     */
    String value();
}
