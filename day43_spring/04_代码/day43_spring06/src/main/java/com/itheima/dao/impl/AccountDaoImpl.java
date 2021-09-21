package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate template;

    public void kouqian(String from, int money) {
        String sql = "update t_account set money = money - ?  where name = ? ";
        template.update(sql , money , from);
    }

    public void jiaqian(String to, int money) {
        String sql = "update t_account set money = money + ?  where name = ? ";
        template.update(sql , money , to);
    }
}
