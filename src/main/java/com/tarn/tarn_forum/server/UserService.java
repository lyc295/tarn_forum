package com.tarn.tarn_forum.server;

import com.tarn.tarn_forum.server_dbac.model.UserInfo;
import com.tarn.tarn_forum.server_dbac.model.UserSignin;
import com.tarn.tarn_forum.utils.ResponseData.ResponseData;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    /**
     * 用户登录
     * @param userInfo
     * @param methodDesc
     * @return
     */
    ResponseData userLogin(UserInfo userInfo, String methodDesc);

    /**
     * 用户注册
     * @param userInfo
     * @param methodDesc
     * @return
     */
    ResponseData userRegister(UserInfo userInfo,String methodDesc);

    /**
     * 用户退出
     * @param methodDesc
     */
    ResponseData userLogout(HttpServletRequest httpServletRequest, String methodDesc);

    ResponseData userCenter(String methodDesc,Integer userId);

    ResponseData userSignin(String methodDesc,UserSignin userSignin);

    ResponseData getSigninDetails(String methodDesc,UserSignin userSignin);

    ResponseData getSigninHotUser(String methodDesc);
}
