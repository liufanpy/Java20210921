package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Autowired
    private TransactionDefinition txDefinition;
    @Autowired
    private PlatformTransactionManager txManager;

    @Override
    public void transfer(String from, String to, Float money) {
        //开启事务，得到事务状态
        TransactionStatus txStatus = txManager.getTransaction(txDefinition);
        try {
            //操作dao
            Account fromAccount = accountDao.findByName(from);
            Account toAccount = accountDao.findByName(to);

            fromAccount.setMoney(fromAccount.getMoney() - money);
            toAccount.setMoney(toAccount.getMoney() + money);

            accountDao.edit(fromAccount);

            //int i = 1/0;

            accountDao.edit(toAccount);

            //提交事务
            txManager.commit(txStatus);
        } catch (Exception e) {
            //回滚事务
            txManager.rollback(txStatus);
            e.printStackTrace();
        }
    }
}
