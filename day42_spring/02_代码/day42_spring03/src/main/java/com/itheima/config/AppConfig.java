package com.itheima.config;

/*
    这是一个核心配置类，它的作用就是顶替掉 applicationContext.xml
        1. 让这个类先成为核心配置类
            打上注解 @Configuration , 它是从@Component注解衍生出来的，所以这个核心配置类
                也会被spring管理起来。那么即表示在这个核心配置类里面，我们同样可以让spring
                注入进来其他的对象，或者properties的内容
        2. 扫描具体的包
            @ComponentScan("com.itheima")
        3. 导入外部的properties文件
            3.1 @PropertySource("classpath:aa.properties")  value属性，指定配置文件的名字即可，也可以加上 classpath:前缀
            3.2 需要先把properties里面的内容，注入到属性身上，然后才能使用它们 ：
                    @Value("${password}")
                    private String password;
        4. 引入外部的子配置类
            4.1 当我们的配置的内容有点多的时候，可以考虑拆分配置类，分成多个子配置类的写法
            4.2 那么需要在核心配置类里面引入其他的子配置类
                只有一个子配置类
                @Import(AppConfig01.class)

                有多个子配置类
                @Import(value = {AppConfig01.class,AppConfig02.class })

        5. 把方法的返回值声明成一个Bean
            5.1 只要在方法上打上一个注解@Bean，那么这个方法的返回值就会被Spring管理起来
            5.2 默认情况下，如果不指定id值，那么管理的对象的id值就是方法的名字
            5.3 当然我们也可以设置value属性，来设置id值

            5.4 其实方法也可以让spring注入进来其他的对象，只要方法的声明参数即可。
                默认spring是按照类型来自动注入的，等同于参数的前面有一个 @AutoWired 一样。
                如果遇到多个对象，就无法自动注入了，那么可以使用@Qualifier("createDataSource02")
                来指定注入具体的对象
 */

import com.itheima.bean.Student;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
//@ComponentScan("com.itheima")
//@PropertySource("aa.properties")

@Import(value = {AppConfig01.class,AppConfig02.class })
public class AppConfig {

    @Value("${driverClass}")
    private String driverClass;

    @Value("${jdbcUrl}")
    private String jdbcUrl;

    @Value("${user}")
    private String user;

    @Value("${password}")
    private String password;

    /**
     * 打印以上的四个属性
     */
    public void show(){
        System.out.println(driverClass);
        System.out.println(jdbcUrl);
        System.out.println(user);
        System.out.println(password);
    }

    //----------------------下面演示@Bean------------------

    //1. 把一个方法的返回交给spring管理，方法要返回一个对象。
    @Bean("stu")
    public Student a(){
        Student s = new Student(1 , "张三" , 18);
        return s;
    }

    //2. 让spring托管DataSource
    @Bean
    public DataSource createDataSource() throws PropertyVetoException {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setDriverClass(driverClass);
        ds.setJdbcUrl(jdbcUrl);
        ds.setUser(user);
        ds.setPassword(password);
        System.out.println("ds=" + ds);
        return ds;
    }

    @Bean
    public DataSource createDataSource02() throws PropertyVetoException {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setDriverClass(driverClass);
        ds.setJdbcUrl(jdbcUrl);
        ds.setUser(user);
        ds.setPassword(password);
        System.out.println("ds=" + ds);
        return ds;
    }


    //3. 让spring托管QueryRunner
    @Bean
    public QueryRunner createQueryRunner(@Qualifier("createDataSource02") DataSource ds){
        System.out.println("ds2=" + ds);
        QueryRunner runner = new QueryRunner(ds);
        return runner;
    }
}
