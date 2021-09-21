package com.itheima.dao;

import com.itheima.bean.LinkMan;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface LinkManDao {

    /**
     * 查询所有联系人
     */
    @Select("select * from linkman")
    public List<LinkMan> findAll();

    /**
     * @description: 添加联系人
     * @params: [linkMan]
     * @return: int
    */
    @Insert("insert into linkman values(null,#{name},#{sex},#{age},#{address},#{qq},#{email})")
    public int add(LinkMan linkMan);

    /**
     * @description: 删除联系人
     * @params: [id]
     * @return: int
    */
    @Delete("delete from linkman where id=#{id}")
    public int deleteById(Integer id);


    /**
     * 查询分页展示的集合数据
     */
    @Select("select * from linkman")
    public List<LinkMan> findPage();
}
