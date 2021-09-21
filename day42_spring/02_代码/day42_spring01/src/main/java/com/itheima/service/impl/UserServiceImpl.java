package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;


/*
    一、 声明Bean的注解：
        @Component ：
            1. 这是通用的注解 ， spring只要看到这个注解，就会把这个类的对象创建出来，然后管理起来。
            2. spring针对三层结构，设计出来每一层特有的注解
                web ---- @Controller
                service ---- @Service
                dao  ---- @Repository
            3. id属性的设置
                3.1 可以使用注解里面的value属性来设置id值
                3.2 如果不设置的话，默认一类的名字(首字母小写) ， 作为id值。

      二、配置Bean的注解
          @Scope：
             1. 用来配置单例或者多例，默认情况下，spring创建的对象都是单例的。
             2. 如果期望做成多例，就应该写成这样： @Scope("prototype")
             3. 如果期望明码标价成单例： @Scope("singleton")
          @PostConstruct
             当对象创建的时候调用打上这个注解的方法
          @PreDestroy
              当对象销毁的时候调用打上这个注解的方法
 */

//@Component
@Service("us")
@Scope("singleton")
public class UserServiceImpl implements UserService {


    /*
        @Autowired :
            作用： 注入对象到属性身上，自动注入，是根据类型去匹配对象的。
            用法：
                1. 在spring容器里面查找有没有哪个对象是属于（属性）这种类型的，如果有就直接注入。
                2. 如果不巧，在容器里面属于（属性）这种类型的对象有多个，那么还会挣扎一下
                    2.1 拿属性（变量）的名字，当成id的名字去找对象。如果能找到就注入进来
                    2.2 如果还没有找到匹配的，就直接报异常。
         @Qualifier
            作用： 配合@Autowired 来用的。
            用法：
                1. 当我们spring容器里面存在多个对象的时候 ， @Autowired 难以抉择。
                2. 此时就可以使用@Qualifier 来指定id，告诉 @Autowired 要注入谁！
          @Resource
             作用： 用来注入对象，当出现多个对象的时候，可以使用@Resource来注入
             用法：
                1. 它等价 @Autowired + @Qualifier
                2. 它是按照id的名字去找对象，然后注入进来。

          @Value
              作用： 用来注入普通数据，一般是用来注入外部配置文件（如：properties）的内容
              用法： @Value("${key的名字}")

     */

    /*@Autowired
    @Qualifier("userDaoImpl03")
    private UserDao userDao;*/


    @Resource(name = "userDaoImpl")
    private UserDao userDao;


    @Value("北京")
    private String address ;

    public void add() {
        System.out.println("调用了UserServiceImpl...add...~" + address);
        userDao.add();
    }

    //=========================
    // 当对象创建的时候，调用这个方法
    @PostConstruct
    public void init(){
        System.out.println("调用了UserServiceImpl...init...~");
    }

    //当对象销毁的时候，调用这个方法
    @PreDestroy
    public void destroy(){
        System.out.println("调用了UserServiceImpl...destroy...~");
    }
}
