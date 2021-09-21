package com.itheima.demo19_动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/18 16:54
 */
public class Test {
    public static void main(String[] args) {
        // 创建JinLian对象
        JinLian jl = new JinLian();

        // 获取被代理类的类加载器
        ClassLoader classLoader = JinLian.class.getClassLoader();

        // 获取被代理类实现的所有接口的字节码对象
        Class<?>[] interfaces = JinLian.class.getInterfaces();

        // 动态生成一个代理对象
        FindHappy proxy = (FindHappy) Proxy.newProxyInstance(classLoader, interfaces, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 只要代理对象调用方法就会来到这里
                // 参数1: 代理对象
                // 参数2: 代理对象调用的方法
                // 参数3: 代理对象调用的方法传入的实际参数
                System.out.println("代理对象开好房间,把2人约到房间...");
                // 被代理者去happy
                method.invoke(jl,args);

                System.out.println("代理对象打扫战场....");

                return null;
            }
        });

        // 使用代理对象调用方法
        proxy.happy();


    }
}
