package com.itheima.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
    这个注解打在类身上，主要是为了解决我们在总的控制器类里面解析太多类的问题
    以后只要解析哪个类身上打上这个注解，我们就解析哪个类
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Controller {
}
