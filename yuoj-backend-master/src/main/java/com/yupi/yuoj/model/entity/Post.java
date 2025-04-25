package com.yupi.yuoj.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * post
 */
@TableName(value = "post")
@Data
public class Post implements Serializable {

    /**
     * id
     */
    @TableId(type = IdType.ASSIGN_ID)
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
     * Tag list json
     */
    private String tags;

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