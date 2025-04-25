package com.yupi.yuoj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yupi.yuoj.model.entity.Post;
import java.util.Date;
import java.util.List;

/**
 * Post Database Operation
 */
public interface PostMapper extends BaseMapper<Post> {

    /**
     * Query post list (including deleted data)
     */
    List<Post> listPostWithDelete(Date minUpdateTime);

}




