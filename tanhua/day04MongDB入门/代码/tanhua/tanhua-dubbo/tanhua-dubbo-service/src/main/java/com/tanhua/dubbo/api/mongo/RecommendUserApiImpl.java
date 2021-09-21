package com.tanhua.dubbo.api.mongo;

import com.tanhua.domain.mongo.RecommendUser;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 * 佳人服务接口实现类
 */
@Service
public class RecommendUserApiImpl implements RecommendUserApi{

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 根据当前用户查询佳人
     * @param userId
     * @return
     */
    @Override
    public RecommendUser queryMaxScore(Long userId) {
        //db.getCollection("recommend_user").find({toUserId:1}).sort({"score":-1}).limit(1)
        //理论情况应该再加一个条件date
        Query query = new Query();
        query.addCriteria(Criteria.where("toUserId").is(userId));//根据当前用户id查询
        query.with(Sort.by(Sort.Direction.DESC,"score"));//降序
        query.limit(1);
        return mongoTemplate.findOne(query,RecommendUser.class);
    }
}
