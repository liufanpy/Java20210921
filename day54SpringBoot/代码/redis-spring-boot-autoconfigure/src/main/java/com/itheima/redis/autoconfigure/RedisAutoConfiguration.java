package com.itheima.redis.autoconfigure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

/**
 * @Description: Redis配置类
 * @author: yp
 */
@Configuration
@EnableConfigurationProperties(value = {RedisProperties.class}) //在spring.factories只配置了RedisAutoConfiguration, 需要把RedisProperties一起给加载
public class RedisAutoConfiguration {


    // 把jedis加载到Spring容器里面
    /**
     * @Bean
     * 1.把方法的返回值注册到Spring容器里面
     * 2.自动的从Spring容器里面找到对应的类型给方法的参数进行注入
     */
    @Bean
    public Jedis jedis(RedisProperties redisProperties){
        return new Jedis(redisProperties.getHost(),redisProperties.getPort());
    }


}
