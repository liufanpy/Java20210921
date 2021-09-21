package com.itheima.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.mp.MpApplication;
import com.itheima.mp.mapper.UserMapper;
import com.itheima.mp.pojo.User;
import com.itheima.mp.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author: yp
 */
@SpringBootTest(classes = MpApplication.class)
@RunWith(SpringRunner.class)
public class ServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void fun01(){

        System.out.println(userService.getById(1L));
    }







}
