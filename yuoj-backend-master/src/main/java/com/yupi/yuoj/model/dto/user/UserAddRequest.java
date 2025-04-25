package com.yupi.yuoj.model.dto.user;

import java.io.Serializable;
import lombok.Data;

/**
 * User Creation Request
 */
@Data
public class UserAddRequest implements Serializable {

    /**
     * user nickname
     */
    private String userName;

    /**
     * username
     */
    private String userAccount;

    /**
     * user avatar
     */
    private String userAvatar;

    /**
     * User roles: user, admin
     */
    private String userRole;

    private static final long serialVersionUID = 1L;
}