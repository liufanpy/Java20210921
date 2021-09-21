package com.itheima.mm.dao;

import java.util.List;
import java.util.Map; /**
 * @Description:
 * @Author: yp
 */
public interface CategoryDao {

    /**
     * 题库分类列表
     * @param paramMap
     * @return
     */
    List<Map> categoryList(Map paramMap);
}
