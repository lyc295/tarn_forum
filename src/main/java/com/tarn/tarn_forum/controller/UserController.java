package com.tarn.tarn_forum.controller;


import com.tarn.tarn_forum.server.UserService;
import com.tarn.tarn_forum.server_dbac.model.UserInfo;
import com.tarn.tarn_forum.server_dbac.model.UserSignin;
import com.tarn.tarn_forum.target.PassToken;
import com.tarn.tarn_forum.target.UserLoginToken;
import com.tarn.tarn_forum.utils.ResponseData.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/user")
@Api(tags = "用户基本操作", value = "基础类")
public class UserController {

    @Resource(name = "userServiceImpl")
    private UserService userServiceImpl;

    private static Logger logger = LoggerFactory.getLogger(UserController.class);


    @ApiOperation(value = "登录接口", notes = "登录测试")
    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    @ResponseBody
    @PassToken
    public ResponseData userLogin(UserInfo userInfo) {
        String methodDesc = "用户登录";
        return userServiceImpl.userLogin(userInfo,methodDesc);
    }


    @ApiOperation(value = "注册接口", notes = "注册测试")
    @RequestMapping(value = "/register.do", method = RequestMethod.POST)
    @ResponseBody
    @PassToken
    public ResponseData userRegister(UserInfo userInfo) {
        String methodDesc = "用户注册";
        return userServiceImpl.userRegister(userInfo, methodDesc);
    }


    @ApiOperation(value = "退出接口", notes = "退出测试")
    @RequestMapping(value = "/logout.do", method = RequestMethod.GET)
    @ResponseBody
    @UserLoginToken
    public ResponseData userLogout(HttpServletRequest httpServletRequest) {
        String methodDesc = "用户退出";
        return userServiceImpl.userLogout(httpServletRequest, methodDesc);
    }

    @ApiOperation(value = "查询用戶详情中心", notes = "查询用戶详情中心")
    @RequestMapping(value = "/userCenter.do", method = RequestMethod.GET)
    @ResponseBody
    @PassToken
    public ResponseData userCenter(Integer userId) {
        String methodDesc = "查询用戶详情中心";
        return userServiceImpl.userCenter(methodDesc,userId);
    }


    @ApiOperation(value = "用户签到", notes = "用户签到")
    @RequestMapping(value = "/userSignin.do", method = RequestMethod.GET)
    @ResponseBody
    @PassToken
    public ResponseData userSignin(UserSignin userSignin) {
        String methodDesc = "用户签到";
        return userServiceImpl.userSignin(methodDesc,userSignin);
    }


    @ApiOperation(value = "签到详情", notes = "签到详情")
    @RequestMapping(value = "/getSigninDetails.do", method = RequestMethod.GET)
    @ResponseBody
    @PassToken
    public ResponseData getSigninDetails(UserSignin userSignin) {
        String methodDesc = "签到详情";
        return userServiceImpl.getSigninDetails(methodDesc,userSignin);
    }


    @ApiOperation(value = "签到活跃榜查询", notes = "签到活跃榜查询")
    @RequestMapping(value = "/getSigninHotUser.do", method = RequestMethod.GET)
    @ResponseBody
    @PassToken
    public ResponseData getSigninHotUser() {
        String methodDesc = "签到活跃榜查询";
        return userServiceImpl.getSigninHotUser(methodDesc);
    }


}
