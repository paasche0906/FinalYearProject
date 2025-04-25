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
 * user
 */
@TableName(value = "user")
@Data
public class User implements Serializable {

    /**
     * id
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * user account
     */
    private String userAccount;

    /**
     * user password
     */
    private String userPassword;

    /**
     * Open platform id
     */
    private String unionId;

    /**
     * Public openId
     */
    private String mpOpenId;

    /**
     * user nickname
     */
    private String userName;

    /**
     * user avatar
     */
    private String userAvatar;

    /**
     * User Profile
     */
    private String userProfile;

    /**
     * User roles: user/admin/ban
     */
    private String userRole;

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