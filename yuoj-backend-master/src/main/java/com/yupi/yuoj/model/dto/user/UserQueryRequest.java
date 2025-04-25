package com.yupi.yuoj.model.dto.user;

import com.yupi.yuoj.common.PageRequest;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * User Query Request
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserQueryRequest extends PageRequest implements Serializable {
    /**
     * id
     */
    private Long id;

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
     * brief
     */
    private String userProfile;

    /**
     * User roles: user/admin/ban
     */
    private String userRole;

    private static final long serialVersionUID = 1L;
}