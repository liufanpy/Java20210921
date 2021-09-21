package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import com.itheima.util.TransactionManager;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private QueryRunner runner;
    @Autowired
    private TransactionManager txManager;

    @Override
    public Account findByName(String name) throws SQLException {
        //txManager.getConnection()：从当前线程上获取连接
        return runner.query(txManager.getConnection(), "select * from account where name = ?", new BeanHandler<>(Account.class), name);
    }

    @Override
    public void edit(Account account) throws SQLException {
        //txManager.getConnection()：从当前线程上获取连接
        runner.update(txManager.getConnection(),"update account set name=?,money=? where id=?", account.getName(), account.getMoney(), account.getId());
    }
}