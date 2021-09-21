package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//1. 注解事务的第一步，类上或者方法上打上注解@Transactional
//如果打在类身上，即表示类里面的所有方法都用上了事务。
//@Transactional
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao dao;

    @Transactional
    public void transfer(String from, String to, int money) {

        //1. 扣钱
        dao.kouqian(from ,money);

        String s = null;
        s.length();

        //2. 加钱
        dao.jiaqian(to , money);
    }
}
