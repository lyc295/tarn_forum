package com.tarn.tarn_forum.server_dbac.dao;

import com.tarn.tarn_forum.server_dbac.model.UserSignin;
import com.tarn.tarn_forum.server_dbac.model.UserSigninCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserSigninMapper {
    int countByExample(UserSigninCriteria example);

    int deleteByExample(UserSigninCriteria example);

    int deleteByPrimaryKey(Integer signinId);

    int insert(UserSignin record);

    int insertSelective(UserSignin record);

    List<UserSignin> selectByExample(UserSigninCriteria example);

    UserSignin selectByPrimaryKey(Integer signinId);

    int updateByExampleSelective(@Param("record") UserSignin record, @Param("example") UserSigninCriteria example);

    int updateByExample(@Param("record") UserSignin record, @Param("example") UserSigninCriteria example);

    int updateByPrimaryKeySelective(UserSignin record);

    int updateByPrimaryKey(UserSignin record);
}