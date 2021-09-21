package com.itheima.dao;

import com.itheima.health.pojo.Permission;
import com.itheima.health.pojo.Role;

import java.util.Set;

public interface PermissionDao {


    /**
     * 根据角色的id来查询这个角色有哪些权限
     * @param roleId 角色的id
     * @return
     */
    Set<Permission> findPermissionByRoleId(int roleId);

}
