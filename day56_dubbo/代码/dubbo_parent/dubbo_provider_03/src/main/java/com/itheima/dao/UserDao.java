package com.itheima.dao;

import com.itheima.bean.User;
import org.apache.ibatis.annotations.Select;

/**
 * @Description:
 * @author: yp
 */
public interface UserDao {

    @Select("SELECT * FROM t_user WHERE id = #{id}")
    User findById(Integer id);
}
