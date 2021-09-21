package com.itheima.demo14_使用注解的注意事项;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/18 14:50
 */
public @interface MyAnnotation04 {
    String name() default "张三";
    int age() default 18;
}
