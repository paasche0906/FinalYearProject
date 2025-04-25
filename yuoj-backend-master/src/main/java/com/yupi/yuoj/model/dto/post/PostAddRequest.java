package com.yupi.yuoj.model.dto.post;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * Creating a request
 */
@Data
public class PostAddRequest implements Serializable {

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