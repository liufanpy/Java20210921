package com.itheima.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*
    注解方式实现AOP ：
        1. 把UserServiceImpl和MyAdvice都交给spring托管
        2. MyAdvice还需要加上一个注解，表示它是一个切面增强类，专门用于增强别人的方法。 @Aspect
        3. 在扩展出来的功能方法上，添加注解，想要什么种类的增强，就添加什么种类的注解。
 */

@Aspect
@Component
public class MyAdvice {

    @Before("execution(* com.itheima..*.*(..))")
    public void print(){
        System.out.println("执行了MyAdvice的print方法~~！~");
    }

    //定义一个额外的方法，用来声明表达式
    @Pointcut("execution(* com.itheima..*.*(..))")
    public void aa(){
        System.out.println("aaaa");
    }


    // 增强的种类
    //@Before("execution(* com.itheima..*.*(..))")

    @Before("aa()")
    public void before(){
        System.out.println("前置增强");
    }

//    @AfterReturning("execution(* com.itheima..*.*(..))")

    @AfterReturning("aa()")
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
