package com.yupi.yuoj.model.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * title
 * @TableName question
 */
@TableName(value ="question")
@Data
public class Question implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * caption
     */
    private String title;

    /**
     * element
     */
    private String content;

    /**
     * List of tags (json array)
     */
    private String tags;

    /**
     * Answers to the questions
     */
    private String answer;

    /**
     * Number of topic submissions
     */
    private Integer submitNum;

    /**
     * The title passes through the number of
     */
    private Integer acceptedNum;

    /**
     * Problem examples (json arrays)
     */
    private String judgeCase;

    /**
     * Judgement Configuration (json object)
     */
    private String judgeConfig;

    /**
     * number of likes (on a website)
     */
    private Integer thumbNum;

    /**
     * Number of collections
     */
    private Integer favourNum;

    /**
     * Create user id
     */
    private Long userId;

    /**
     * Creation time
     */
    private Date createTime;

    /**
     * update time
     */
    private Date updateTime;

    /**
     * Delete or not
     */
    @TableLogic
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}