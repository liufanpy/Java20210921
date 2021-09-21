package com.itheima.dao;

import com.itheima.bean.LinkMan;
import com.itheima.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public interface LinkManDao {

    QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());

    /**
     * 查询所有联系人
     * @return
     * @throws SQLException
     */
    public List<LinkMan> findAll();

    public int add(LinkMan linkMan);

    public int deleteById(Integer id);

    /**
     * 查询联系人总数量
     * @return
     * @throws SQLException
     */
    public int count();

    /**
     * 查询分页展示的集合数据
     * @param index
     * @param pageSize
     * @return
     * @throws SQLException
     */
    public List<LinkMan> findPage(int index, int pageSize);
}
