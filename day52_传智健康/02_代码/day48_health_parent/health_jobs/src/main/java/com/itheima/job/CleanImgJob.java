package com.itheima.job;

import com.itheima.dao.SetmealDao;
import com.itheima.utils.QiNiuUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/*
    这是定时清除七牛云上面的垃圾图片
        垃圾图片的定义 ： 七牛的图片 -  mysql数据库里的图片
 */
@Component
public class CleanImgJob {

    @Autowired
    private SetmealDao dao;


    /**
     * 删除垃圾图片
     */
    public void cleanImg(){

        //1. 查询七牛上面的所有图片
        List<String> qiniuList = QiNiuUtils.listFile();
        System.out.println("七牛上面的图片是：" + qiniuList);

        //2. 查询数据库里面的所有图片
        List<String> dbList = dao.findAllImg();
        System.out.println("数据库里面的图片是：" + dbList);

        //3. 比较之后，找出垃圾图片
        //大的集合里面移除一部分数据，这部分数据可以是另一个集合里面内容。
        qiniuList.removeAll(dbList);
        System.out.println("剩下的要删除的图片是：" + qiniuList);

        //4. 删除垃圾图片
        QiNiuUtils.removeFiles(qiniuList.toArray(new String[]{}));
    }
}
