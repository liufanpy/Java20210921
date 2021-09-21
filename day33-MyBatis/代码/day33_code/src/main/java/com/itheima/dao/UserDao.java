package com.itheima.dao;

import com.itheima.bean.QueryVo;
import com.itheima.bean.User;
import org.apache.ibatis.annotations.Param;

import javax.management.Query;
import javax.management.relation.Role;
import java.util.List;

public interface UserDao {
    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();

    /**
     * 增加用户
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 增加用户2   要获取增加用户后的用户id
     * @param user
     * @return
     */
    int addUser2(User user);

    /**
     * 增加用户2   要获取增加用户后的用户id
     * @param user
     * @return
     */
    int addUser3(User user);

    //修改用户
    int updateUser(User user);

    //删除用户
    int deleteUserById(Integer uid);

    //根据用户名的姓氏进行模糊查询
    List<User> getUserListByName(String username);

    //根据用户名的姓氏进行模糊查询
    List<User> getUserListByName2(String username);

    //根据用户id查询用户信息，查询条件放到 QueryVo 的 user 属性中。
    User getUserByQueryVo(QueryVo queryVo);


    //使用包装类型  根据用户名和角色id进行查询
    List<User> getUserListByQueryVo(QueryVo queryVo);

    //传递多个参数  不使用包装类型 根据用户名和角色id进行查询
    //直接传递多个简单类型参数：可以使用@Param注解
    List<User> getListByNameAndRoleId(@Param("username") String username,@Param("roleId") Integer roleId);


    //需求1：查询用户表的用户记录数
    int count();
    //需求2：根据uid查询指定用户
    User getUserByUid(String uid);





}
