package com.itheima.dao;

import com.itheima.bean.Account;

import java.util.List;

public interface AccountDao {
    List<Account> findAll();
}
