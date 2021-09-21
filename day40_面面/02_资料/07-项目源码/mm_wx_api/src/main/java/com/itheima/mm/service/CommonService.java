package com.itheima.mm.service;

import com.itheima.mm.dao.CommonDao;
import com.itheima.mm.pojo.Course;
import com.itheima.mm.pojo.Dict;
import com.itheima.mm.utils.LocationUtil;
import com.itheima.mm.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map; /**
 * @Description:
 * @Author: yp
 */
public class CommonService {


    /**
     * 获得城市的数据
     * @param hashMap
     * @return
     */
    public Map getCitys(Map hashMap) throws Exception {
        Map resultMap = new HashMap();
        SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
        CommonDao commonDao =  sqlSession.getMapper(CommonDao.class);

        //1.根据location(经纬度)调用高德 获得当前的城市
        String location = (String) hashMap.get("location");
        String cityName = LocationUtil.parseLocation(location);
        //2.调用Dao 根据城市名字查询 获得 Dict
        Dict dict =  commonDao.selectByCityName(cityName);
        resultMap.put("location",dict);

        //3. 调用Dao,根据fs 获得城市的列表 List<Dict>
        Integer fs = (Integer) hashMap.get("fs");
        List<Dict> list =  commonDao.selectByDataTag(fs);
        resultMap.put("citys",list);
        //4.封装到Map 返回
        SqlSessionFactoryUtils.commitAndClose(sqlSession);
        return resultMap;
    }

    /**
     * 获得学科列表
     * @return
     */
    public List<Course> getCourseList() throws Exception {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
        CommonDao commonDao =  sqlSession.getMapper(CommonDao.class);
        List<Course> list =  commonDao.getCourseList();
        SqlSessionFactoryUtils.commitAndClose(sqlSession);
        return list;
    }
}
