package com.itheima.demo16_注解解析;

import java.lang.reflect.Method;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/18 15:18
 */

public class Test {

    public static void main(String[] args) throws Exception {
        /*
            java.lang.reflect.AnnotatedElement接口: Class、Method、Field、Constructor等实现了AnnotatedElement
            - T getAnnotation(Class<T>   annotationType):得到指定类型的注解对象。没有返回null。
            - boolean isAnnotationPresent(Class<?extends Annotation> annotationType)：判断指定的注解有没有。
         */
        // 需求1:获取show1方法上MyAnnotation01注解属性的值
        // 1.获取Test类的字节码对象
        Class<Test> c = Test.class;

        // 2.获取show1方法对应的Method对象
        Method show1M = c.getDeclaredMethod("show1");

        // 3.使用Method对象调用getAnnotation方法获得show1方法上的MyAnnotation01注解对象
        MyAnnotation01 annotation = show1M.getAnnotation(MyAnnotation01.class);

        // 4.使用MyAnnotation01注解对象获取name和age属性的值
        System.out.println(annotation.name() + "," + annotation.age());

        // 需求2: 判断show1和show2方法上是否有MyAnnotation01注解
        boolean res1 = show1M.isAnnotationPresent(MyAnnotation01.class);
        System.out.println("res1:"+res1);// res1: true

        Method show2M = c.getDeclaredMethod("show2");
        boolean res2 = show2M.isAnnotationPresent(MyAnnotation01.class);
        System.out.println("res2:"+res2);// res2: false
    }

    @MyAnnotation01(name = "张三", age = 18)
    public void show1() {

    }

    public void show2() {

    }
}
