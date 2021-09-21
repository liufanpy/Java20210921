package com.itheima.mm.service;

import com.itheima.mm.dao.CategoryDao;
import com.itheima.mm.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: yp
 */
public class CategoryService {


    /**
     * 题库分类列表
     *
     * @param paramMap
     * @return
     * @throws Exception
     */
    public List<Map> categoryList(Map paramMap) throws Exception {

        SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
        CategoryDao categoryDao = sqlSession.getMapper(CategoryDao.class);
        //判断一下 调用Dao
        List<Map> list = null;
        Object categoryKindObj =  paramMap.get("categoryKind");
        Integer categoryKind;

        if(categoryKindObj instanceof  String){
            categoryKind = Integer.parseInt((String)categoryKindObj);
        }else{
            categoryKind = (Integer) categoryKindObj;
        }

        if (categoryKind == 1) {
            //按照学科目录
            list = categoryDao.categoryList(paramMap);
        } else if (categoryKind == 2) {
            //按照企业

        } else if (categoryKind == 3) {
            //按照行业方向
        }

        SqlSessionFactoryUtils.commitAndClose(sqlSession);

        return list;
    }
}
