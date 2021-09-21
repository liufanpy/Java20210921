package com.itheima.config;

import com.itheima.demo1_componentscan.MyBeanNameGenerator;
import com.itheima.demo1_componentscan.MyTypeFilter;
import com.itheima.demo2_propertysource.YamlSourceFactory;
import com.itheima.demo3_import.MyImportSelector;
import com.itheima.demo3_import.Teacher;
import com.itheima.demo4_conditional.LinuxCondition;
import com.itheima.demo4_conditional.Person;
import com.itheima.demo4_conditional.WindowsCondition;
import com.itheima.service.impl.UserServiceImpl;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration // 这是核心配置类
@ComponentScan(
        value = "com.itheima" ,  //扫描具体的包
        nameGenerator = MyBeanNameGenerator.class,  //指定我们自己的id命名策略
        //excludeFilters =@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Service.class) //按照注解来排除类
        //excludeFilters = @ComponentScan.Filter(type= FilterType.ASSIGNABLE_TYPE , classes = UserServiceImpl.class) //按照指定的类来排除
        excludeFilters = @ComponentScan.Filter(type = FilterType.CUSTOM , classes = MyTypeFilter.class) // 按照自定义的规则来排除类
)
@PropertySource(value = "classpath:application.yml" , factory = YamlSourceFactory.class) //导入外部的yml文件， 并且设置解析的工厂

//@Import(Teacher.class)
@Import(MyImportSelector.class)
public class AppConfig {

    @Value("${jdbc.driver}")
    private String driverClass;

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${jdbc.username}")
    private String user;

    @Value("${jdbc.password}")
    private String password;

    public void show(){
        System.out.println(driverClass);
        System.out.println(jdbcUrl);
        System.out.println(user);
        System.out.println(password);
    }

    //生成两个Person对象
    @Bean
    @Conditional(WindowsCondition.class) //如果当前的操作系统是windows ，就创建对象，管理起来
    public Person billGates(){
        return  new Person("比尔", 67);
    }

    @Bean
    @Conditional(LinuxCondition.class) //如果当前的操作系统是linux ，就创建对象，管理起来
    public Person linus(){
        return  new Person("林纳斯", 62);
    }

    //生成三个数据源
    @Bean
    @Profile("dev")
    public DataSource devDataSource() throws PropertyVetoException {
        System.out.println("dev  开发环境的");
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql:///devdb");
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setMaxPoolSize(20);
        return dataSource;
    }

    @Bean
    @Profile("test")
    public DataSource testDataSource() throws PropertyVetoException {
        System.out.println("test  测试环境的");
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql:///testdb");
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setMaxPoolSize(20);
        return dataSource;
    }


    @Bean
    @Profile("release")
    public DataSource releaseDataSource() throws PropertyVetoException {
        System.out.println("release  生产环境的");
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql:///releasedb");
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setMaxPoolSize(20);
        return dataSource;
    }
}
