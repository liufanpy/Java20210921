package com.itheima.test;

import com.itheima.config.AppConfig;
import com.itheima.demo4_conditional.Person;
import com.itheima.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ActiveProfiles("release")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class TestUserServiceImpl {

    //注入userservice
    //@Autowired
    //private UserService userService;

    //注入工厂
    @Autowired
    private ApplicationContext context;

    //注入AppConfig
    @Autowired
    private AppConfig config;


    @Autowired
    private Person p ;

    @Test
    public void testAdd(){

        //userService.add();

        System.out.println("-------------工厂里面保存：-----------------");
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("name=" + name);
        }

        System.out.println("p=" + p);

    }

    @Test
    public void testShow(){
        config.show();
    }
}
