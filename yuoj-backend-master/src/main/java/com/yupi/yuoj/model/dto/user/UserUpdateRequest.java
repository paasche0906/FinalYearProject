package com.yupi.yuoj.model.dto.user;

import java.io.Serializable;
import lombok.Data;

/**
 * User update requests
 */
@Data
public class UserUpdateRequest implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * user nickname
     */
    private String userName;

    /**
     * user avatar
     */
    private String userAvatar;

    /**
     * brief
     */
    private String userProfile;

    /**
     * user roles: user/admin/ban
     */
    private String userRole;

    private static final long serialVersionUID = 1L;
}