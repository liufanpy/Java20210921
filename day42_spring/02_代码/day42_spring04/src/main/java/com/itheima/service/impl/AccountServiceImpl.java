package com.itheima.service.impl;

import com.itheima.bean.Account;
import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao dao;

    public int add(Account account) throws SQLException {
        return dao.add(account);
    }

    public int delete(int id) throws SQLException {
        return dao.delete(id);
    }

    public int update(Account account) throws SQLException {
        return dao.update(account);
    }

    public Account findById(int id) throws SQLException {
        return dao.findById(id);
    }

    public List<Account> findAll() throws SQLException {
        return dao.findAll();
    }
}
