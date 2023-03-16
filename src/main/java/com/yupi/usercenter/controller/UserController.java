package com.yupi.usercenter.controller;

import java.util.List;

import com.yupi.usercenter.common.BaseResponse;
import com.yupi.usercenter.common.ErrorCode;
import com.yupi.usercenter.common.ResultUtils;
import com.yupi.usercenter.exception.BusinessException;
import com.yupi.usercenter.model.domain.User;
import com.yupi.usercenter.model.domain.request.UserDeleteRequest;
import com.yupi.usercenter.model.domain.request.UserLoginRequest;
import com.yupi.usercenter.model.domain.request.UserRegisterRequest;
import com.yupi.usercenter.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import static com.yupi.usercenter.constant.Constant.USER_LOGIN_STATE;


/**
 * 用户接口
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 用户注册接口
     *
     * @param userRegisterRequest 用户注册请求体
     * @return 返回用户id
     */
    @PostMapping("/register")
    public BaseResponse<Long> registerController(@RequestBody UserRegisterRequest userRegisterRequest) {
        String userAccount = userRegisterRequest.getUserAccount();
        String userPassword = userRegisterRequest.getUserPassword();
        String checkPassword = userRegisterRequest.getCheckPassword();
        String planetCode = userRegisterRequest.getPlanetCode();
        if (StringUtils.isAnyEmpty(userAccount, userPassword, checkPassword, planetCode)) {
            throw new BusinessException(ErrorCode.NULL_ERROR);
        }
        return userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
    }

    /**
     * 用户登录接口
     *
     * @param userLoginRequest 用户登录请求体
     * @param request          HttpServletRequest
     * @return 用户信息
     */
    @PostMapping("/login")
    public BaseResponse<User> loginController(@RequestBody UserLoginRequest userLoginRequest, HttpServletRequest request) {
        String userAccount = userLoginRequest.getUserAccount();
        String userPassword = userLoginRequest.getUserPassword();


        if (StringUtils.isAnyEmpty(userAccount, userPassword)) {
            return null;
        }


        return userService.userLogin(userAccount, userPassword, request);
    }

    /**
     * 通过用户名查询用户接口
     *
     * @param userAccount 用户名
     * @return 所有符合条件的用户集合
     */
    @GetMapping("/search")
    public BaseResponse<List<User>> searchController(String userAccount, HttpServletRequest request) {
        return userService.userSearch(userAccount, request);
    }

    /**
     * @param userDeleteRequest 用户删除请求体
     * @return 是否删除
     */
    @PostMapping("/delete")
    public BaseResponse<Boolean> deleteController(@RequestBody UserDeleteRequest userDeleteRequest, HttpServletRequest request) {
        return userService.userDelete(userDeleteRequest.getId(), request);
    }

    /**
     * 获取当前用户
     */
    @GetMapping("/current")
    public BaseResponse<User> getCurrentUser(HttpServletRequest request) {
        return userService.getCurrentUser(request);
    }

    /**
     * 用户退出登录
     */
    @GetMapping("/logout")
    public BaseResponse<Integer> userLogout(HttpServletRequest request) {
        return userService.userLogout(request);
    }


}
