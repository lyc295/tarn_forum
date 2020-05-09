package com.tarn.tarn_forum.server;

import com.github.pagehelper.PageInfo;
import com.tarn.tarn_forum.server_dbml.model.UserPostsExt;
import com.tarn.tarn_forum.utils.ResponseData.ResponseData;

public interface PostsSevice {
    ResponseData getPostsEnum(String methodDesc);

    ResponseData queryAllPosts(String methodDesc, UserPostsExt userPostsExt);

    ResponseData queryAllPostsTotal(String methodDesc, UserPostsExt userPostsExt);
}