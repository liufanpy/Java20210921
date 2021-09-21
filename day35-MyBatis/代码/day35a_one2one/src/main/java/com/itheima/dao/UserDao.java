package com.itheima.dao;

import com.itheima.bean.User;

public interface UserDao {

    /**
     * 根据uid查询用户信息
     */
    User getUserByUid(Integer uid);

}
