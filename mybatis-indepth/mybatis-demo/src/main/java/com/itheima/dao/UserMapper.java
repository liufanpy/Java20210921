package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 *
 * 用户的持久层接口
 */
public interface UserMapper {
    /**
     * 查询所有操作
     * @return
     */
    List<User> findAll();


    void saveUser(User user);


    User findUserById(Integer id);

    
}
