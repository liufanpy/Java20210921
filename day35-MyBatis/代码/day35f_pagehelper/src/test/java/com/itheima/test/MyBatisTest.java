package com.itheima.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.bean.User;
import com.itheima.dao.UserDao;
import com.itheima.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyBatisTest {

    //测试 分页
    @Test
    public void test01(){
        //1.获取SqlSession对象
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        //2.获取代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //3.调用方法
        //实现分页  在查询之前设置分页条件
        PageHelper.startPage(2,3);

        List<User> users = userDao.findAll01();
        for (User user : users) {
            System.out.println("user = " + user);
        }

        //4.关闭SqlSession对象
        SqlSessionFactoryUtils.close(sqlSession);
    }
    //测试 分页 获取具体的分页信息
    @Test
    public void test02(){
        //1.获取SqlSession对象
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        //2.获取代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //3.调用方法
        //实现分页  在查询之前设置分页条件
        PageHelper.startPage(2,3);

        List<User> users = userDao.findAll01();
        //将分页数据封装到PageInfo中  可以得到分页信息(当前页码、总条数、总页数、每页条数、每页数据)
        PageInfo<User> pageInfo = new PageInfo(users);
        System.out.println("当前页码：" + pageInfo.getPageNum());
        System.out.println("总条数：" + pageInfo.getTotal());
        System.out.println("总页数:" + pageInfo.getPages());
        System.out.println("每页条数:" + pageInfo.getPageSize());
        List<User> list = pageInfo.getList();
        for (User user : list) {
            System.out.println("user = " + user);
        }


        //4.关闭SqlSession对象
        SqlSessionFactoryUtils.close(sqlSession);
    }

    //测试 分页 获取具体的分页信息
    @Test
    public void test03(){
        //1.获取SqlSession对象
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        //2.获取代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //3.调用方法
        //实现分页  在查询之前设置分页条件
        PageHelper.startPage(1,3);
        Page<User> page = userDao.findAll02();
        System.out.println("当前页码：" + page.getPageNum());
        System.out.println("总条数：" + page.getTotal());
        System.out.println("总页数:" + page.getPages());
        System.out.println("每页条数:" + page.getPageSize());
        //每页数据
        List<User> users = page.getResult();
        for (User user : users) {
            System.out.println("user = " + user);
        }
        //实际开发中  不返回Page对象 (归根结底还是一个list集合 )  返回PageInfo对象(货真价实的分页信息封装工具类)
        PageInfo<User> pageInfo = page.toPageInfo();

        //4.关闭SqlSession对象
        SqlSessionFactoryUtils.close(sqlSession);
    }

}
