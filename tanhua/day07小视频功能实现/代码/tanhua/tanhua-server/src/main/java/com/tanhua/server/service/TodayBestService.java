package com.tanhua.server.service;

import com.tanhua.domain.db.UserInfo;
import com.tanhua.domain.mongo.RecommendUser;
import com.tanhua.domain.vo.PageResult;
import com.tanhua.domain.vo.RecommendUserQueryParam;
import com.tanhua.domain.vo.TodayBestVo;
import com.tanhua.dubbo.api.db.UserInfoApi;
import com.tanhua.dubbo.api.mongo.RecommendUserApi;
import com.tanhua.server.interceptor.UserHolder;
import org.apache.commons.lang3.RandomUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * 推荐用户列表（推荐佳人列表）
     */
    public PageResult<TodayBestVo> recommendation(RecommendUserQueryParam param) {
        //定义返回PageResult<TodayBestVo>
        PageResult<TodayBestVo> todayBestVoPageResult = new PageResult<>();
        //获取当前用户id
        Long userId = UserHolder.getUserId();
        //a.根据用户id分页查询推荐用户列表
        PageResult<RecommendUser> pageResult = recommendUserApi.queryPageByUserId(param.getPage(),param.getPagesize(),userId);
        List<RecommendUser> recommendUserList = null;
        //b.如果推荐用户列表数据为空，造10条假数据
        if(pageResult == null || CollectionUtils.isEmpty(pageResult.getItems())){
            //造数据
            recommendUserList = defaultRecommend();
        }
        else
        {
            recommendUserList = pageResult.getItems();
        }
        //c.根据推荐用户ids查询用户信息
        List<TodayBestVo> todayBestVoList = new ArrayList<>();
        for (RecommendUser recommendUser : recommendUserList) {
            TodayBestVo vo = new TodayBestVo();
            Long recommendUserId = recommendUser.getUserId();//推荐用户的id
            UserInfo userInfo = userInfoApi.queryUserInfo(recommendUserId);//推荐用户信息
            //4.将UserInfo与Score 封装Vo返回
            BeanUtils.copyProperties(userInfo,vo);
            if(!StringUtils.isEmpty(userInfo.getTags())){
                vo.setTags(userInfo.getTags().split(","));
            }
            //设置缘分值
            vo.setFateValue(recommendUser.getScore().longValue());
            todayBestVoList.add(vo);
        }

        //d.封装VO，返回给app
        //copy分页数据
        BeanUtils.copyProperties(pageResult,todayBestVoPageResult);
        //copy当前页面展示的数据
        todayBestVoPageResult.setItems(todayBestVoList);
        return todayBestVoPageResult;
    }


    //构造默认数据
    private List<RecommendUser> defaultRecommend() {
        String ids = "2,3,4,5,6,7,8,9,10,11";
        List<RecommendUser> records = new ArrayList<>();
        for (String id : ids.split(",")) {
            RecommendUser recommendUser = new RecommendUser();
            recommendUser.setUserId(Long.valueOf(id));
            recommendUser.setScore(RandomUtils.nextDouble(70, 98));
            records.add(recommendUser);
        }
        return records;
    }
}
