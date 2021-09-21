package com.itheima.test;

import com.itheima.bean.QueryVo;
import com.itheima.bean.Role;
import com.itheima.bean.User;
import com.itheima.dao.UserDao;
import com.itheima.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MyBatisTest {


    //测试使用MyBatis查询所有用户
    @Test
    public void testFindAll() throws Exception {
        //1.读取配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //2.加载配置文件创建SqlSessionFactory           连接池                    建造者模式
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        //3.通过sqlSessionFactory获得SqlSession对象   connection                  工厂模式
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4.使用SqlSession通过UserDao接口获取UserDao实例                          动态代理 JDK
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //5.执行操作
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println("user = " + user);
        }
        //6.关闭对象 释放资源
        is.close();
        sqlSession.close();
    }

    //测试增加用户
    @Test
    public void TestAddUser() throws IOException {
        //1.读取配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //2.加载配置文件 获得SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //3.获得SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4.获得dao接口的代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //5.执行方法
        User user = new User(null,"张三","男",new Date(),"深圳");
        int rows = userDao.addUser(user);
        /*
                MyBatis默认关闭事务的自动提交 所以在使用MyBatis做增删改的时候需要进行手动提交事务
                JDBC：connection.setAutoCommit(false);  connection.commit();
                MyBatis:sqlSession.commit();
         */
        sqlSession.commit();
        //6.关闭对象
        is.close();
        sqlSession.close();

        System.out.println("userId="+user.getUid());

    }

    //测试增加用户  并获取新增用户id
    @Test
    public void TestAddUser2() throws IOException {
        //1.读取配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //2.加载配置文件 获得SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //3.获得SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4.获得dao接口的代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //5.执行方法
        User user = new User(null,"张三丰","男",new Date(),"十堰");
        int rows = userDao.addUser2(user);
        /*
                MyBatis默认关闭事务的自动提交 所以在使用MyBatis做增删改的时候需要进行手动提交事务
                JDBC：connection.setAutoCommit(false);  connection.commit();
                MyBatis:sqlSession.commit();
         */
        sqlSession.commit();
        //6.关闭对象
        is.close();
        sqlSession.close();

        System.out.println("userId="+user.getUid());

    }

    //测试增加用户  并获取新增用户id
    @Test
    public void TestAddUser3() throws IOException {
        //1.读取配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //2.加载配置文件 获得SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //3.获得SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4.获得dao接口的代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //5.执行方法
        User user = new User(null,"张三疯","男",new Date(),"西安");
        int rows = userDao.addUser3(user);
        /*
                MyBatis默认关闭事务的自动提交 所以在使用MyBatis做增删改的时候需要进行手动提交事务
                JDBC：connection.setAutoCommit(false);  connection.commit();
                MyBatis:sqlSession.commit();
         */
        sqlSession.commit();
        //6.关闭对象
        is.close();
        sqlSession.close();

        System.out.println("userId="+user.getUid());

    }

    //测试修改用户
    @Test
    public void TestUpdateUser() throws IOException {
        //1.读取配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //2.加载配置文件 获得SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //3.获得SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4.获得dao接口的代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //5.执行方法
        User user = new User(8,"张三疯","男",new Date(),"黑马");
        int rows = userDao.updateUser(user);
        /*
                MyBatis默认关闭事务的自动提交 所以在使用MyBatis做增删改的时候需要进行手动提交事务
                JDBC：connection.setAutoCommit(false);  connection.commit();
                MyBatis:sqlSession.commit();
         */
        //事务提交
        sqlSession.commit();
        //6.关闭对象
        is.close();
        sqlSession.close();
    }

    //测试删除用户
    @Test
    public void TestDeleteUser() throws IOException {
        //1.读取配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //2.加载配置文件 获得SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //3.获得SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4.获得dao接口的代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //5.执行方法
        int rows = userDao.deleteUserById(7);
        /*
                MyBatis默认关闭事务的自动提交 所以在使用MyBatis做增删改的时候需要进行手动提交事务
                JDBC：connection.setAutoCommit(false);  connection.commit();
                MyBatis:sqlSession.commit();
         */
        //事务提交
        sqlSession.commit();
        //6.关闭对象
        is.close();
        sqlSession.close();
    }

    //测试根据用户名姓氏进行模糊查询
    @Test
    public void TestGetUserListByName() throws IOException {
        //1.读取配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //2.加载配置文件 获得SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //3.获得SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4.获得dao接口的代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //5.执行方法
        List<User> list = userDao.getUserListByName("张");
        System.out.println("list = " + list);

        //6.关闭对象
        is.close();
        sqlSession.close();
    }

    //测试根据用户名姓氏进行模糊查询
    @Test
    public void TestGetUserListByName2() throws IOException {
        //1.读取配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //2.加载配置文件 获得SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //3.获得SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4.获得dao接口的代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //5.执行方法
        List<User> list = userDao.getUserListByName2("张");
        System.out.println("list = " + list);

        //6.关闭对象
        is.close();
        sqlSession.close();
    }

    //使用工具类操作  查看所有用户
    @Test
    public void testUserTools(){
        //1.获取SqlSession对象
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        //2.通过dao接口获取代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //3.执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println("user = " + user);
        }
        //4.关闭对象
        SqlSessionFactoryUtils.close(sqlSession);
    }

    //根据用户id查询用户信息，查询条件放到 QueryVo 的 user 属性中。
    @Test
    public void testGetUserByQueryVo(){
        //1.获取SqlSession对象
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        //2.通过dao接口获取代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //3.执行方法
        QueryVo queryVo = new QueryVo();
        User user0 = new User();
        user0.setUid(5);
        queryVo.setUser(user0);
        User user = userDao.getUserByQueryVo(queryVo);
        System.out.println("user = " + user);
        //4.关闭对象
        SqlSessionFactoryUtils.close(sqlSession);
    }

    //使用包装类型  根据用户名 支持模糊查询和角色id进行查询
    //需求：查询姓名中包含"张"的 并且用户角色id为3
    @Test
    public void testGetUserListByQueryVo(){
        //1.获取SqlSession对象
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        //2.通过dao接口获取代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //3.执行方法
        User user = new User();
        user.setUsername("张");
        Role role = new Role();
        role.setRid(3);
        QueryVo queryVo = new QueryVo();
        queryVo.setUser(user);
        queryVo.setRole(role);

        List<User> list = userDao.getUserListByQueryVo(queryVo);
        for (User user1 : list) {
            System.out.println("user1 = " + user1);
        }

        //4.关闭对象
        SqlSessionFactoryUtils.close(sqlSession);
    }

    //传递多个参数  不使用包装类型 根据用户名和角色id进行查询
    @Test
    public void testGetListByNameAndRoleId(){
        //1.获取SqlSession对象
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        //2.通过dao接口获取代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //3.执行方法
        List<User> list = userDao.getListByNameAndRoleId("张",3);
        for (User user1 : list) {
            System.out.println("user1 = " + user1);
        }

        //4.关闭对象
        SqlSessionFactoryUtils.close(sqlSession);
    }
}
