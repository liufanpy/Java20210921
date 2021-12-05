package com.itheima.demo;

import com.itheima.dao.UserMapper;
import com.itheima.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DemoTest01 {


    public static void main(String[] args) throws IOException {


        // 1. 读取核心配置文件  --- 有没有加载数据源？
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 2. 创建sqlsession工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 3. 创建sqlsession
        SqlSession session = sqlSessionFactory.openSession();

        // 4.完成查询   --- 有没有完成sql的查找  参数映射？ 结果封装？
        // 方式1：
        User user = session.selectOne("com.itheima.dao.UserMapper.findUserById", 101);

        System.out.println("user1:" + user);

        // 方式2：
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> userList = mapper.findAll();

        User user2 = mapper.findUserById(101);
        System.out.println("user2:" + user2);

        // 5.释放资源
        session.close();
        inputStream.close();
    }










    /**
     *
     * *******************************************************************************************
     */

    InputStream in;
    SqlSessionFactoryBuilder builder;
    SqlSessionFactory factory;
    SqlSession session;
    SqlSession session2;
    UserMapper userMapper = null;


    @Before
    public void init() throws Exception {
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        session = factory.openSession(true);
        session2 = factory.openSession(true);
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
     * 【缓存测试】
     *
     * 只有第一次真正查询了数据库，后续的查询使用了一级缓存
     */
    @Test
    public void testLocalCache01() {
        User user = userMapper.findUserById(101);
        System.out.println("-------------第一次查询:"+user);
        User user2 = userMapper.findUserById(101);
        System.out.println("-------------第二次查询:"+user2);
    }





    /**
     * 【缓存测试】
     *
     *  在两次查询中间 执行 更新操作：
     */
    @Test
    public void testLocalCache02() {
        User user = userMapper.findUserById(101);
        System.out.println("-------------第一次查询:"+user);

        userMapper.saveUser(new User(null,"bxg","bj","boxuegu"));
        System.out.println("-------------更新了数据-------------");

        User user2 = userMapper.findUserById(101);
        System.out.println("-------------第二次查询:"+user2);
    }


}
