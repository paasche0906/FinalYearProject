package com.yupi.yuoj.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yupi.yuoj.model.entity.Post;
import com.yupi.yuoj.model.entity.PostFavour;
import org.apache.ibatis.annotations.Param;

/**
 * Post Collection Database Operation
 */
public interface PostFavourMapper extends BaseMapper<PostFavour> {

    /**
     * Pagination search favourite posts list
     *
     * @param page
     * @param queryWrapper
     * @param favourUserId
     * @return
     */
    Page<Post> listFavourPostByPage(IPage<Post> page, @Param(Constants.WRAPPER) Wrapper<Post> queryWrapper,
            long favourUserId);

}




