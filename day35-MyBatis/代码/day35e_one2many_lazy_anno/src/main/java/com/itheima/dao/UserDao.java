package com.itheima.dao;

import com.itheima.bean.User;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface UserDao {

    /**
     * 查询所有用户信息及用户关联的账户信息。
     */
    @Results(value = {
            @Result(id = true,column = "uid",property = "uid"),
            @Result(column = "username",property = "username"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "birthday",property = "birthday"),
            @Result(column = "address",property = "address"),
            /* 一对多配置
                column：要传递的条件列
                property：多方属性名称
                @Many：替代collection标签 用于配置一对多
                    select：指向下一条查询的SQL语句
                    fetchType：加载类型  FetchType.LAZY：懒加载  FetchType.EAGER：立即加载
             */
            @Result(column = "uid",property = "accounts" ,
                many = @Many(select = "com.itheima.dao.AccountDao.getAccountsByUid",fetchType = FetchType.LAZY)
            )

    })
    @Select("select * from t_user")
    public List<User> findAll();
}
