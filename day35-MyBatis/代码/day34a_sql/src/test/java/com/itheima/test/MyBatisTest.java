package com.itheima.test;

import com.itheima.bean.QueryVo;
import com.itheima.bean.User;
import com.itheima.dao.UserDao;
import com.itheima.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyBatisTest {

    //测试  修改
    @Test
    public void test05(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //调用方法
        User user = new User();
        user.setUid(7);
        user.setUsername("张三疯");
        user.setSex("妖");
        user.setBirthday(new Date());
        //user.setAddress("黑马");

        int rows = userDao.updateUser03(user);
        sqlSession.commit();


        SqlSessionFactoryUtils.close(sqlSession);
    }

    //测试  根据用户id和用户名称进行模糊查询  如果id为null  就使用username查询，如果id不为空，使用id查询
    @Test
    public void test04(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //调用方法
        User user = new User();
        //user.setUid(7);
        user.setUsername("张");
        List<User> list = userDao.getUserList03(user);
        for (User user1 : list) {
            System.out.println("user1 = " + user1);
        }


        SqlSessionFactoryUtils.close(sqlSession);
    }





    //测试  查询所有的用户信息
    @Test
    public void test01(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println("user = " + user);
        }
        SqlSessionFactoryUtils.close(sqlSession);
    }

    //测试  使用pojo包装类 根据用户名和id查询所有的用户信息
    @Test
    public void test02(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //调用方法
        User user0 = new User();
        user0.setUid(7);
        user0.setUsername("张三丰");
        QueryVo queryVo = new QueryVo();
        queryVo.setUser(user0);
        List<User> users = userDao.getUserListByQueryVo2(queryVo);
        for (User user : users) {
            System.out.println("user = " + user);
        }
        SqlSessionFactoryUtils.close(sqlSession);
    }

    //测试  使用 pojo包装类  QueryVo 根据用户名和用户id进行模糊查询
    @Test
    public void test03(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //调用方法
        User user0 = new User();
        user0.setUsername("张");
        ArrayList<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(6);
        QueryVo queryVo = new QueryVo();
        queryVo.setUser(user0);
        queryVo.setIds(ids);

        List<User> users = userDao.getUserListByQueryVo3(queryVo);
        for (User user : users) {
            System.out.println("user = " + user);
        }
        SqlSessionFactoryUtils.close(sqlSession);
    }

}
