package com.itheima.service;

import com.itheima.dao.DaoTransfer;
import com.itheima.utils.C3P0Utils;
import com.itheima.web.ConnectionManager;

import java.sql.Connection;
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
            //1.通过ConnectionManager管理类获得连接
            Connection connection = ConnectionManager.getConnection();

            //2.开启事务
            connection.setAutoCommit(false);

            //3.调用dao层,传入连接对象
            int rows1 = dao.jianMoney(fromUsername,money);

            int res = 1/0;

            int rows2 = dao.jiaMoney(toUsername,money);

            //4.判断dao层返回的结果,
            if (rows1 > 0 && rows2 > 0) {
                //4.1 如果成功,就提交事务
                connection.commit();
                return true;
            }else {
                //4.2 如果失败,就回滚事务
                connection.rollback();
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
