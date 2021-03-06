package com.tarn.tarn_forum.server;

import com.github.pagehelper.PageInfo;
import com.tarn.tarn_forum.server_dbac.model.PostsCollect;
import com.tarn.tarn_forum.server_dbac.model.PostsLiked;
import com.tarn.tarn_forum.server_dbac.model.UserPosts;
import com.tarn.tarn_forum.server_dbml.model.UserPostsExt;
import com.tarn.tarn_forum.utils.ResponseData.ResponseData;

public interface PostsSevice {
    ResponseData getPostsEnum(String methodDesc);

    ResponseData queryAllPosts(String methodDesc, UserPostsExt userPostsExt);

    ResponseData queryAllPostsTotal(String methodDesc, UserPostsExt userPostsExt);

    ResponseData queryPostsOrderBy(String methodDesc);

    ResponseData queryPostsDetail(String methodDesc,String postId);

    ResponseData addPosts(String methodDesc, UserPosts userPosts);

    ResponseData deletePosts(String methodDesc, UserPosts userPosts);

    ResponseData editPosts(String methodDesc, UserPosts userPosts);

    ResponseData collectPosts(String methodDesc,PostsCollect postsCollect);

    ResponseData removeCollect(String methodDesc,PostsCollect postsCollect);

    ResponseData getUserPosts(String methodDesc,Integer userId);

    ResponseData getUserReleasePosts(String methodDesc,Integer userId);

    ResponseData getUserCollectPosts(String methodDesc,PostsCollect postsCollect);

    ResponseData getUserLikedPosts(String methodDesc,PostsLiked postsLiked);

    ResponseData getPostsLikedNumber(String methodDesc,PostsLiked postsLiked);

    ResponseData readPosts(String methodDesc,Integer postsId);

    ResponseData queryHotDiscuss(String methodDesc);
}