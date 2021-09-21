package com.itheima.condition.condition;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Description:
 * @author: yp
 */
@Retention(RetentionPolicy.RUNTIME)  //在运行阶段还有效
@Conditional(value = {MyCondition.class}) //Conditiond的子类: MyCondition里面的matches方法返回true, @Conditional控制加载当前的bean;返回false, @Conditional控制不加载当前的bean
public @interface ConditionalOnClass {
    String[] name();

}
