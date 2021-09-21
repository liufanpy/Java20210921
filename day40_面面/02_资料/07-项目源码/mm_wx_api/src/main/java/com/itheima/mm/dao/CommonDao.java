package com.itheima.mm.dao;

import com.itheima.mm.pojo.Course;
import com.itheima.mm.pojo.Dict;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description:
 * @Author: yp
 */
public interface CommonDao {

    /**
     * 根据城市名字查询
     * @param cityName
     * @return
     */
    Dict selectByCityName(String cityName);

    /**
     * 根据DataTag查询
     * @param fs
     * @return
     */
    List<Dict> selectByDataTag(@Param("fs") Integer fs);

    /**
     * 查询学科列表
     * @return
     */
    List<Course> getCourseList();
}
