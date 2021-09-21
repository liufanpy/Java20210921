package com.itheima.order;

import com.itheima.order.rule.MyRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient //开启服务注册发现
@EnableFeignClients //开启Feign远程调用
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    //注册RestTemplate
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    /**
     * 配置负载均衡算法
     * @return
     */
    @Bean
    public IRule iRule(){
        //return new RandomRule(); //随机
        return new MyRule(); //自定义负载均衡算法
    }


}
