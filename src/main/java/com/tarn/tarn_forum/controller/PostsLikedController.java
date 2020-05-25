package com.tarn.tarn_forum.controller;

import com.tarn.tarn_forum.server.PostsLikedService;
import com.tarn.tarn_forum.server_dbac.model.PostsLiked;
import com.tarn.tarn_forum.target.PassToken;
import com.tarn.tarn_forum.utils.ResponseData.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/liked")
@Api(tags = "帖子点赞操作", value = "点赞类")
public class PostsLikedController {

    @Resource(name = "postsLikedServiceImpl")
    private PostsLikedService postsLikedServiceImpl;

    private static Logger logger = LoggerFactory.getLogger(PostsLikedController.class);


    @ApiOperation(value = "点赞", notes = "点赞")
    @RequestMapping(value = "/postsLiked.do", method = RequestMethod.GET)
    @ResponseBody
    @PassToken
    public ResponseData postsLiked(PostsLiked postsLiked) {
        String methodDesc = "点赞";
        return postsLikedServiceImpl.postsLikedServiceImpl(methodDesc,postsLiked);
    }

}
