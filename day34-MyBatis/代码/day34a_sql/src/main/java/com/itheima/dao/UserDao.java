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

}
