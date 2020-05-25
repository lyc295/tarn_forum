package com.tarn.tarn_forum.server_dbac.dao;

import com.tarn.tarn_forum.server_dbac.model.PostsComment;
import com.tarn.tarn_forum.server_dbac.model.PostsCommentCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PostsCommentMapper {
    int countByExample(PostsCommentCriteria example);

    int deleteByExample(PostsCommentCriteria example);

    int deleteByPrimaryKey(Integer commentId);

    int insert(PostsComment record);

    int insertSelective(PostsComment record);

    List<PostsComment> selectByExample(PostsCommentCriteria example);

    PostsComment selectByPrimaryKey(Integer commentId);

    int updateByExampleSelective(@Param("record") PostsComment record, @Param("example") PostsCommentCriteria example);

    int updateByExample(@Param("record") PostsComment record, @Param("example") PostsCommentCriteria example);

    int updateByPrimaryKeySelective(PostsComment record);

    int updateByPrimaryKey(PostsComment record);
}