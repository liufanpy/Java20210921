package com.itheima.dao;

import com.itheima.bean.Account;
import com.itheima.bean.AccountCustom;

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
    List<Account> findAccountList();
}
