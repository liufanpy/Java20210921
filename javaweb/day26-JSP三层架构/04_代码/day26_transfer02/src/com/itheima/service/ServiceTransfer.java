package com.itheima.service;

import com.itheima.dao.DaoTransfer;

import java.sql.SQLException;

/**
 * @Author：pengzhilin
 * @Date: 2021/5/7 14:41
 */
public class ServiceTransfer {
    // 创建Dao对象
    private DaoTransfer dao = new DaoTransfer();

    /**
     * service方法处理业务逻辑,调用dao层
     * @param fromUsername
     * @param toUsername
     * @param money
     * @return
     */
    public boolean transfer(String fromUsername, String toUsername, double money) {
        try {
            // 调用Dao层
            int rows1 = dao.jianMoney(fromUsername,money);

            //int res = 1/0;

            int rows2 = dao.jiaMoney(toUsername,money);

            // 业务判断
            if (rows1 > 0 && rows2 > 0){
                return true;
            }else{
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
