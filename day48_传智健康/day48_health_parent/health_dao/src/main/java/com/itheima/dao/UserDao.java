package com.itheima.dao;

import com.itheima.health.pojo.User;

public interface UserDao {

    User findUserByUsername(String username);
}
