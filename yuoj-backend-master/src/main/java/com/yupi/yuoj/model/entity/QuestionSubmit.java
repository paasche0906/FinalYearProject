package com.yupi.yuoj.model.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * Title Submission
 * @TableName question_submit
 */
@TableName(value ="question_submit")
@Data
public class QuestionSubmit implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * programming language
     */
    private String language;

    /**
     * user code
     */
    private String code;

    /**
     * Judgement information (json object)
     */
    private String judgeInfo;

    /**
     * Judgement status (0 - pending judgement, 1 - judgement in progress, 2 - successful, 3 - failed)
     */
    private Integer status;

    /**
     * Title id
     */
    private Long questionId;

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