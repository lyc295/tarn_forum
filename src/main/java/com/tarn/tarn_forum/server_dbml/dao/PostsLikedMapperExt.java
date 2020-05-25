package com.tarn.tarn_forum.server_dbml.dao;


import com.tarn.tarn_forum.server_dbac.model.PostsLiked;

import java.util.List;
import java.util.Map;

public interface PostsLikedMapperExt {

   List getLikesByRedis(PostsLiked postsLiked);

    List<Map<String,Object>> getPostsLikedNumber(PostsLiked postsLiked);

}