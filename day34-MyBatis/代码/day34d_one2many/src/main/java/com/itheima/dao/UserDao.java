package com.itheima.dao;

import com.itheima.bean.User;

import java.util.List;

public interface UserDao {

    /**
     * 查询所有用户信息及用户关联的账户信息。
     */
    public List<User> findAll();
}
