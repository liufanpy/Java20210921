package com.tanhua.dubbo.api.mongo;

import com.tanhua.domain.mongo.RecommendUser;
import com.tanhua.domain.vo.PageResult;

/**
 * 佳人服务接口
 */
public interface RecommendUserApi {
    /**
     * 根据当前用户查询佳人
     * @param userId
     * @return
     */
    RecommendUser queryMaxScore(Long userId);

    /**
     * 根据当前用户id分页查询用户列表
     * @param page
     * @param pagesize
     * @param userId
     * @return
     */
    PageResult<RecommendUser> queryPageByUserId(Integer page, Integer pagesize, Long userId);
}
