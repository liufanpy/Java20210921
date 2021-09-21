package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component //组件
@Repository
public class UserDaoImpl implements UserDao {
    public void add() {
        System.out.println("调用了UserDaoImpl...add...~");
    }
}
