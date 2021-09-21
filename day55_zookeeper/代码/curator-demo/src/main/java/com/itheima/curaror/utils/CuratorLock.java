package com.itheima.curaror.utils;

import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @author: yp
 */
@Component
public class CuratorLock {

    @Autowired
    private CuratorUtil curatorUtil;

    @Bean
    public InterProcessMutex interProcessMutex(){
        return new InterProcessMutex(curatorUtil.getClient(),"/lock");
    }

}
