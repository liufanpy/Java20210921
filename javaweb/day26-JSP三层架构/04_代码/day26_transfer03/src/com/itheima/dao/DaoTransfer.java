package com.itheima.dao;

import com.itheima.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author：pengzhilin
 * @Date: 2021/5/7 14:41
 */
public class DaoTransfer {
    /**
     * 减钱
     * @param fromUsername
     * @param money
     * @return
     * @throws SQLException
     */
    public int jianMoney(Connection connection,String fromUsername, double money) throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "update account set money = money - ? where name = ?";
        int rows = qr.update(connection,sql, money, fromUsername);
        return rows;
    }

    /**
     * 加钱
     * @param toUsername
     * @param money
     * @return
     * @throws SQLException
     */
    public int jiaMoney(Connection connection,String toUsername, double money) throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "update account set money = money + ? where name = ?";
        int rows = qr.update(connection,sql, money, toUsername);
        return rows;
    }
}
