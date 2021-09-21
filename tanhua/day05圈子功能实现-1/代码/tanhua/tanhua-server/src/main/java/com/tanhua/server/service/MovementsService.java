package com.tanhua.server.service;

import com.tanhua.commons.exception.TanHuaException;
import com.tanhua.commons.templates.OssTemplate;
import com.tanhua.domain.db.UserInfo;
import com.tanhua.domain.mongo.Publish;
import com.tanhua.domain.vo.ErrorResult;
import com.tanhua.domain.vo.MomentVo;
import com.tanhua.domain.vo.PageResult;
import com.tanhua.domain.vo.PublishVo;
import com.tanhua.dubbo.api.db.UserInfoApi;
import com.tanhua.dubbo.api.mongo.PublishApi;
import com.tanhua.server.interceptor.UserHolder;
import com.tanhua.server.utils.RelativeDateFormat;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 圈子业务处理层
 */
@Service
public class MovementsService {

    @Autowired
    private OssTemplate ossTemplate;

    @Reference
    private PublishApi publishApi;

    @Reference
    private UserInfoApi userInfoApi;

    /**
     * 发布动态
     */
    public void savePublish(PublishVo publishVo, MultipartFile[] imageContent) {
        try {
            //1.imageContent处理-上传oss 并封装成List<String>
            List<String> medias = new ArrayList<>();
            if(imageContent != null && imageContent.length>0){
                for (MultipartFile multipartFile : imageContent) {
                    String imgUrl = ossTemplate.upload(multipartFile.getOriginalFilename(), multipartFile.getInputStream());
                    medias.add(imgUrl);
                }
            }
            //设置到PublishVo中
            publishVo.setMedias(medias);
            //设置当前的用户id
            publishVo.setUserId(UserHolder.getUserId());
            //2.调用服务提供者-发布动态
            publishApi.savePublish(publishVo);
        } catch (IOException e) {
            throw new TanHuaException(ErrorResult.error());
        }
    }

    /**
     * 好友动态
     */
    public PageResult<MomentVo> queryPublishByTimeLine(int page, int pagesize) {
        //定义返回的PageResult<MomentVo>
        PageResult<MomentVo> voPageResult = new PageResult<>();
        Long currentUserId = UserHolder.getUserId();//当前用户id
        //a.分页查询自己的时间表服务（好友时间线表）
        PageResult<Publish> pageResult = publishApi.queryPublishByTimeLine(page,pagesize,currentUserId);
        if(StringUtils.isEmpty(pageResult) || CollectionUtils.isEmpty(pageResult.getItems())){
            //前端没有处理的很好 返回空对象设置值
            voPageResult = new PageResult<>(0l,10l,0l,1l,null);
            return voPageResult;
        }
        //将List<Publish> 与 UserInfo 转为 List<MomentVo>
        List<MomentVo> momentVoList = new ArrayList<>();
        //b.再根据发布表中发布动态的用户id 查询用户信息
        for (Publish publish : pageResult.getItems()) {
            MomentVo momentVo = new MomentVo();

            Long userId = publish.getUserId();//动态发布的用户id
            UserInfo userInfo = userInfoApi.queryUserInfo(userId);

            //将UserInfo对象数据 copy momentVo
            BeanUtils.copyProperties(userInfo,momentVo);
            //将Publish对象数据 copy momentVo
            BeanUtils.copyProperties(publish,momentVo);

            if(!StringUtils.isEmpty(userInfo.getTags())) {
                momentVo.setTags(userInfo.getTags().split(","));
            }
            momentVo.setId(publish.getId().toHexString());///动态id
            //将list集合转为string数组
            momentVo.setImageContent(publish.getMedias().toArray(new String[]{}));
            //距离 写死了
            momentVo.setDistance("1米");
            //将发布表中时间 转为 几个小时前发布的
            momentVo.setCreateDate(RelativeDateFormat.format(new Date(publish.getCreated())));
            momentVo.setHasLiked(0);////是否点赞（1是，0否）
            momentVo.setHasLoved(0);////是否喜欢（1是，0否）
            momentVoList.add(momentVo);
        }
        //d.将发布表数据 跟 用户数据 封装Vo返回
        BeanUtils.copyProperties(pageResult,voPageResult);//分页数据
        voPageResult.setItems(momentVoList);//设置vo list集合数据
        return voPageResult;
    }

    /**
     * 推荐动态
     */
    public PageResult<MomentVo> queryPublishByReQuanzi(int page, int pagesize) {
        //定义返回的PageResult<MomentVo>
        PageResult<MomentVo> voPageResult = new PageResult<>();
        Long currentUserId = UserHolder.getUserId();//当前用户id
        //a.分页查询自己的时间表服务（好友时间线表）
        PageResult<Publish> pageResult = publishApi.queryPublishByReQuanzi(page,pagesize,currentUserId);
        if(StringUtils.isEmpty(pageResult) || CollectionUtils.isEmpty(pageResult.getItems())){
            //前端没有处理的很好 返回空对象设置值
            voPageResult = new PageResult<>(0l,10l,0l,1l,null);
            return voPageResult;
        }
        //将List<Publish> 与 UserInfo 转为 List<MomentVo>
        List<MomentVo> momentVoList = new ArrayList<>();
        //b.再根据发布表中发布动态的用户id 查询用户信息
        for (Publish publish : pageResult.getItems()) {
            MomentVo momentVo = new MomentVo();

            Long userId = publish.getUserId();//动态发布的用户id
            UserInfo userInfo = userInfoApi.queryUserInfo(userId);

            //将UserInfo对象数据 copy momentVo
            BeanUtils.copyProperties(userInfo,momentVo);
            //将Publish对象数据 copy momentVo
            BeanUtils.copyProperties(publish,momentVo);

            if(!StringUtils.isEmpty(userInfo.getTags())) {
                momentVo.setTags(userInfo.getTags().split(","));
            }
            momentVo.setId(publish.getId().toHexString());///动态id
            //将list集合转为string数组
            momentVo.setImageContent(publish.getMedias().toArray(new String[]{}));
            //距离 写死了
            momentVo.setDistance("1米");
            //将发布表中时间 转为 几个小时前发布的
            momentVo.setCreateDate(RelativeDateFormat.format(new Date(publish.getCreated())));
            momentVo.setHasLiked(0);////是否点赞（1是，0否）
            momentVo.setHasLoved(0);////是否喜欢（1是，0否）
            momentVoList.add(momentVo);
        }
        //d.将发布表数据 跟 用户数据 封装Vo返回
        BeanUtils.copyProperties(pageResult,voPageResult);//分页数据
        voPageResult.setItems(momentVoList);//设置vo list集合数据
        return voPageResult;
    }
}
