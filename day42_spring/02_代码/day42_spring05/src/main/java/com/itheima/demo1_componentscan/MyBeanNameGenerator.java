package com.itheima.demo1_componentscan;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;

/*
    这是我们自己的id 的命名策略 | 策略生成器
 */
public class MyBeanNameGenerator implements BeanNameGenerator {

    /**
     * 主要是用来生成对象的id名字
     * @param beanDefinition 要生成id名字的bean对象
     * @param beanDefinitionRegistry  注册中心。
     * @return
     */
    public String generateBeanName(BeanDefinition beanDefinition, BeanDefinitionRegistry beanDefinitionRegistry) {

        // 得到我们的管理的类的全路径名。
        String beanClassName = beanDefinition.getBeanClassName();
        System.out.println("beanClassName=" + beanClassName);

        // 把类的全路径名当成它的id名
        return beanClassName;
    }
}
