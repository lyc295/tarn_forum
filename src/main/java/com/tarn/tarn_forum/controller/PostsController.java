package com.tarn.tarn_forum.controller;

import com.github.pagehelper.PageInfo;
import com.tarn.tarn_forum.server.PostsSevice;
import com.tarn.tarn_forum.server_dbml.model.UserPostsExt;
import com.tarn.tarn_forum.target.PassToken;
import com.tarn.tarn_forum.target.UserLoginToken;
import com.tarn.tarn_forum.utils.ResponseData.ResponseCode;
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
@RequestMapping("/Posts")
@Api(tags = "帖子基本操作", value = "基础类")
public class PostsController {

    @Resource(name = "postsSreviceImpl")
    private PostsSevice postsSreviceImpl;

    private static Logger logger = LoggerFactory.getLogger(PostsController.class);

    @ApiOperation(value = "获取模块接口", notes = "获取模块测试")
    @RequestMapping(value = "/getPostsEnum.do", method = RequestMethod.GET)
    @ResponseBody
    @PassToken
    public ResponseData getPostsEnum() {
        String methodDesc = "获取博客基础模块";
        return postsSreviceImpl.getPostsEnum(methodDesc);
    }


    @ApiOperation(value = "获取所有帖子接口", notes = "获取所有帖子测试")
    @RequestMapping(value = "/queryAllPosts.do", method = RequestMethod.GET)
    @ResponseBody
    @PassToken
    public ResponseData queryAllPosts(UserPostsExt userPostsExt) {
        String methodDesc = "获取所有帖子";
        return postsSreviceImpl.queryAllPosts(methodDesc, userPostsExt);
    }


    @ApiOperation(value = "获取帖子条数", notes = "获取帖子条数测试")
    @RequestMapping(value = "/queryAllPostsTotal.do", method = RequestMethod.GET)
    @ResponseBody
    @PassToken
    public ResponseData queryAllPostsTotal(UserPostsExt userPostsExt) {
        String methodDesc = "获取帖子条数";
        return postsSreviceImpl.queryAllPostsTotal(methodDesc, userPostsExt);
    }



}
