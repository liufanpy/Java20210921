package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao dao;

    public void transfer(String from, String to, int money) {

        //1. 扣钱
        dao.kouqian(from ,money);

        int a = 1 / 0 ;

        //2. 加钱
        dao.jiaqian(to , money);
    }
}
