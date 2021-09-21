package com.itheima.dao;

import com.itheima.health.pojo.Setmeal;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SetmealDao {

    /**
     * 查询套餐表里面的所有图片（名字）
     * @return
     */
    List<String> findAllImg();


    /**
     * 添加套餐
     * @param setmeal 套餐的基本信息
     * @return
     */
    int add(Setmeal setmeal);

    /**
     * 添加套餐用到的检查组信息到中间表去
     * @param setmealId 套餐的id
     * @param checkgroupId 检查组的id
     * @return
     */
    int addCheckGroup(@Param("setmealId") int setmealId , @Param("checkgroupId") int checkgroupId);
}
