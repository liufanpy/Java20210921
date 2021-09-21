package com.itheima.service;

import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.health.pojo.CheckGroup;

import java.util.List;

public interface CheckGroupService {

    /**
     * 查询所有的检查组数据
     * @return
     */
    List<CheckGroup> findAll();

    /**
     * 添加检查组
     * @param checkGroup  检查组的基本信息
     * @param checkitemIds 检查组包含的检查项的id值
     * @return >0 : 添加成功，否则：添加失败。
     */
    int add(CheckGroup checkGroup , int [] checkitemIds);

    /**
     * 更新见擦汗组
     * @param checkGroup  检查组的基本信息
     * @param checkitemIds 检查组包含的检查项的id值
     * @return >0 : 添加成功，否则：添加失败。
     */
    int update(CheckGroup checkGroup , int [] checkitemIds);

    /**
     * 检查组分页
     * @param bean
     * @return
     */
    PageResult<CheckGroup> findPage(QueryPageBean bean);

    /**
     * 根据检查组的id 查询它包含的检查项的id
     * @param id
     * @return
     */
    List<Integer> findItemsById(int id);
}
