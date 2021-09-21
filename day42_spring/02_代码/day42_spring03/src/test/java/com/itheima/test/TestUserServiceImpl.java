package com.itheima.test;

import com.itheima.config.AppConfig;
import com.itheima.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class TestUserServiceImpl {

    @Autowired
    private UserService us;


    //原始的写法
    @Test
    public void testAdd(){
        //1. 创建工厂  由于我们使用的是核心配置类的写法，所以工厂也需要换一下 AnnotationConfigApplicationContext
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        //2. 问工厂要对象
        UserService us = (UserService) context.getBean("us");

        //3. 调用方法
        us.add();
    }


    //使用整合单元测试的写法
    @Test
    public void testAdd02(){
        us.add();
    }
}
