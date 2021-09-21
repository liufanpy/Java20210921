package com.itheima.dao;

import com.itheima.bean.LinkMan;
import com.itheima.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class LinkManDao {

    QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());

    /**
     * 查询所有联系人
     * @return
     * @throws SQLException
     */
    public List<LinkMan> findAll() throws SQLException {
        String sql ="select * from linkman";
        List<LinkMan> list = queryRunner.query(sql, new BeanListHandler<LinkMan>(LinkMan.class));
        return list;
    }

    public int add(LinkMan linkMan) throws SQLException {
        String sql ="insert into linkman values(null,?,?,?,?,?,?)";
        Object[] objects = {linkMan.getName(),linkMan.getSex(),linkMan.getAge(),linkMan.getAddress(),linkMan.getQq(),linkMan.getEmail()};
        int result = queryRunner.update(sql, objects);
        return result;
    }

    public int deleteById(Integer id) throws SQLException {
        String sql ="delete from linkman where id=?";
        int rows = queryRunner.update(sql, id);
        return rows;
    }

    /**
     * 查询联系人总数量
     * @return
     * @throws SQLException
     */
    public int count() throws SQLException {
        String sql ="select count(*) from linkman";   //返回结果类型是long  被封装成了Object
        Long count = (Long)queryRunner.query(sql, new ScalarHandler());
        return count.intValue();
    }

    /**
     * 查询分页展示的集合数据
     * @param index
     * @param pageSize
     * @return
     * @throws SQLException
     */
    public List<LinkMan> findPage(int index, int pageSize) throws SQLException {
        String sql ="select * from linkman limit ?,?";
        return queryRunner.query(sql, new BeanListHandler<LinkMan>(LinkMan.class),index,pageSize);
    }
}
