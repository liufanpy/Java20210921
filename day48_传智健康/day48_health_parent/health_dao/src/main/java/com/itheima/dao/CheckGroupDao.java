package com.itheima.dao;

import com.github.pagehelper.Page;
import com.itheima.entity.QueryPageBean;
import com.itheima.health.pojo.CheckGroup;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CheckGroupDao {

    /**
     * 分页展示
     * @param bean
     * @return
     */
    Page<CheckGroup> findPage(QueryPageBean bean);

    /**
     * 更新检查组
     * @param checkGroup 检查组对象
     * @return
     */
    int update(CheckGroup checkGroup);

    /**
     * 查询所有的检查组
     * @return
     */
    List<CheckGroup> findAll();

    /**
     * 根据检查组的id，把这个检查组包含的所有检查项记录都给删除掉 ，操作的是中间表（t_checkgroup_chekitem）
     * @param id
     * @return
     */
    int deleteItemsById(int id);

    /**
     * 往中间表添加检查项。
     * @param groupId
     * @param itemId
     * @return
     */
    int addItems(@Param("groupId") int groupId , @Param("itemId") int itemId);

    /**
     * 根据检查组的id，查询它包含的检查项
     * @param id
     * @return
     */
    List<Integer> findItemsById(int id);

    /**
     * 添加检查组的基本信息
     * @param checkGroup 检查组的对象
     * @return 影响的行数
     */
    int add(CheckGroup checkGroup);

    /**
     * 添加检查组和检查项的关系到中间表去
     * @param checkGroupId 检查组的id
     * @param checkItemId 检查项的id
     * @return  影响的行数
     */
    int addItem(@Param("checkGroupId") int checkGroupId , @Param("checkItemId") int checkItemId);
}
