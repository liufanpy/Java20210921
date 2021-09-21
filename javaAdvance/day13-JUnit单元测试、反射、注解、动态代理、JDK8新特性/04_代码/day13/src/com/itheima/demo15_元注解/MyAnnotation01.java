package com.itheima.demo15_元注解;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/18 14:41
 */
// 不带属性注解
//@Target(value={ElementType.METHOD,ElementType.FIELD}) // 当前注解只能使用在方法或者成员变量上
//@Target(value={ElementType.TYPE})
//@Target(ElementType.TYPE)// 当前注解只能使用在类上
//如果没有@Target注解修饰,默认任何位置都可以使用当前注解
public @interface MyAnnotation01 {
}
