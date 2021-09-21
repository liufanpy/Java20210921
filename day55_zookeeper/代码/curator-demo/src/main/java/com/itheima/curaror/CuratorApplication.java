package com.itheima.curaror;

import com.itheima.curaror.utils.CuratorUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @Description:
 * @author: yp
 */
@SpringBootApplication
public class CuratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(CuratorApplication.class,args);
    }

    @Bean
    public CuratorUtil curatorUtil(){
        return new CuratorUtil();
    }

}
