package com.itheima.mm.service;

import com.itheima.mm.dao.UserDao;
import com.itheima.mm.pojo.User;
import com.itheima.mm.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class UserService {

    /**
     * 登录
     * @param user
     * @return
     */
    public User login( User user) throws IOException {

        //1. 使用工具类获取sqlsession对象
        SqlSession session = SqlSessionFactoryUtils.openSqlSession();

        //2. 使用sqlsession对象获取UserDao的代理对象
        UserDao dao = session.getMapper(UserDao.class);

        //3. 调用方法
        User loginUser = dao.findUser(user);

        //4. 关闭session
        session.close();

        //5. 返回对象
        return loginUser;
    }
}
