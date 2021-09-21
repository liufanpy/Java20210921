package com.tanhua.dubbo.api.mongo;

import com.tanhua.domain.mongo.Comment;
import com.tanhua.domain.vo.PageResult;

/**
 * 评论服务接口
 */
public interface CommentApi {
    /**
     * 动态点赞 点赞数量+1 返回点赞总数
     * @param comment
     * @return
     */
    long saveComment(Comment comment);

    /**
     * 动态取消点赞 点赞数量-1 返回点赞总数
     * @param comment
     * @return
     */
    long removeComment(Comment comment);

    /**
     * 评论列表分页查询
     * @param publishId
     * @param page
     * @param pagesize
     * @return
     */
    PageResult<Comment> queryCommentsByPage(String publishId, int page, int pagesize);
}
