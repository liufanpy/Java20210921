package com.itheima.mm.dao;

import com.itheima.mm.pojo.WxMember;

import java.util.Map;

/**
 * @Description:
 * @Author: yp
 */
public interface WxMemberDao {
    /**
     * 根据opendId查询
     * @param openid
     * @return
     */
    WxMember selectByOpenId(String openid);

    /**
     * 注册
     * @param wxMember
     */
    void add(WxMember wxMember);

    /**
     * 更新学科和城市
     * @param paramMap
     */
    void setCityCourse(Map paramMap);
}
