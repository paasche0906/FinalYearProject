package com.yupi.yuoj.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.yuoj.model.entity.Post;
import com.yupi.yuoj.model.entity.PostFavour;
import com.yupi.yuoj.model.entity.User;

/**
 * Post Collection Service
 */
public interface PostFavourService extends IService<PostFavour> {

    /**
     * Post Favorites
     *
     * @param postId
     * @param loginUser
     * @return
     */
    int doPostFavour(long postId, User loginUser);

    /**
     * Pagination to get the list of user's favourite posts
     *
     * @param page
     * @param queryWrapper
     * @param favourUserId
     * @return
     */
    Page<Post> listFavourPostByPage(IPage<Post> page, Wrapper<Post> queryWrapper,
            long favourUserId);

    /**
     * Post collection (internal service)
     *
     * @param userId
     * @param postId
     * @return
     */
    int doPostFavourInner(long userId, long postId);
}
