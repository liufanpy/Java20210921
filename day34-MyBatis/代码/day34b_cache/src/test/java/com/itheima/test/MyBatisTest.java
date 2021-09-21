package com.itheima.test;

import com.itheima.bean.QueryVo;
import com.itheima.bean.User;
import com.itheima.dao.UserDao;
import com.itheima.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MyBatisTest {

    //测试  证明MyBatis一级缓存的存在  一级缓存缓存的是对象地址！！！
    @Test
    public void test01(){
        //1.获取SqlSession对象
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //2.调用方法
        User user = userDao.getUserById(6);
        System.out.println("user = " + user);

        //证明一级缓存的存在  不关闭SqlSession  重新查询一次 看数据是从哪里获取到的？
        User user1 = userDao.getUserById(6);
        System.out.println("user1 = " + user1);
        //判断user对象和user1对象是不是在同一个内存地址 (是不是同一个对象)
        System.out.println(user==user1);


        SqlSessionFactoryUtils.close(sqlSession);
    }

    /*
        测试：一级缓存清空
            情况一：SqlSession关闭，两次查询使用的不是同一个SqlSession对象
     */
    @Test
    public void test02(){
        //1.获取SqlSession对象
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //2.调用方法
        User user = userDao.getUserById(6);
        System.out.println("user = " + user);
        //3.关闭SqlSession对象
        SqlSessionFactoryUtils.close(sqlSession);


        //重新获取SqlSession对象
        SqlSession sqlSession1 = SqlSessionFactoryUtils.getSqlSession();
        UserDao userDao1 = sqlSession1.getMapper(UserDao.class);
        User user1 = userDao1.getUserById(6);
        System.out.println("user1 = " + user1);

        //判断user对象和user1对象是不是在同一个内存地址 (是不是同一个对象)
        System.out.println(user==user1);
    }

    /*
        测试：一级缓存清空
            情况一：SqlSession关闭，两次查询使用的不是同一个SqlSession对象
            情况二：当查询的数据 进行增删改操作 执行commit提交之后，一级缓存清空
     */
    @Test
    public void test03(){
        //1.获取SqlSession对象
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //2.调用方法
        User user = userDao.getUserById(6);
        System.out.println("user = " + user);

        //执行修改  并且commit
        user.setUsername("张三三");
        user.setAddress("东莞");
        int rows = userDao.updateUser(user);
        sqlSession.commit();

        //使用同一个SqlSession对象 重新查询一次
        User user1 = userDao.getUserById(6);
        System.out.println("user1 = " + user1);

        //判断user对象和user1对象是不是在同一个内存地址 (是不是同一个对象)
        System.out.println(user==user1);
    }

    /**
     * 情况：SqlSession已经关闭 使用的不是同一个了
     * 测试二级缓存 可以使用
     */
    @Test
    public void test04(){
        //1.获取SqlSession对象
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //2.调用方法
        User user = userDao.getUserById(6);
        System.out.println("user = " + user);
        //3.关闭SqlSession对象
        SqlSessionFactoryUtils.close(sqlSession);


        //重新获取SqlSession对象
        SqlSession sqlSession1 = SqlSessionFactoryUtils.getSqlSession();
        UserDao userDao1 = sqlSession1.getMapper(UserDao.class);
        User user1 = userDao1.getUserById(6);
        System.out.println("user1 = " + user1);

        //一级缓存 缓存的对象的内存地址  注意：二级缓存缓存的是对象序列化之后的数据
        System.out.println(user==user1);
    }

    /*
       测试：二级缓存清空
       情况一：当二级缓存中的数据进行增删改操作  执行事务提交commit后
    */
    @Test
    public void test05(){
        //1.获取SqlSession对象
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //2.调用方法
        User user = userDao.getUserById(6);
        System.out.println("user = " + user);

        //执行修改  并且commit
        user.setUsername("张三");
        user.setAddress("惠州");
        int rows = userDao.updateUser(user);
        sqlSession.commit();

        //使用同一个SqlSession对象 重新查询一次
        User user1 = userDao.getUserById(6);
        System.out.println("user1 = " + user1);

        //判断user对象和user1对象是不是在同一个内存地址 (是不是同一个对象)
        System.out.println(user==user1);
    }

}
