package com.yupi.usercenter.service;

import com.yupi.usercenter.common.BaseResponse;
import com.yupi.usercenter.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author hongs
 * @description 针对表【user(用户表)】的数据库操作Service
 * @createDate 2023-03-04 20:47:54
 */
public interface UserService extends IService<User> {
    /**
     * 注册
     *
     * @param userAccount   用户账号
     * @param userPassword  密码
     * @param checkPassword 确认密码
     * @param planetCode 星球编码
     * @return 用户id
     */
    BaseResponse<Long> userRegister(String userAccount, String userPassword, String checkPassword , String planetCode);

    /**
     * 登录
     *
     * @param userAccount  用户账号
     * @param userPassword 用户密码
     * @param request      HttpServletRequest
     * @return 返回用户脱敏的信息
     */
    BaseResponse<User> userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 通过用户名查询
     *
     * @param username 用户名
     * @return 符合条件的用户集合
     */
    BaseResponse<List<User>> userSearch(String username, HttpServletRequest request);


    /**
     * 通过用户id删除用户
     * @param id 用户id
     * @return 是否成功
     */
    BaseResponse<Boolean> userDelete(long id, HttpServletRequest request);

    /**
     * 用户脱敏
     * @param originUser 原始用户
     * @return 脱敏后的用户
     */
    User getSafetyUser(User originUser);

    /**
     * 获取当前用户
     * @return 当前用户
     */
    BaseResponse<User> getCurrentUser(HttpServletRequest request);

    /**
     * 用户退出
     */
    BaseResponse<Integer> userLogout(HttpServletRequest request);

}
