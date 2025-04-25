package com.yupi.yuoj.model.dto.postfavour;

import com.yupi.yuoj.common.PageRequest;
import com.yupi.yuoj.model.dto.post.PostQueryRequest;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Post Collection Search Request
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PostFavourQueryRequest extends PageRequest implements Serializable {

    /**
     * Post Search Requests
     */
    private PostQueryRequest postQueryRequest;

    /**
     * user id
     */
    private Long userId;

    private static final long serialVersionUID = 1L;
}