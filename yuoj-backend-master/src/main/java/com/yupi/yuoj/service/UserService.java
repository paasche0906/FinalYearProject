package com.yupi.yuoj.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.yuoj.model.dto.user.UserQueryRequest;
import com.yupi.yuoj.model.entity.User;
import com.yupi.yuoj.model.vo.LoginUserVO;
import com.yupi.yuoj.model.vo.UserVO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import me.chanjar.weixin.common.bean.WxOAuth2UserInfo;

/**
 * customer service
 */
public interface UserService extends IService<User> {

    /**
     * User Registration
     *
     * @param userAccount
     * @param userPassword
     * @param checkPassword
     * @return
     */
    long userRegister(String userAccount, String userPassword, String checkPassword);

    /**
     * user login
     *
     * @param userAccount
     * @param userPassword
     * @param request
     * @return
     */
    LoginUserVO userLogin(String userAccount, String userPassword, HttpServletRequest request);


    LoginUserVO userLoginByMpOpen(WxOAuth2UserInfo wxOAuth2UserInfo, HttpServletRequest request);

    /**
     * Get current logged in user
     *
     * @param request
     * @return
     */
    User getLoginUser(HttpServletRequest request);

    /**
     * Get the currently logged in user (allow not logged in)
     *
     * @param request
     * @return
     */
    User getLoginUserPermitNull(HttpServletRequest request);

    /**
     * Is it an administrator
     *
     * @param request
     * @return
     */
    boolean isAdmin(HttpServletRequest request);

    /**
     * Is it an administrator
     *
     * @param user
     * @return
     */
    boolean isAdmin(User user);

    /**
     * user cancellation
     *
     * @param request
     * @return
     */
    boolean userLogout(HttpServletRequest request);

    /**
     * Get desensitised logged-in user information
     *
     * @return
     */
    LoginUserVO getLoginUserVO(User user);

    /**
     * Getting desensitised user information
     *
     * @param user
     * @return
     */
    UserVO getUserVO(User user);

    /**
     * Getting desensitised user information
     *
     * @param userList
     * @return
     */
    List<UserVO> getUserVO(List<User> userList);

    /**
     * Get query conditions
     *
     * @param userQueryRequest
     * @return
     */
    QueryWrapper<User> getQueryWrapper(UserQueryRequest userQueryRequest);

}
