package com.yupi.yuoj.model.dto.questionsubmit;

import com.yupi.yuoj.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * Enquiry request
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class QuestionSubmitQueryRequest extends PageRequest implements Serializable {

    /**
     * programming language
     */
    private String language;

    /**
     * Submission Status
     */
    private Integer status;

    /**
     * Title id
     */
    private Long questionId;


    /**
     * User id
     */
    private Long userId;

    private static final long serialVersionUID = 1L;
}