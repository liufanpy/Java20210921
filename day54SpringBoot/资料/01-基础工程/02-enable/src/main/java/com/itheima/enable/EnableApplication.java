package com.itheima.enable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 一,引入第三方bean的三种方式
 * 1.使用@ComponentScan扫描  eg:@ComponentScan(value ={"@ComponentScan(value ={"com.itheima.enableother.bean"})"})
 * 2.可以使用@Import注解，加载类。这些类都会被Spring创建，并放入IOC容器 eg: @Import(value = {User.class}) 创建bean的名字是类的全限定名
 * 3.可以对Import注解进行封装 eg: @EnableUser
 *
 * 二, Import 的4种用法
 *  1. 导入Bean   eg:@Import(value = {User.class})
 *  2. 导入配置类  eg:@Import(value = {UserConfig.class})
 *  3. 导入ImportSelector的实现类  eg:@Import(value = {MyImportSelector.class})  创建bean的名字是类的全限定名
 *  4. 导入ImportBeanDefinitionRegistrar实现类 eg:@Import(value = {MyImportSelector.class})
 *
 */
@SpringBootApplication
public class EnableApplication {
    public static void main(String[] args) {
         SpringApplication.run(EnableApplication.class, args);

    }
}
