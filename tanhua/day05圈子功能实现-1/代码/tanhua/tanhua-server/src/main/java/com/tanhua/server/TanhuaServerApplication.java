package com.tanhua.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

/**
 * 消费者启动类
 */
@SpringBootApplication(exclude = MongoAutoConfiguration.class)
public class TanhuaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TanhuaServerApplication.class,args);
    }
}
