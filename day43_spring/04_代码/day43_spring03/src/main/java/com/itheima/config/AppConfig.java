package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration //这是一个核心配置类
@ComponentScan("com.itheima") //指定扫描的包
@EnableAspectJAutoProxy // aop的开关，允许自动代理
public class AppConfig {
}
