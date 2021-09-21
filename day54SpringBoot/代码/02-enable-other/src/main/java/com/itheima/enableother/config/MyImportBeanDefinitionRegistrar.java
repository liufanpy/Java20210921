package com.itheima.enableother.config;

import com.itheima.enableother.bean.User;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Description:
 * @author: yp
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     *
     * @param importingClassMetadata  注解原数据
     * @param registry  Bean的注册器
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        //构建User的Bean定义信息
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(User.class).getBeanDefinition();
        //参数1: 注册到Spring容器里面bean的名字
        //参数2: 要注册bean的定义信息对象
        registry.registerBeanDefinition("u1",beanDefinition); //把u1-user对象注册到了Spring容器里面

    }
}
