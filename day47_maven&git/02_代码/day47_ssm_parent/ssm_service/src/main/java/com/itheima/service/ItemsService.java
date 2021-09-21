package com.itheima.service;

import com.itheima.bean.Items;

import java.util.List;

public interface ItemsService {

    List<Items> findAll();

    int save(Items items);
}
