package com.itheima.dao;

import com.github.pagehelper.Page;
import com.itheima.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {
    //查询所有用户 返回分页数据
    @Select("select * from t_user")
    List<User> findAll01();

    //查询所有用户 返回分页信息
    @Select("select * from t_user")
    Page<User> findAll02();
}
