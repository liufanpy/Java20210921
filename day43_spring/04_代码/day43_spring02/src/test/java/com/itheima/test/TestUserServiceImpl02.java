package com.itheima.test;

import com.itheima.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext02.xml")
public class TestUserServiceImpl02 {

    //注入的时候，不要写成真实的实现类，否则会出现类型无法转化的异常，
    //因为等一会使用了AOP之后，这里注入进来不是真实对象，而是代理对象！
    @Autowired
    private UserService userService;

    @Test
    public void testAdd(){
        userService.add();
    }
    @Test
    public void testUpdate(){
        userService.update();
    }
}
