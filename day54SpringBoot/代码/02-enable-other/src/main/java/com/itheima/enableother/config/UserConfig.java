package com.itheima.enableother.config;

import com.itheima.enableother.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @author: yp
 */
@Configuration
public class UserConfig {

    @Bean
    public User user(){
        return new User();
    }

}
