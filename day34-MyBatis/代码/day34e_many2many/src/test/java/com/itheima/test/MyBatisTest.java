package com.itheima.test;

import com.itheima.bean.Account;
import com.itheima.bean.Role;
import com.itheima.bean.User;
import com.itheima.dao.AccountDao;
import com.itheima.dao.RoleDao;
import com.itheima.dao.UserDao;
import com.itheima.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyBatisTest {

    //测试  查询所有的账户信息 并关联用户名和地址
    @Test
    public void test01(){
        //1.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        //2.获取代理对象
        RoleDao roleDao = sqlSession.getMapper(RoleDao.class);
        //3.调用方法
        List<Role> roleList = roleDao.findAll();
        for (Role role : roleList) {
            System.out.println("role = " + role);
        }
        //4.关闭SqlSession
        SqlSessionFactoryUtils.close(sqlSession);
    }


}
