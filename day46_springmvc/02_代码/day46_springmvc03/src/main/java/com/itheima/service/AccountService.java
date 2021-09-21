package com.itheima.service;

import com.itheima.bean.Account;

import java.util.List;

public interface AccountService {

    /**
     * 查询所有的账户
     * @return
     */
    List<Account> findAll();
}
