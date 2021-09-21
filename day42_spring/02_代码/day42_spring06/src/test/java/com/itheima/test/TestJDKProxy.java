package com.itheima.test;

import com.itheima.proxy.jdk.Star;
import com.itheima.proxy.jdk.StarAdvice;
import com.itheima.proxy.jdk.SuperStar;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestJDKProxy {

    @Test
    public void testDemo(){

        //1. 真实对象
        final Star star = new SuperStar();

        //2. 创建代理
        Star proxyObj = (Star) Proxy.newProxyInstance(
                star.getClass().getClassLoader(),  // 使用什么类加载器
                star.getClass().getInterfaces(), //实现什么接口
                new InvocationHandler() { //调用处理器

                    //外部的代理对象调用什么方法， 这里的这个invoke方法都会被执行。
                    // proxy :代理对象， method :方法对象 ,args : 方法的参数
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("调用了invoke...");
                        //让真实对象唱歌
                        //star.sing("忘情水");

                        //增强：  彩排
                        StarAdvice sa = new StarAdvice();
                        sa.before();

                        //使用反射调用
                        Object o = method.invoke(star , args);

                        //增强
                        sa.after();
                        return o;
                    }
                }
        );

        //3. 调用代理的唱歌和跳舞方法
        proxyObj.sing("忘情水");
        //proxyObj.dance("脱衣舞");

    }
}
