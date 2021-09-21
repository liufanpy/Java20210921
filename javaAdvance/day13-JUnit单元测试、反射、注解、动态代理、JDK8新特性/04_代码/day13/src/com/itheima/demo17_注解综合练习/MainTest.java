package com.itheima.demo17_注解综合练习;

import java.lang.reflect.Method;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/18 15:49
 */
public class MainTest {
    public static void main(String[] args) throws Exception {
        // 1.获取TestDemo类的字节码对象
        Class<TestDemo> c = TestDemo.class;

        // 2.获取该类中所有的方法
        Method[] arr = c.getDeclaredMethods();

        // 通过反射创建TestDemo对象
        TestDemo td = c.getDeclaredConstructor().newInstance();

        // 3.循环遍历所有的方法
        for (Method m : arr) {
            // 4.在循环中,判断遍历出来的方法上是否有MyTest注解
            boolean res = m.isAnnotationPresent(MyTest.class);
            // 5.如果有,就执行当前方法
            if (res) {
                m.invoke(td);
            }
        }

    }
}
