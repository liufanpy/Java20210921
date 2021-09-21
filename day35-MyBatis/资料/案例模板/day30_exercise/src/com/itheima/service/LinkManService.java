package com.itheima.service;

import com.itheima.bean.LinkMan;
import com.itheima.dao.LinkManDao;

import java.sql.SQLException;
import java.util.List;

public class LinkManService {

    LinkManDao linkManDao = new LinkManDao();

    /**
     * 查询所有联系人
     * @return
     * @throws SQLException
     */
    public List<LinkMan> findAll() throws SQLException {
        List<LinkMan> list = linkManDao.findAll();
        return list;
    }

    public boolean add(LinkMan linkMan) throws SQLException {
         int result =  linkManDao.add(linkMan);
         if(result>0){
             return  true;
         }
         return false;
    }

    public void delete(Integer id) throws SQLException {
        linkManDao.deleteById(id);
    }

    public List<LinkMan> findPage(int curPageNo, int pageSize) throws SQLException {
        int index = (curPageNo-1)*pageSize;
        return linkManDao.findPage(index,pageSize);
    }

    public int count() throws SQLException {
        return linkManDao.count();
    }
}
