package com.yupi.yuoj.model.dto.questionsubmit;

import lombok.Data;

import java.io.Serializable;

/**
 * Creating a request
 */
@Data
public class QuestionSubmitAddRequest implements Serializable {

    /**
     * programming language
     */
    private String language;

    /**
     * user code
     */
    private String code;

    /**
     * Title id
     */
    private Long questionId;

    private static final long serialVersionUID = 1L;
}