package com.itheima.service.impl;

import com.itheima.dao.SetmealDao;
import com.itheima.health.pojo.Setmeal;
import com.itheima.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SetmealServiceImpl implements SetmealService {

    @Autowired
    private SetmealDao dao;

    /**
     * 新增套餐
     * @param setmeal 套餐的基本信息
     * @param checkgroupIds 套餐包含的检查组的id
     * @return
     */
    @Override
    public int add(Setmeal setmeal, int[] checkgroupIds) {


        //1. 先往套餐表里面添加它的基本信息
        int row1 = dao.add(setmeal);

        //2. 再往套餐-检查组的中间表 添加这个套餐用了哪些检查组
        int row2 = 0 ;
        if(checkgroupIds != null && checkgroupIds.length > 0 ){
            for (int checkgroupId : checkgroupIds) {
                row2 += dao.addCheckGroup(setmeal.getId() ,checkgroupId );
            }
        }


        return (row1 > 0 && row2 ==checkgroupIds.length) ? 1 :  0 ;
    }
}
