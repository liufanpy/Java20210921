package com.itheima02_抛出异常;

/*
概述
    作用：在方法内部，抛出一个描述问题的异常对象
    处理方式：根据抛出的异常类型(编译异常/运行异常)特性，决定对于该异常的处理方式
    格式：throw new 异常类名(参数);
throw的应用了解
    Objects类中的静态方法public static <T> T requireNonNull(T obj)：查看指定引用对象不是null
    源码:
        public static <T> T requireNonNull(T obj) {
            if (obj == null){
                //对为null的情况执行抛出空指针异常对象，并默认交由调用者处理。
              	throw new NullPointerException();
            }
            return obj;
        }
需求：演示抛出除数为0异常
 */
public class Test {
    public static void main(String[] args) {
        // System.out.println(10 / 0);//java.lang.ArithmeticException: / by zero
        method(10, 0);
    }

    public static void method(int num1, int num2) {
        if (num2 == 0) {
            throw new ArithmeticException("by:" + num2);
        }
        int num3 = num1 / num2;// java.lang.ArithmeticException: / by zero
    }
}
