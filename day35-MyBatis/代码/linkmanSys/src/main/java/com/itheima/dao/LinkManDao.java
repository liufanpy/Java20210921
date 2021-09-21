package com.itheima.dao;

import com.github.pagehelper.Page;
import com.itheima.bean.LinkMan;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;
import java.util.List;

public interface LinkManDao {


    /**
     * 查询所有联系人
     * @return
     * @throws SQLException
     */
    @Select("select * from linkman")
    List<LinkMan> findAll();

    /**
     * 增加联系人
     * @param linkMan
     * @return
     */
    @Insert("insert into linkman values(null,#{name},#{sex},#{age},#{address},#{qq},#{email})")
    int add(LinkMan linkMan);

    /**
     * 删除联系人
     * @param id
     * @return
     */
    @Delete("delete from linkman where id=#{id}")
    int deleteById(Integer id);


    /**
     * 分页展示联系人
     * @return
     * @throws SQLException
     */
    @Select("select * from linkman")
    Page<LinkMan> findPage();
}
