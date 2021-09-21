package com.itheima.test;

import com.itheima.proxy.cglib.StarAdvice;
import com.itheima.proxy.cglib.SuperStar;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class TestCglibProxy {



    @Test
    public void testDemo(){
        //1. 创建真实对象
        final SuperStar star = new SuperStar();

        //2.创建代理
        Enhancer enhancer = new Enhancer();

        SuperStar proxyObj = (SuperStar) enhancer.create(SuperStar.class, new MethodInterceptor() {

            //o : 代理对象， method :  方法对象 ， objects: 方法参数  ， methodProxy:方法代理
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

                //增强： 彩排
                StarAdvice sa = new StarAdvice();
                sa.before();


                //调用真实对象的方法
                //Object result = method.invoke(star ,objects );

                //等于就是调用父类的方法。
                Object result =  methodProxy.invokeSuper(o , objects);


                //增强： 收钱
                sa.after();

                return result;
            }
        });

        //3 调用方法
        proxyObj.sing("忘情水");
        proxyObj.dance("机械舞");

    }
}
