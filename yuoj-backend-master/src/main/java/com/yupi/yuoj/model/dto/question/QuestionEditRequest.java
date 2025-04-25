package com.yupi.yuoj.model.dto.question;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Editorial requests
 */
@Data
public class QuestionEditRequest implements Serializable {

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
     * tag list
     */
    private List<String> tags;

    /**
     * Answers to the questions
     */
    private String answer;

    /**
     * Example of a question
     */
    private List<JudgeCase> judgeCase;

    /**
     * sealing arrangement
     */
    private JudgeConfig judgeConfig;

    private static final long serialVersionUID = 1L;
}