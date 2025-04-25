package com.yupi.yuoj.model.dto.question;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.yupi.yuoj.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Enquiry request
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class QuestionQueryRequest extends PageRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * title
     */
    private String title;

    /**
     * element
     */
    private String content;

    /**
     * Tag List
     */
    private List<String> tags;

    /**
     * Answers to the questions
     */
    private String answer;

    /**
     * Create user id
     */
    private Long userId;

    private static final long serialVersionUID = 1L;
}