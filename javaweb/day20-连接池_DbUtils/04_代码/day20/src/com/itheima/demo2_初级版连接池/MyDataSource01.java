package com.itheima.demo2_初级版连接池;

import com.itheima.utils.JDBCUtils;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/28 9:37
 */
public class MyDataSource01 {
    //- 在连接池类中,定义一个LinkedList集合(表示连接池)
    private static LinkedList<Connection> pools = new LinkedList<>();

    //- 在连接池类的静态代码块中,创建固定数量的连接,并存储到LinkedList集合中
    static {
        try {
            for (int i = 0; i < 5; i++) {
                // 得到连接对象
                Connection connection = JDBCUtils.getConnection();
                // 添加到连接池中
                pools.add(connection);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //- 提供一个公共的非静态方法来获取连接对象
    public Connection getAbc(){
        Connection connection = pools.removeFirst();
        return connection;
    }

    //- 提供一个公共的非静态方法来归还连接对象
    public void addBack(Connection connection){
        pools.addLast(connection);
    }

    //- 提供一个公共的静态方法来获取连接池中连接的数量
    public static int size(){
        return pools.size();
    }
}
