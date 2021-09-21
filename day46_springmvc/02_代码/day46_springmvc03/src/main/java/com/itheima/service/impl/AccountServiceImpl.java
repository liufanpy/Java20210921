package com.itheima.service.impl;

import com.itheima.bean.Account;
import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


//@Transactional  // 类上打上注解，表示这个类里面的所有方法都应用上了事务
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao dao ;


    /**
     * 查询所有账户
     * @return
     */
    public List<Account> findAll() {
        System.out.println("调用了AccountServiceImpl的findAll方法~！~");
        return dao.findAll();
    }
}
