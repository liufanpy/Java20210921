package com.itheima.service.impl;

import com.itheima.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    public void add() {
        System.out.println("调用了UserServiceImpl...add...");
    }
}
