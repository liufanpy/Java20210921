package com.itheima.test;

import com.itheima.dao.UserMapper;
import com.itheima.domain.User;
import com.itheima.mybatis.io.Resources;
import com.itheima.mybatis.session.SqlSession;
import com.itheima.mybatis.session.SqlSessionFactory;
import com.itheima.mybatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


/**
 * mybatis测试用例
 */
public class MybatisTest {


    public static void main(String[] args) throws Exception {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession session = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        UserMapper userMapper = session.getMapper(UserMapper.class);

        //5.使用代理对象执行方法
        List<User> users = userMapper.findAll();

        for (User user : users) {
            System.out.println(user);
        }
        //6.释放资源
        session.close();
        in.close();

    }
















    /*----------------------------------------------*/


    InputStream in;
    SqlSessionFactoryBuilder builder;
    SqlSessionFactory factory;
    SqlSession session;
    UserMapper userMapper = null;


    @Before
    public void init() throws Exception {
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        session = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        userMapper = session.getMapper(UserMapper.class);
    }

    @After
    public void after() throws IOException {
        //6.释放资源
        session.close();
        in.close();
    }


    /**
     * 入门案例
     */
    @Test
    public void test11() throws Exception {

        //5.使用代理对象执行方法
        User user = userMapper.findUserById(1);

        System.out.println(user);

    }


}
