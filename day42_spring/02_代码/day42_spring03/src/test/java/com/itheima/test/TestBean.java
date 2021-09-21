package com.itheima.test;

import com.itheima.bean.Student;
import com.itheima.config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class TestBean {

    //1. 注入进来工厂
    @Autowired
    private ApplicationContext context;

    //2. 注入student对象
    @Autowired
    private Student s;

    @Test
    public void test01(){
        //看一看，工厂里面都有哪些对象
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("name=" + name);
        }

        //=----------------------
        System.out.println("-----------------------");
        System.out.println(s);
    }
}
