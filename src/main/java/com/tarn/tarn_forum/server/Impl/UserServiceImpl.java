package com.tarn.tarn_forum.server.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tarn.tarn_forum.server.UserService;
import com.tarn.tarn_forum.server_dbac.dao.UserInfoMapper;
import com.tarn.tarn_forum.server_dbac.dao.UserSigninMapper;
import com.tarn.tarn_forum.server_dbac.model.UserInfo;
import com.tarn.tarn_forum.server_dbac.model.UserInfoCriteria;
import com.tarn.tarn_forum.server_dbac.model.UserSignin;
import com.tarn.tarn_forum.server_dbac.model.UserSigninCriteria;
import com.tarn.tarn_forum.server_dbml.dao.UserSigninMapperExt;
import com.tarn.tarn_forum.server_dbml.model.UserInfoExt;
import com.tarn.tarn_forum.server_dbml.model.UserSigninExt;
import com.tarn.tarn_forum.utils.Jwt.TokenUtil;
import com.tarn.tarn_forum.utils.ResponseData.ResponseCode;
import com.tarn.tarn_forum.utils.ResponseData.ResponseData;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserInfoMapper userInfoMapper;
    @Value("${web.upload-path}")
    private String path;
    @Autowired
    UserSigninMapper userSigninMapper;
    @Autowired
    UserSigninMapperExt userSigninMapperExt;

    /**
     * 用户登录
     *
     * @param userInfo
     * @param methodDesc
     * @return
     */
    @Override
    public ResponseData userLogin(UserInfo userInfo, String methodDesc) {
        try {
            JSONObject json = new JSONObject();
            UserInfoCriteria ex = new UserInfoCriteria();
            ex.createCriteria()
                    .andUserNameEqualTo(userInfo.getUserName())
                    .andUserPwdEqualTo(userInfo.getUserPwd())
                    .andUserFlagEqualTo((byte) 0);
            List<UserInfo> userInfos = userInfoMapper.selectByExample(ex)
            if (userInfos != null && userInfos.size() > 0) {
                String token = TokenUtil.getToken(userInfos.get(0));
                json.put("token", token);
                json.put("userId", userInfos.get(0).getUserId());
                json.put("userName", userInfos.get(0).getUserName());
                json.put("userHeadpicurl", userInfos.get(0).getUserHeadpicurl());
                return ResponseData.init(ResponseCode.SUCCESS.getValue(), methodDesc + "成功", json);
            } else {
                return ResponseData.init(ResponseCode.FAIL.getValue(), methodDesc + "失败");
            }
        } catch (Exception e) {
            logger.info("登录接口异常", e.getMessage());
            return ResponseData.init(ResponseCode.FAIL.getValue(), methodDesc + "异常");
        }
    }


    /**
     * 注册用户
     *
     * @param userInfo
     * @param methodDesc
     * @return
     */
    @Override
    @Transactional
    public ResponseData userRegister(UserInfo userInfo, String methodDesc) {
        try {
            UserInfoCriteria ex = new UserInfoCriteria();
            Random random = new Random();
            int a=random.nextInt(10);
            ex.createCriteria()
                    .andUserNameEqualTo(userInfo.getUserName());
            List<UserInfo> userInfos = userInfoMapper.selectByExample(ex);
            if (null != userInfos && !userInfos.isEmpty()) {
                //用户名重复
                if (StringUtils.equals(userInfos.get(0).getUserName(), userInfo.getUserName())) {
                    return ResponseData.init(ResponseCode.FAIL.getValue(), methodDesc + "用户名已存在");
                }
                //用户邮箱重复判断
                if (StringUtils.equals(userInfos.get(0).getUserEmail(), userInfo.getUserEmail())) {
                    return ResponseData.init(ResponseCode.FAIL.getValue(), methodDesc + "邮箱已存在");
                }
            }
            userInfo.setUserHeadpicurl(path+String.valueOf(a)+"."+"jpg");
            userInfo.setUserCreatetime(new Date());
            int i = userInfoMapper.insertSelective(userInfo);
            //插入语句返回 1 说明正常注册，否则说明注册时出现异常，（处理方法：事务回滚【Transactional】）
            if (i == 1) {
                return ResponseData.init(ResponseCode.SUCCESS.getValue(), methodDesc + "成功");
            } else {
                throw new RuntimeException("注册异常");
            }
        } catch (Exception e) {
            logger.info("注册接口异常", e.getMessage());
            return ResponseData.init(ResponseCode.FAIL.getValue(), methodDesc + "失败");
        }
    }

    /**
     * 用户退出
     *
     * @param methodDesc
     * @return
     */
    @Override
    public ResponseData userLogout(HttpServletRequest httpServletRequest, String methodDesc) {
        return ResponseData.init(ResponseCode.SUCCESS.getValue(), methodDesc + "成功");
    }

    /**
     * 用户中心
     *
     * @param methodDesc
     * @return
     */
    @Override
    public ResponseData userCenter(String methodDesc, Integer userId) {
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userId);
        return ResponseData.init(ResponseCode.SUCCESS.getValue(), methodDesc + "成功", userInfo);
    }

    @Override
    public ResponseData userSignin(String methodDesc, UserSignin userSignin) {

        UserSigninCriteria ex = new UserSigninCriteria();
        ex.createCriteria().andUserIdEqualTo(userSignin.getUserId());
        List<UserSignin> userSignins = userSigninMapper.selectByExample(ex);
        if (userSignins != null && userSignins.size() > 0) {
            //非第一次签到，数据库插入一条新的数据
            userSigninMapperExt.userSignin(userSignin.getUserId());
        } else {
            //若为第一次签到，数据库插入一条新的数据
            userSignin.setSigninTime(new Date());
            userSignin.setContinuitySigninDay(1);
            userSigninMapper.insertSelective(userSignin);
        }
        return ResponseData.init(ResponseCode.SUCCESS.getValue(), methodDesc + "成功");
    }

    @Override
    public ResponseData getSigninDetails(String methodDesc, UserSignin userSignin) {
        UserSigninExt userSignins = userSigninMapperExt.getSigninDetails(userSignin);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String sdfData = sdf.format(date);
        if(userSignins == null){
            userSignins = new UserSigninExt();
            userSignins.setSignInFlag(false);
            return ResponseData.init(ResponseCode.SUCCESS.getValue(), methodDesc + "成功", userSignins);
        }else {
            String format = sdf.format(userSignins.getSigninTime());
            if (StringUtils.equals(sdfData, format)) {
                userSignins.setSignInFlag(true);
            } else {
                userSignins.setSignInFlag(false);
            }
            return ResponseData.init(ResponseCode.SUCCESS.getValue(), methodDesc + "成功", userSignins);
        }
    }

    @Override
    public ResponseData getSigninHotUser(String methodDesc) {
        List<UserInfoExt> signinHotUser = userSigninMapperExt.getSigninHotUser();
        return ResponseData.init(ResponseCode.SUCCESS.getValue(), methodDesc + "成功", signinHotUser);

    }

    @Override
    public ResponseData imgUpload(String methodDesc,MultipartFile img,UserInfo userInfo) {
        if(img.isEmpty()){
            return ResponseData.init(ResponseCode.FAIL.getValue(), methodDesc + "失败");
        }
        String orlName = img.getOriginalFilename();
        String fileName = System.currentTimeMillis()+"."+orlName.substring(orlName.lastIndexOf(".")+1);
        String filePath = path;
        File dest =new File(filePath+fileName);
        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdirs();
        }
        try {
            img.transferTo(dest);
        }catch (Exception e){
            e.getMessage();
            return ResponseData.init(ResponseCode.FAIL.getValue(), methodDesc + "失败");
        }
        userInfo.setUserHeadpicurl(fileName);
        userInfoMapper.updateByPrimaryKeySelective(userInfo);
        return ResponseData.init(ResponseCode.SUCCESS.getValue(), methodDesc + "成功",filePath+fileName);
    }

}
