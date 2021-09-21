package com.itheima.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAdvice {

    public void print(){
        System.out.println("执行了MyAdvice的print方法~~！~");
    }


    // 增强的种类

    public void before(){
        System.out.println("前置增强");
    }

    public void afterReturning(){
        System.out.println("后置增强");
    }

    public void afterThrowing(){
        System.out.println("异常增强");
    }

    public void after(){
        System.out.println("最终增强");
    }

    /**
     *
     * @param point 正在执行的连接点， 其实就是切入点，就是要增强的那个方法。 add | update
     * @throws Throwable
     */
    public void around(ProceedingJoinPoint point) throws Throwable {

        before();
        //调用目标方法
        //point.proceed();
        point.proceed(point.getArgs());

        afterReturning();

    }
}
