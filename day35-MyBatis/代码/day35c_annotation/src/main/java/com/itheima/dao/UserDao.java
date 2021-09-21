package com.itheima.dao;

import com.itheima.bean.QueryVo;
import com.itheima.bean.User;
import org.apache.ibatis.annotations.*;

import javax.management.Query;
import javax.management.relation.Role;
import java.util.List;

public interface UserDao {
    // 查询所有用户

    /**
     * @Results：代替xml配置时的resultMap标签
     * @Result：进行具体表中字段和javabean属性的配置  代替的是<id> <result>
     * @return
     */
    @Select("select * from t_user")
    @Results(id="userMap",value = {
            @Result(id = true,column = "uid",property = "uid"),
            @Result(column = "username",property = "username"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "birthday",property = "birthday"),
            @Result(column = "address",property = "address")
    })
    List<User> findAll();

    // 增加用户
    /**
        keyProperty：主键所对应的javabean属性
        resultType：主键属性类型
        before：主键如果在插入语句之前生成就设置为true，如果主键是在插入语句之后生成设置为false
        statement：获取主键id
     */
    @Insert("insert into t_user values(null,#{username},#{sex},#{birthday},#{address})")
    @SelectKey(keyProperty = "uid",resultType = int.class,before = false,statement = "select last_insert_id()")
    int addUser(User user);

    // 修改用户
    @Update("update t_user set username=#{username},address=#{address} where uid=#{uid}")
    int updateUser(User user);

    // 删除用户
    @Delete("delete from t_user where uid=#{uid}")
    int deleteUserById(Integer uid);

    // 需求1：查询用户表的用户记录数
    int count();

    /**
     * @ResultMap：用于引入配置好的@Results  根据@Results的id
     * @param uid
     * @return
     */
    // 需求2：根据uid查询指定用户
    @ResultMap(value = "userMap")
    @Select("select * from t_user where u_id=#{uid}")
    User getUserByUid(Integer uid);





}
