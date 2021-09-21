package com.itheima.test;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.mp.MpApplication;
import com.itheima.mp.mapper.UserMapper;
import com.itheima.mp.pojo.User;
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
public class MpTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    //查询id为1的用户 MyBatisPlus增强了MyBatis 源码不经典,MyBatis的源码是经典【自定义的MyBatis】
    public void fun01(){
        User user = userMapper.selectById(1);
        System.out.println(user);
    }

    @Test
    //增加
    public void fun02(){
        User user = new User(18L,"小红","1111","王八",18,"wb@qq.com");
        //User user = new User("wb","1111","王八",18,"wb@qq.com");
        int rows = userMapper.insert(user);
        System.out.println(rows);
    }

    @Test
    //根据id更新  把id为18的用户名字改成小红红【一般是先查询再更新】
    public void fun03(){
        User user = new User();
        user.setId(18L);
        user.setUsername("小红红");
        userMapper.updateById(user);
    }

    @Test
    //根据条件更新   把名字是小红红的用户的密码改成88888
    public void fun04(){

        //userMapper.update(更新后的数据,构造的条件);
        //1.更新后的数据
        User user = new User();
        user.setPassword("88888");

        //2.构造的条件
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<User>();
        updateWrapper.eq("username","小红红");

        userMapper.update(user,updateWrapper);
    }

    @Test
    //根据id删除  删除id为18的用户
    public void fun05(){
        userMapper.deleteById(18);
    }

    //根据id批量删除  删除id为5,6,7的
    @Test
    public void fun06(){
        List list = new ArrayList();
        list.add(5L);
        list.add(6L);
        list.add(7L);
        userMapper.deleteBatchIds(list);
    }

    //根据条件删除 删除name=赵六
    @Test
    public void fun07(){
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        //updateWrapper.eq("name","赵六").or().ge("age",18);
        updateWrapper.eq("name","赵六");
        userMapper.delete(updateWrapper);

    }


    //*************查询*******************
    //基本条件查询  查询name=张三的用户信息
    @Test
    public void fun08(){
        //1.构造查询条件
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name","张三");
        //queryWrapper.gt("age",16); //查询age>16

        //2.调用方法
        //userMapper.selectOne(queryWrapper); //查询1个的情况
        List<User> list = userMapper.selectList(queryWrapper);//查询多个的情况
        if(list.size()==1){
            System.out.println(list.get(0));
        }else{
            System.out.println(list);
        }
    }

    //模糊查询  查询姓张的用户
    @Test
    public void fun09(){
        //1.构造查询条件
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeRight("name","张"); // 相当于 like 张%
        //queryWrapper.like("name","张"); // 相当于 like %张%  查询名字里面包含张的
        //2.调用方法
        List<User> list = userMapper.selectList(queryWrapper);
        System.out.println(list);
    }

    //逻辑查询  多条件 and  查询姓张的 并且age>15岁的
    @Test
    public void fun10(){
        //1.构造查询条件
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeRight("name","张").gt("age",15);

        //2.调用方法
        List<User> list = userMapper.selectList(queryWrapper);
        System.out.println(list);
    }

    //逻辑查询   or  查询姓张的或者age<22岁的
    @Test
    public void fun11(){
        //1.构造查询条件
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeRight("name","张").or().lt("age",22);

        //2.调用方法
        List<User> list = userMapper.selectList(queryWrapper);
        System.out.println(list);
    }


    //排序查询   or  查询姓张的或者age<22岁的. 根据age降序查询, 如果age一样根据id降序
    @Test
    public void fun12(){
        //1.构造查询条件
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeRight("name","张").or().lt("age",22).orderByDesc("age").orderByDesc("id");
        //2.调用方法
        List<User> list = userMapper.selectList(queryWrapper);
        System.out.println(list);
    }

    //查询username和password两个列
    @Test
    public void fun13(){
        //1.构造查询条件
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("username","password");
        //2.调用方法
        List<User> list = userMapper.selectList(queryWrapper);
        System.out.println(list);
    }


    //分页条件查询
    @Test
    public void fun14(){
        //1.构造分页对象Page(封装查询哪一页和一页查询多少 eg: 参数是1,2 查询第一页, 查询2条)
        Page<User> page = new Page<>(1, 2);

        //2.构造条件对象
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("age",15);

        //3.调用selectPage()方法  返回值就是分页查询结果的对象(包含了总数量,查询的结果List...)
        IPage<User> pageResult = userMapper.selectPage(page, queryWrapper);
        System.out.println("总数量="+pageResult.getTotal());
        System.out.println("查询的数据="+pageResult.getRecords());

    }

    //LambdaQueryWrapper  别人敲了的项目
    @Test
    public void fun15(){
        //1.构造分页对象Page(封装查询哪一页和一页查询多少 eg: 参数是1,2 查询第一页, 查询2条)
        Page<User> page = new Page<>(1, 2);

        //2.构造条件对象
        //QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //queryWrapper.gt("age",15);

        //方式一: LambdaQueryWrapper
        //LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        //queryWrapper.gt(User::getAge,15);
        //IPage<User> pageResult = userMapper.selectPage(page, queryWrapper);

        //3.调用selectPage()方法  返回值就是分页查询结果的对象(包含了总数量,查询的结果List...)
        //方式二: 使用静态方法
        IPage<User> pageResult = userMapper.selectPage(page, Wrappers.<User>lambdaQuery().gt(User::getAge,15));

        System.out.println("总数量="+pageResult.getTotal());
        System.out.println("查询的数据="+pageResult.getRecords());

    }







}
