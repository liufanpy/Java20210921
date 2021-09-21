package com.itheima;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description:
 * @author: yp
 */
@SpringBootApplication
@MapperScan("com.itheima.dao")
public class ProviderApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(ProviderApplication.class,args);
        while (true){
            Thread.sleep(3000);
        }
    }

}
