package com.yupi.yuoj.model.dto.user;

import java.io.Serializable;
import lombok.Data;

/**
 * User request to update personal information
 */
@Data
public class UserUpdateMyRequest implements Serializable {

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

    private static final long serialVersionUID = 1L;
}