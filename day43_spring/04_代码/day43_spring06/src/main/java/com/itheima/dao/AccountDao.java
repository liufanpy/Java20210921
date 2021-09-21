package com.itheima.dao;

public interface AccountDao {

    void kouqian(String from, int money);
    void jiaqian(String to, int money);

}
