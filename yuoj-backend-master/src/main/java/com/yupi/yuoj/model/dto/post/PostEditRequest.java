package com.yupi.yuoj.model.dto.post;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * Editorial requests
 */
@Data
public class PostEditRequest implements Serializable {

    /**
     * id
     */
    private Long id;

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

    private static final long serialVersionUID = 1L;
}