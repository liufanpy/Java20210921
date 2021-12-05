package com.itheima.mybatis.executor;

import com.itheima.mybatis.binding.Mapper;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 * SQL的执行对象：
 *  负责执行sql语句，并且将结果封装返回
 *
 */
public class Executor {



    /**
     * 根据mapper查询多条数据
     * @param mapper
     * @param conn
     * @param <E>
     * @return
     */
    public <E> List<E> selectList(Mapper mapper, Connection conn) {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            //1.取出mapper中的数据
            String queryString = mapper.getQueryString();//select * from user
            String resultType = mapper.getResultType();//com.itheima.pojo.User
            Class domainClass = Class.forName(resultType);
            //2.获取PreparedStatement对象
            pstm = conn.prepareStatement(queryString);
            //3.执行SQL语句，获取结果集
            rs = pstm.executeQuery();
            //4.封装结果集
            List<E> list = new ArrayList<E>();//定义返回值
            while (rs.next()) {
                //将结果集中的数据封装到实体中
                E obj = extraction(rs, domainClass);
                //把赋好值的对象加入到集合中
                list.add(obj);
            }
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            release(conn, pstm, rs);
        }
    }

    /**
     * 根据mapper查询数据,查询一条数据,如果结果集中有多条数据,返回第一条数据封装的实体对象
     * @param mapper
     * @param conn
     * @param <E>
     * @return
     */
    public <E> E selectOne(Mapper mapper, Connection conn) {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            //1.取出mapper中的数据
            String queryString = mapper.getQueryString();//select * from user where id = ?
            String resultType = mapper.getResultType();//com.itheima.domain.User
            Class domainClass = Class.forName(resultType);
            //2.获取PreparedStatement对象
            pstm = conn.prepareStatement(queryString);
            //3.执行SQL语句，获取结果集
            rs = pstm.executeQuery();
            //4.封装结果集
            if (rs.next()) {
                //将结果集中的数据封装到实体中
                E obj = extraction(rs, domainClass);
                return obj;
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            release(conn, pstm, rs);
        }
    }

    /**
     * 将结果集中的一条数据封装到实体对象中
     * @param rs
     * @param domainClass
     * @param <E>
     * @return
     * @throws Exception
     */
    private <E> E extraction(ResultSet rs,Class domainClass) throws Exception{
        //实例化要封装的实体类对象
        E obj = (E) domainClass.newInstance();
        //取出结果集的元信息：ResultSetMetaData
        ResultSetMetaData rsmd = rs.getMetaData();
        //取出总列数
        int columnCount = rsmd.getColumnCount();
        //遍历总列数
        for (int i = 1; i <= columnCount; i++) {
            //获取每列的名称，列名的序号是从1开始的
            String columnName = rsmd.getColumnName(i);
            //根据得到列名，获取每列的值
            Object columnValue = rs.getObject(columnName);
            //给obj赋值：使用Java内省机制（借助PropertyDescriptor实现属性的封装）
            PropertyDescriptor pd = new PropertyDescriptor(columnName, domainClass);//要求：实体类的属性和数据库表的列名保持一种
            //获取它的写入方法
            Method writeMethod = pd.getWriteMethod();
            //把获取的列的值，给对象赋值
            writeMethod.invoke(obj, columnValue);
        }

        return  obj;
    }

    private void release(Connection conn, PreparedStatement pstm, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (pstm != null) {
            try {
                pstm.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
