package com.tanhua.dubbo.api.mongo;

import com.tanhua.domain.mongo.Friend;
import com.tanhua.domain.vo.PageResult;

/**
 * 好友服务接口
 */
public interface FriendApi {

    /**
     * 添加好友关系
     * @param friend
     */
    void saveFriend(Friend friend);

    /**
     * 联系人列表查询
     * @param page
     * @param pagesize
     * @param userId
     * @return
     */
    PageResult<Friend> queryContacts(Integer page, Integer pagesize, Long userId);
}
