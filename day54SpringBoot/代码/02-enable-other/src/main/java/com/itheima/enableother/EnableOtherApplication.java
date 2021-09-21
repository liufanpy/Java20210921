package com.itheima.enableother;

import com.itheima.enableother.bean.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Description:
 * @author: yp
 */
@SpringBootApplication
public class EnableOtherApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(EnableOtherApplication.class, args);
        User user = (User) context.getBean("user");
        System.out.println(user);
    }

}
