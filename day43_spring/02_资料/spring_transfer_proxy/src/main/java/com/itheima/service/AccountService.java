package com.itheima.service;

import java.sql.SQLException;

public interface AccountService {
    void transfer(String out, String in, Float money) throws SQLException;
}