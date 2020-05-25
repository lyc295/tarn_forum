package com.tarn.tarn_forum.server;


import com.tarn.tarn_forum.server_dbac.model.PostsLiked;
import com.tarn.tarn_forum.utils.ResponseData.ResponseData;

public interface PostsLikedService {


    ResponseData postsLikedServiceImpl(String methodDesc, PostsLiked postsLiked);


}
