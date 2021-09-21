package com.itheima.dao;

import com.itheima.bean.Role;

import java.util.List;

public interface RoleDao {
    /**
     * 实现查询所有角色对象并且加载它所分配的用户信息。
     */
    List<Role> findAll();

}
