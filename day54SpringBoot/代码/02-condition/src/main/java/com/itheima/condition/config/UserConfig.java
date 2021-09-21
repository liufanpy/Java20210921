package com.itheima.condition.config;

import com.itheima.condition.bean.User;
import com.itheima.condition.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @author: yp
 */
@Configuration
public class UserConfig {

    @Bean
    @ConditionalOnClass(name = {"redis.clients.jedis.Jedis"})
    public User user(){
        return new User();
    }

}
