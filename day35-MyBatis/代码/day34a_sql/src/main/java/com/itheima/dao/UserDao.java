package com.itheima.dao;

import com.itheima.bean.QueryVo;
import com.itheima.bean.User;
import java.util.List;

public interface UserDao {
    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();

    /**
     * 使用if
     * 使用pojo包装类型  根据用户名和id进行查询用户列表
     * @param queryVo
     * @return
     */
    List<User> getUserListByQueryVo1(QueryVo queryVo);

    /**
     * 使用where+if
     * 使用pojo包装类型  根据用户名和id进行查询用户列表
     * @param queryVo
     * @return
     */
    List<User> getUserListByQueryVo2(QueryVo queryVo);

    /**
     * 使用 pojo包装类  QueryVo
     * 根据用户名和用户id进行模糊查询
     */

    List<User> getUserListByQueryVo3(QueryVo queryVo);

    /**
     * 根据用户id和用户名称进行模糊查询  如果id为null  就使用username查询，如果id不为空，使用id查询
     */
    List<User> getUserList01(User user);

    /**
     * 根据用户id和用户名称进行模糊查询  如果id为null  就使用username查询，如果id不为空，使用id查询
     */
    List<User> getUserList02(User user);

    List<User> getUserList03(User user);

    //修改用户
    int updateUser01(User user);

    int updateUser02(User user);

    int updateUser03(User user);


}
