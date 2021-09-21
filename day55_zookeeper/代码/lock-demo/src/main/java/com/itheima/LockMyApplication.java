package com.itheima;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.locks.ReentrantLock;

@SpringBootApplication
@MapperScan(basePackages = {"com.itheima.mapper"})
public class LockMyApplication {

    public static void main(String[] args) {
        SpringApplication.run(LockMyApplication.class,args);
    }

    @Bean
    public ReentrantLock reentrantLock(){
        return new ReentrantLock();
    }
}
