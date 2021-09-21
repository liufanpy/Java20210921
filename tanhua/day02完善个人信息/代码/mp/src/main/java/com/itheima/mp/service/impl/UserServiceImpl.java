package com.itheima.mp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.mp.mapper.UserMapper;
import com.itheima.mp.pojo.User;
import com.itheima.mp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @author: yp
 */

//ServiceImpl<Mapper,pojo>

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {



  /*  @Autowired
    private UserMapper userMapper;

    @Override
    public User finById(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    public void deleleById(Long id) {
        userMapper.deleteById(id);

    }

    @Override
    public void update(User user) {

    }*/
}
