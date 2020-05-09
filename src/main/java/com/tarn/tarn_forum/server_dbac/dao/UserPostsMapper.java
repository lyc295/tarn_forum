package com.tarn.tarn_forum.server_dbac.dao;

import com.tarn.tarn_forum.server_dbac.model.UserPosts;
import com.tarn.tarn_forum.server_dbac.model.UserPostsCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserPostsMapper {
    int countByExample(UserPostsCriteria example);

    int deleteByExample(UserPostsCriteria example);

    int deleteByPrimaryKey(Integer postId);

    int insert(UserPosts record);

    int insertSelective(UserPosts record);

    List<UserPosts> selectByExample(UserPostsCriteria example);

    UserPosts selectByPrimaryKey(Integer postId);

    int updateByExampleSelective(@Param("record") UserPosts record, @Param("example") UserPostsCriteria example);

    int updateByExample(@Param("record") UserPosts record, @Param("example") UserPostsCriteria example);

    int updateByPrimaryKeySelective(UserPosts record);

    int updateByPrimaryKey(UserPosts record);
}