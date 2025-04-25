package com.yupi.yuoj.service;

import com.yupi.yuoj.model.entity.PostThumb;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.yuoj.model.entity.User;

/**
 * Post Liking Service
 */
public interface PostThumbService extends IService<PostThumb> {

    /**
     * pointing and calling (e.g. camera)
     *
     * @param postId
     * @param loginUser
     * @return
     */
    int doPostThumb(long postId, User loginUser);

    /**
     * Post likes (internal service)
     *
     * @param userId
     * @param postId
     * @return
     */
    int doPostThumbInner(long userId, long postId);
}
