package com.tarn.tarn_forum.server_dbml.dao;

import com.tarn.tarn_forum.server_dbml.model.UserPostsExt;
import java.util.List;

public interface UserPostsMapperExt {

   List<UserPostsExt>  queryAllPosts(UserPostsExt userPostsExt);

   int  queryAllPostsTotal(UserPostsExt userPostsExt);

   List<UserPostsExt> queryAllOrderby();

   UserPostsExt queryPostsDetail(String postId);

   List<UserPostsExt> queryHotDiscuss();

}