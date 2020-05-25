package com.tarn.tarn_forum.server_dbac.dao;

import com.tarn.tarn_forum.server_dbac.model.PostsLiked;
import com.tarn.tarn_forum.server_dbac.model.PostsLikedCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PostsLikedMapper {
    int countByExample(PostsLikedCriteria example);

    int deleteByExample(PostsLikedCriteria example);

    int deleteByPrimaryKey(Integer likedId);

    int insert(PostsLiked record);

    int insertSelective(PostsLiked record);

    List<PostsLiked> selectByExample(PostsLikedCriteria example);

    PostsLiked selectByPrimaryKey(Integer likedId);

    int updateByExampleSelective(@Param("record") PostsLiked record, @Param("example") PostsLikedCriteria example);

    int updateByExample(@Param("record") PostsLiked record, @Param("example") PostsLikedCriteria example);

    int updateByPrimaryKeySelective(PostsLiked record);

    int updateByPrimaryKey(PostsLiked record);
}