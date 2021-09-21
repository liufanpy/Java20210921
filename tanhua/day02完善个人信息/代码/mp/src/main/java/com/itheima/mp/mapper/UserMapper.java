package com.itheima.mp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.mp.pojo.User;

/**
 * @Description:
 * @author: yp
 */
public interface UserMapper extends BaseMapper<User> { //BaseMapper<T> :T写pojo
    //MyBatis: 自己定义方法和写sql语句
    //MyBatisPlus: 就不需要自己定义方法和写sql语句, 只需要继承BaseMapper 就有了CRUD方法了
}
