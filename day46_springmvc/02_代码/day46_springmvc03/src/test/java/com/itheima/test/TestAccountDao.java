package com.itheima.test;

import com.itheima.bean.Account;
import com.itheima.dao.AccountDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestAccountDao {

    @Test
    public void testFindAll() throws IOException {

        //1. 读取核心配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

        //2. 创建SqlSessionFactory
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = builder.build(is);

        //3. 创建SqlSession
        SqlSession session = sessionFactory.openSession();

        //4. 获取代理对象
        AccountDao dao = session.getMapper(AccountDao.class);

        //5. 调用方法
        List<Account> list = dao.findAll();
        System.out.println("list=" + list);

        //6. 关闭sqlsession
        session.close();


    }
}
