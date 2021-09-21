package com.itheima.dao;

import com.itheima.bean.QueryVo;
import com.itheima.bean.User;
import java.util.List;

public interface UserDao {
    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();

    /**
     * 根据Uid 查询指定用户
     */
    User getUserById(Integer uid);


    /**
     * 修改 用户信息
     */
    int updateUser(User user);
}
