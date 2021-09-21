package com.tanhua.dubbo.api.mongo;

import com.tanhua.domain.mongo.Publish;
import com.tanhua.domain.vo.PageResult;
import com.tanhua.domain.vo.PublishVo;

/**
 * 圈子服务接口
 */
public interface PublishApi{
    /**
     * 发布动态
     * @param publishVo
     */
    void savePublish(PublishVo publishVo);

    /**
     * 分页查询动态发布表（先查询时间线表 再查询动态发布表）
     * @param page
     * @param pagesize
     * @param currentUserId
     * @return
     */
    PageResult<Publish> queryPublishByTimeLine(int page, int pagesize, Long currentUserId);

    /**
     * 推荐动态
     */
    PageResult<Publish> queryPublishByReQuanzi(int page, int pagesize, Long currentUserId);
}
