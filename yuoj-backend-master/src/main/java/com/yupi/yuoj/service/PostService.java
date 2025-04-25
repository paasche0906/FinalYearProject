package com.yupi.yuoj.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.yuoj.model.dto.post.PostQueryRequest;
import com.yupi.yuoj.model.entity.Post;
import com.yupi.yuoj.model.vo.PostVO;
import javax.servlet.http.HttpServletRequest;

/**
 * posting service
 */
public interface PostService extends IService<Post> {

    /**
     * calibration
     *
     * @param post
     * @param add
     */
    void validPost(Post post, boolean add);

    /**
     * Get query conditions
     *
     * @param postQueryRequest
     * @return
     */
    QueryWrapper<Post> getQueryWrapper(PostQueryRequest postQueryRequest);

    /**
     * Query from ES
     *
     * @param postQueryRequest
     * @return
     */
    Page<Post> searchFromEs(PostQueryRequest postQueryRequest);

    /**
     * Get post wrapper
     *
     * @param post
     * @param request
     * @return
     */
    PostVO getPostVO(Post post, HttpServletRequest request);

    /**
     * Paging for post encapsulation
     *
     * @param postPage
     * @param request
     * @return
     */
    Page<PostVO> getPostVOPage(Page<Post> postPage, HttpServletRequest request);
}
