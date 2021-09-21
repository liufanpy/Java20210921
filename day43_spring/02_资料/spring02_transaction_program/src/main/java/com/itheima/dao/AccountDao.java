package com.itheima.dao;

import com.itheima.domain.Account;

import java.sql.SQLException;

public interface AccountDao {
    void edit(Account account) throws SQLException;
    Account findByName(String name) throws SQLException;
}
