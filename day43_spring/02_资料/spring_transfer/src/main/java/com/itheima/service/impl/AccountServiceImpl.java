package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import com.itheima.util.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;
    @Autowired
    private TransactionManager txManager;

    @Override
    public void transfer(String out, String in, Float money) {
        try {
            //开启事务
            txManager.startTransaction();

            //1. 查询
            Account outAccount = accountDao.findByName(out);
            Account inAccount = accountDao.findByName(in);

            //2. 转账人扣钱，收款人加钱
            outAccount.setMoney(outAccount.getMoney() - money);
            inAccount.setMoney(inAccount.getMoney() + money);

            //3. 更新到数据库
            accountDao.edit(outAccount);
            int i = 1/0;
            accountDao.edit(inAccount);

            //提交事务
            txManager.commitAndClose();
        } catch (Exception e) {
            e.printStackTrace();
            //回滚事务
            txManager.rollbackAndClose();
        }
    }
}