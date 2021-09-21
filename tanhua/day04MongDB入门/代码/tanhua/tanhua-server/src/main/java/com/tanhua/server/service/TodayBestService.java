package com.tanhua.server.service;

import com.tanhua.domain.db.UserInfo;
import com.tanhua.domain.mongo.RecommendUser;
import com.tanhua.domain.vo.TodayBestVo;
import com.tanhua.dubbo.api.db.UserInfoApi;
import com.tanhua.dubbo.api.mongo.RecommendUserApi;
import com.tanhua.server.interceptor.UserHolder;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * 佳人业务处理层
 */
@Service
public class TodayBestService {
    @Reference
    private RecommendUserApi recommendUserApi;

    @Reference
    private UserInfoApi userInfoApi;

    /**
     * 今日佳人
     */
    public TodayBestVo todayBest() {
        Long userId = UserHolder.getUserId();
        //1.定义返回TodayBestVo
        TodayBestVo vo  = new TodayBestVo();
        //2.根据当前用户id查询跟当前用户最匹配的今日佳人用户对象RecommendUser(UserId Score)
        //db.getCollection("recommend_user").find({toUserId:1}).sort({"score":-1}).limit(1)
        RecommendUser recommendUser =  recommendUserApi.queryMaxScore(userId);
        //假设recommendUser为空 设置默认用户
        if(recommendUser == null){
            recommendUser = new RecommendUser();
            recommendUser.setScore(88d);
            recommendUser.setUserId(6l);
        }
        //3.根据今日佳人UserId查询tb_userInfo表得到UserInfo对象
        UserInfo userInfo = userInfoApi.queryUserInfo(recommendUser.getUserId());
        //4.将UserInfo与Score 封装Vo返回
        BeanUtils.copyProperties(userInfo,vo);
        if(!StringUtils.isEmpty(userInfo.getTags())){
            vo.setTags(userInfo.getTags().split(","));
        }
        //设置缘分值
        vo.setFateValue(recommendUser.getScore().longValue());
        return vo;
    }
}
