package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author ljh
 * @version 1.0
 * @date 2021/3/11 10:43
 * @description 标题
 * @package com.itheima
 */
@SpringBootApplication
@EnableDiscoveryClient//标记该微服务就是nacos的客户端并自动实现注册与发现
public class Item2Application {
    public static void main(String[] args) {
        SpringApplication.run(Item2Application.class,args);
    }
}
