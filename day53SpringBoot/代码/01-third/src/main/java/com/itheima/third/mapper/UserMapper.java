package com.itheima.third.mapper;

import com.itheima.third.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description:
 * @author: yp
 */
public interface UserMapper {

    @Select("SELECT * FROM user")
    List<User> findAll();
}
