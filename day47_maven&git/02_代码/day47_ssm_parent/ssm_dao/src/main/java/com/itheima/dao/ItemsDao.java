package com.itheima.dao;

import com.itheima.bean.Items;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ItemsDao {

    List<Items> findAll();

    int save(Items items);
}
