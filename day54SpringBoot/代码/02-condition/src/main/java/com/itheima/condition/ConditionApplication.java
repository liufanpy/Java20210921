package com.itheima.condition;

import com.itheima.condition.bean.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Description:
 * @author: yp
 */
@SpringBootApplication
public class ConditionApplication {

    public static void main(String[] args) {
        //1. ConfigurableApplicationContext Spring容器
        ConfigurableApplicationContext context = SpringApplication.run(ConditionApplication.class, args);
        User user = (User) context.getBean("user");
        System.out.println(user);
    }

}
