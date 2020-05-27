package com.tarn.tarn_forum.server_dbml.dao;

import com.tarn.tarn_forum.server_dbac.model.UserSignin;
import com.tarn.tarn_forum.server_dbac.model.UserSigninCriteria;
import com.tarn.tarn_forum.server_dbml.model.UserInfoExt;
import com.tarn.tarn_forum.server_dbml.model.UserSigninExt;
import com.tarn.tarn_forum.utils.ResponseData.ResponseData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserSigninMapperExt {

    int userSignin(UserSignin userSignin);

    List<UserInfoExt> getSigninHotUser();

    UserSigninExt getSigninDetails(UserSignin userSignin);

}