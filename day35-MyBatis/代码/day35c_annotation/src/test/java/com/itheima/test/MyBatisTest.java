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

    //测试
    @Test
    public void test01(){
        //1.获取SqlSession对象
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        //2.获取代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //3.调用方法

        /* 删除
            int rows = userDao.deleteUserById(6);
            sqlSession.commit();
         */



        /* 修改
            User user = new User(6,"张三峰","男",new Date(),"西安");
            int rows = userDao.updateUser(user);
            sqlSession.commit();
         */


        /*增加
            User user = new User(null,"张伟威","男",new Date(),"深圳");
            int rows = userDao.addUser(user);
            sqlSession.commit();
            if(rows>0){
                System.out.println("增加成功！uid="+user.getUid());
            }else{
                System.out.println("增加失败！");
            }
         */

        // 查询所有
            List<User> users = userDao.findAll();
            System.out.println("users = " + users);


        //4.关闭SqlSession对象
        SqlSessionFactoryUtils.close(sqlSession);
    }

    //测试  根据uid获取用户信息
    @Test
    public void test02(){
        //1.获取SqlSession对象
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        //2.获取代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //3.调用方法
        User user = userDao.getUserByUid(5);
        System.out.println("user = " + user);
        //4.关闭SqlSession对象
        SqlSessionFactoryUtils.close(sqlSession);
    }


}
