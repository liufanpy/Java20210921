package com.itheima.dao;

import com.itheima.bean.Account;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AccountDao {
    /**
     * 根据uid查询存在的账户
     */
    @Select("select * from t_account where uid=#{uid}")
    List<Account> getAccountsByUid(Integer uid);
}
