package com.yupi.yuoj.model.dto.question;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Creating a request
 */
@Data
public class QuestionAddRequest implements Serializable {

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
     * question answer
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