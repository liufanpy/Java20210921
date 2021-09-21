package com.itheima.dao;

import com.itheima.bean.Account;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AccountDao {
    /*
    @Select("select * from account")
    List<Account>  findAll();*/



    List<Account>  findAll();
}
