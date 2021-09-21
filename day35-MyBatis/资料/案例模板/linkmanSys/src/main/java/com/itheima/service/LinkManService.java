package com.itheima.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.bean.LinkMan;
import com.itheima.dao.LinkManDao;
import com.itheima.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

public class LinkManService {


    /**
     * 查询所有联系人
     * @return
     * @throws SQLException
     */
    public List<LinkMan> findAll() throws SQLException {
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        LinkManDao linkManDao = sqlSession.getMapper(LinkManDao.class);
        List<LinkMan> list = linkManDao.findAll();
        SqlSessionFactoryUtils.close(sqlSession);
        return list;
    }

    public boolean add(LinkMan linkMan) throws SQLException {
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        LinkManDao linkManDao = sqlSession.getMapper(LinkManDao.class);
        int result =  linkManDao.add(linkMan);
        sqlSession.commit();
        SqlSessionFactoryUtils.close(sqlSession);
        if(result>0){
            return  true;
         }
         return false;
    }

    public void delete(Integer id) throws SQLException {
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        LinkManDao linkManDao = sqlSession.getMapper(LinkManDao.class);
        linkManDao.deleteById(id);
        sqlSession.commit();
        SqlSessionFactoryUtils.close(sqlSession);    }

    /*public List<LinkMan> findPage(int curPageNo, int pageSize) throws SQLException {
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        LinkManDao linkManDao = sqlSession.getMapper(LinkManDao.class);
        //查询之前 设置分页
        PageHelper.startPage(curPageNo,pageSize);
        Page<LinkMan> page = linkManDao.findPage();
        SqlSessionFactoryUtils.close(sqlSession);
        return page.toPageInfo();
    }*/

}
