package com.itheima.mm.service;

import com.itheima.mm.dao.WxMemberDao;
import com.itheima.mm.pojo.WxMember;
import com.itheima.mm.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.Map;

/**
 * @Description:
 * @Author: yp
 */
public class WxMemberService {


    /**
     * 根据openId查询
     * @param openid
     * @return
     */
    public WxMember findByOpenId(String openid) throws Exception {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
        WxMemberDao memberDao = sqlSession.getMapper(WxMemberDao.class);
        WxMember wxMember =  memberDao.selectByOpenId(openid);
        SqlSessionFactoryUtils.commitAndClose(sqlSession);
        return wxMember;
    }

    /**
     * 注册
     * @param wxMember
     */
    public void add(WxMember wxMember) throws Exception {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
        WxMemberDao memberDao = sqlSession.getMapper(WxMemberDao.class);
        memberDao.add(wxMember);
        SqlSessionFactoryUtils.commitAndClose(sqlSession);
    }


    /**
     * 设置学科和城市
     * @param paramMap
     */
    public void setCityCourse(Map paramMap) throws Exception {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
        WxMemberDao memberDao = sqlSession.getMapper(WxMemberDao.class);
        memberDao.setCityCourse(paramMap);
        SqlSessionFactoryUtils.commitAndClose(sqlSession);
    }
}
