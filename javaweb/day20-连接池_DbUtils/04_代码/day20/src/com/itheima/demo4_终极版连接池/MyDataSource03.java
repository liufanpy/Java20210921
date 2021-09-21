package com.itheima.demo4_终极版连接池;

import com.itheima.utils.JDBCUtils;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

/**
 * @Author：pengzhilin
 * @Date: 2021/4/28 9:37
 */
public class MyDataSource03 implements DataSource {

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
    /*public Connection getAbc(){
        Connection connection = pools.removeFirst();
        return connection;
    }*/
    @Override
    public Connection getConnection() throws SQLException {
        // 返回被增强的连接对象
        // Connection connection = pools.removeFirst();
        // return connection;

        // 改为:返回增强的连接对象
        Connection connection = pools.removeFirst();
        // 创建增强的连接对象,传入被增强的连接对象
        ConnectionWrapper connectionWrapper = new ConnectionWrapper(connection,pools);
        return connectionWrapper;
    }


    //- 提供一个公共的非静态方法来归还连接对象
    /*public void addBack(Connection connection){
        pools.addLast(connection);
    }*/

    //- 提供一个公共的静态方法来获取连接池中连接的数量
    public static int size(){
        return pools.size();
    }




    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
