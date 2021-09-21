package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author ljh
 * @version 1.0
 * @date 2021/3/11 10:44
 * @description 标题
 * @package com.itheima
 */
@SpringBootApplication
@EnableDiscoveryClient//标记该微服务就是nacos的客户端 并且自动实现 注册和发现
@EnableFeignClients//开启feign的启用
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }

    @Bean
    @LoadBalanced//开启ribbon的负载均衡 使用默认的负载均衡策略（区域轮询）
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
