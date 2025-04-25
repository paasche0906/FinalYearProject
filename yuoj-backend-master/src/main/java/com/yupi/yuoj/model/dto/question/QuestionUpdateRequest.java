package com.yupi.yuoj.model.dto.question;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Update request
 */
@Data
public class QuestionUpdateRequest implements Serializable {


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