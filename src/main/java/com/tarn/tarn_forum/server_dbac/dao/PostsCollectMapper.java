package com.tarn.tarn_forum.server_dbac.dao;

import com.tarn.tarn_forum.server_dbac.model.PostsCollect;
import com.tarn.tarn_forum.server_dbac.model.PostsCollectCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PostsCollectMapper {
    int countByExample(PostsCollectCriteria example);

    int deleteByExample(PostsCollectCriteria example);

    int deleteByPrimaryKey(Integer collectId);

    int insert(PostsCollect record);

    int insertSelective(PostsCollect record);

    List<PostsCollect> selectByExample(PostsCollectCriteria example);

    PostsCollect selectByPrimaryKey(Integer collectId);

    int updateByExampleSelective(@Param("record") PostsCollect record, @Param("example") PostsCollectCriteria example);

    int updateByExample(@Param("record") PostsCollect record, @Param("example") PostsCollectCriteria example);

    int updateByPrimaryKeySelective(PostsCollect record);

    int updateByPrimaryKey(PostsCollect record);
}