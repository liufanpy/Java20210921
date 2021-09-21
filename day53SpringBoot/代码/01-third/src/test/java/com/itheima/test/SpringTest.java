package com.itheima.test;

import com.itheima.third.ThirdApplication;
import com.itheima.third.mapper.UserMapper;
import com.itheima.third.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Description:
 * @author: yp
 */
//@SpringBootTest(classes = {ThirdApplication.class}) //配置单元测试, classes指定启动类
@SpringBootTest(classes = {ThirdApplication.class})  //配置单元测试, classes指定启动类  如果不写classes,要求: 单元测试的类需要和启动类的目录在同一层(目前相同) ,在子目录下面
@RunWith(SpringRunner.class) //指定运行环境
public class SpringTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void fun01(){
        List<User> list = userMapper.findAll();
        System.out.println(list);
    }

    @Test
    public void fun02(){
        redisTemplate.opsForValue().set("bkey","bbb");
        System.out.println(redisTemplate.opsForValue().get("bkey"));

    }


}
