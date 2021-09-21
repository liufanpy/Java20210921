package com.itheima.dao;

import com.itheima.bean.Account;

import java.util.List;

public interface AccountDao {
    /**
     * 根据uid查询存在的账户
     */
    List<Account> getAccountsByUid(Integer uid);
}
