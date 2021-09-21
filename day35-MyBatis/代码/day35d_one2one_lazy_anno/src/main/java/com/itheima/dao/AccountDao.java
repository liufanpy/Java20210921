package com.itheima.dao;

import com.itheima.bean.Account;
import com.itheima.bean.AccountCustom;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface AccountDao {
    /**
     * 采用自定义类封装查询结果
     * 查询所有的账户信息 并关联用户名和地址
     * @return
     */
     List<AccountCustom> findAll();

    /**
     * 采用关联映射配置进行查询
     * 查询所有的账户信息 并关联用户名和地址
     */
    /*
         @Results：代替resultMap标签
         @Result：代替id标签 和result标签
         @One：代替association标签
    */
    @Results(value = {
            @Result(id = true,column = "aid",property = "aid"),
            @Result(column = "money",property = "money"),
            @Result(column = "uid",property = "uid"),
            /*
                column：表示的就是要传递的条件列
                property：表示配置一方属性
                @One：代替association标签
                    select：表示要关联的下一条查询SQL语句
                    fetchType：加载方式  FetchType.LAZY：懒加载  FetchType.EAGER：立即加载
             */
            @Result(column = "uid",property = "user",
                    one = @One(select = "com.itheima.dao.UserDao.getUserByUid",fetchType = FetchType.LAZY)
            )
    })
    @Select("select * from t_account")
    List<Account> findAccountList();
}
