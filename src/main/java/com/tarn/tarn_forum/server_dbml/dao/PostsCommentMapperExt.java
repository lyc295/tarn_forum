package com.tarn.tarn_forum.server_dbml.dao;

import com.tarn.tarn_forum.server_dbac.model.PostsComment;
import com.tarn.tarn_forum.server_dbml.model.PostsCommentExt;

import java.util.List;

public interface PostsCommentMapperExt {

   List<PostsCommentExt> getUserComment (PostsComment postsComment);

   int getCommentNumber(PostsComment postsComment);
}
