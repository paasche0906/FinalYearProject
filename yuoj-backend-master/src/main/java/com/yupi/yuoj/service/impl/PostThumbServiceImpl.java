package com.yupi.yuoj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yupi.yuoj.common.ErrorCode;
import com.yupi.yuoj.exception.BusinessException;
import com.yupi.yuoj.mapper.PostThumbMapper;
import com.yupi.yuoj.model.entity.Post;
import com.yupi.yuoj.model.entity.PostThumb;
import com.yupi.yuoj.model.entity.User;
import com.yupi.yuoj.service.PostService;
import com.yupi.yuoj.service.PostThumbService;
import javax.annotation.Resource;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * The post zazen service implementation
 */
@Service
public class PostThumbServiceImpl extends ServiceImpl<PostThumbMapper, PostThumb>
        implements PostThumbService {

    @Resource
    private PostService postService;

    @Override
    public int doPostThumb(long postId, User loginUser) {

        Post post = postService.getById(postId);
        if (post == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }

        long userId = loginUser.getId();

        PostThumbService postThumbService = (PostThumbService) AopContext.currentProxy();
        synchronized (String.valueOf(userId).intern()) {
            return postThumbService.doPostThumbInner(userId, postId);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int doPostThumbInner(long userId, long postId) {
        PostThumb postThumb = new PostThumb();
        postThumb.setUserId(userId);
        postThumb.setPostId(postId);
        QueryWrapper<PostThumb> thumbQueryWrapper = new QueryWrapper<>(postThumb);
        PostThumb oldPostThumb = this.getOne(thumbQueryWrapper);
        boolean result;

        if (oldPostThumb != null) {
            result = this.remove(thumbQueryWrapper);
            if (result) {

                result = postService.update()
                        .eq("id", postId)
                        .gt("thumbNum", 0)
                        .setSql("thumbNum = thumbNum - 1")
                        .update();
                return result ? -1 : 0;
            } else {
                throw new BusinessException(ErrorCode.SYSTEM_ERROR);
            }
        } else {

            result = this.save(postThumb);
            if (result) {

                result = postService.update()
                        .eq("id", postId)
                        .setSql("thumbNum = thumbNum + 1")
                        .update();
                return result ? 1 : 0;
            } else {
                throw new BusinessException(ErrorCode.SYSTEM_ERROR);
            }
        }
    }

}




