package com.tarn.tarn_forum.server;

import com.tarn.tarn_forum.server_dbac.model.PostsComment;
import com.tarn.tarn_forum.server_dbml.model.PostsCommentExt;
import com.tarn.tarn_forum.utils.ResponseData.ResponseData;

public interface CommentService {

    ResponseData addUserComment(String methodDesc, PostsComment postsComment);

    ResponseData getUserComment(String methodDesc, PostsComment postsComment);

    ResponseData getCommentNumber(String methodDesc, PostsComment postsComment);

    ResponseData deleteComment(String methodDesc, PostsComment postsComment);

}
