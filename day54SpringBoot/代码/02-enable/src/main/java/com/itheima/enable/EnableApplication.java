package com.itheima.enable;

import com.itheima.enableother.bean.Role;
import com.itheima.enableother.bean.User;
import com.itheima.enableother.config.EnableUser;
import com.itheima.enableother.config.MyImportBeanDefinitionRegistrar;
import com.itheima.enableother.config.MyImportSelector;
import com.itheima.enableother.config.UserConfig;
import com.sun.xml.internal.fastinfoset.util.ValueArray;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * 一,引入第三方bean的三种方式
 * 1.使用@ComponentScan扫描  eg:@ComponentScan(value ={"@ComponentScan(value ={"com.itheima.enableother.bean"})"})
 * 2.可以使用@Import注解，加载类。这些类都会被Spring创建，并放入IOC容器 eg: @Import(value = {User.class}) 创建bean的名字是类的全限定名
 * 3.可以对Import注解进行封装 eg: @EnableUser
 * <p>
 * 二, Import 的4种用法
 * 1. 导入Bean   eg:@Import(value = {User.class})  名字是类的全限定名
 * 2. 导入配置类  eg:@Import(value = {UserConfig.class})
 * 3. 导入ImportSelector的实现类  eg:@Import(value = {MyImportSelector.class})  创建bean的名字是类的全限定名
 * 4. 导入ImportBeanDefinitionRegistrar实现类 eg:@Import(value = {MyImportSelector.class})
 */
@SpringBootApplication
@Import(value = UserConfig.class)
@EnableUser
public class EnableApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(EnableApplication.class, args);

        //1.获得容器里面bean的名字
        /*String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }*/
        User user = (User) context.getBean("user");
        System.out.println(user);

    }
}
