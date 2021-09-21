package com.tanhua.dubbo.api.mongo;

import com.tanhua.domain.mongo.RecommendUser;

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
}
