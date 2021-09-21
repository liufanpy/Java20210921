package com.itheima.service;

import com.itheima.health.pojo.Setmeal;

public interface SetmealService {

    /**
     * 新增套餐
     * @param setmeal 套餐的基本信息
     * @param checkgroupIds 套餐包含的检查组的id
     * @return >0 表示成功， 否则表示失败
     */
    int add(Setmeal setmeal, int [] checkgroupIds);
}
