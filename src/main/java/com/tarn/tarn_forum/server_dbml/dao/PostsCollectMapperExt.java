package com.tarn.tarn_forum.server_dbml.dao;

import com.tarn.tarn_forum.server_dbac.model.PostsCollect;
import com.tarn.tarn_forum.server_dbml.model.UserInfoExt;

import java.util.List;

public interface PostsCollectMapperExt {

    int removeCollect(PostsCollect postsCollect);

    List<UserInfoExt> getUserPosts(Integer userId);

    List<UserInfoExt> getUserReleasePosts(Integer userId);

}
