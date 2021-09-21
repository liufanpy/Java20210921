package com.itheima.service.impl;

import com.itheima.bean.Items;
import com.itheima.dao.ItemsDao;
import com.itheima.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional //使用事务
@Service
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private ItemsDao dao ;

    public List<Items> findAll() {
        return dao.findAll();
    }

    public int save(Items items) {
        int  row  = dao.save(items);
        //int a = 1 / 0 ;
        return row ;
    }
}
