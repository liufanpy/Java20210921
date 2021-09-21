package com.itheima.test;

import com.itheima.bean.Account;
import com.itheima.bean.AccountCustom;
import com.itheima.dao.AccountDao;
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
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        //3.调用方法
        List<AccountCustom> list = accountDao.findAll();
        for (AccountCustom accountCustom : list) {
            System.out.println("accountCustom = " + accountCustom);
        }
        //4.关闭SqlSession
        SqlSessionFactoryUtils.close(sqlSession);
    }

    //测试  查询所有的账户信息 并关联用户名和地址  一对一查询
    @Test
    public void test02(){
        //1.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        //2.获取代理对象
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        //3.调用方法
        List<Account> accountList = accountDao.findAccountList();
        for (Account account : accountList) {
            System.out.println("account = " + account);
        }
        //4.关闭SqlSession
        SqlSessionFactoryUtils.close(sqlSession);
    }
}
