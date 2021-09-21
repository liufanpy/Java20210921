package com.itheima.test;

import com.itheima.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserServiceImpl {

    @Test
    public void testAdd(){

        //1. 创建工厂
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //2. 问工厂要对象
        //UserService us = context.getBean(UserService.class);
        //UserService us = (UserService) context.getBean("userServiceImpl");
        UserService us = (UserService) context.getBean("us");

        //3. 调用方法
        us.add();


        //4. 关闭工厂
        context.close();

    }
}
