package com.yupi.yuoj.model.dto.post;

import com.yupi.yuoj.common.PageRequest;
import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Enquiry request
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PostQueryRequest extends PageRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * id
     */
    private Long notId;

    /**
     * search term
     */
    private String searchText;

    /**
     * title
     */
    private String title;

    /**
     * content
     */
    private String content;

    /**
     * Tag List
     */
    private List<String> tags;

    /**
     * At least one label
     */
    private List<String> orTags;

    /**
     * Create user id
     */
    private Long userId;

    /**
     * Favourite user id
     */
    private Long favourUserId;

    private static final long serialVersionUID = 1L;
}