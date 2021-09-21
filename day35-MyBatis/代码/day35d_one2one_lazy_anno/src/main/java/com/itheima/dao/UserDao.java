package com.itheima.dao;

import com.itheima.bean.User;
import org.apache.ibatis.annotations.Select;

public interface UserDao {

    /**
     * 根据uid查询用户信息
     */
    @Select("select * from t_user where uid=#{uid}")
    User getUserByUid(Integer uid);

}
