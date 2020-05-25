package com.tarn.tarn_forum.controller;

import com.tarn.tarn_forum.server.PostsSevice;
import com.tarn.tarn_forum.server_dbac.model.PostsCollect;
import com.tarn.tarn_forum.server_dbac.model.PostsLiked;
import com.tarn.tarn_forum.server_dbac.model.UserPosts;
import com.tarn.tarn_forum.server_dbml.model.UserPostsExt;
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
@RequestMapping("/Posts")
@Api(tags = "帖子基本操作", value = "基础类")
public class PostsController {

    @Resource(name = "postsServiceImpl")
    private PostsSevice postsServiceImpl;

    private static Logger logger = LoggerFactory.getLogger(PostsController.class);

    @ApiOperation(value = "获取模块接口", notes = "获取模块测试")
    @RequestMapping(value = "/getPostsEnum.do", method = RequestMethod.GET)
    @ResponseBody
    @PassToken
    public ResponseData getPostsEnum() {
        String methodDesc = "获取博客基础模块";
        return postsServiceImpl.getPostsEnum(methodDesc);
    }


    @ApiOperation(value = "获取所有帖子接口", notes = "获取所有帖子测试")
    @RequestMapping(value = "/queryAllPosts.do", method = RequestMethod.GET)
    @ResponseBody
    @PassToken
    public ResponseData queryAllPosts(UserPostsExt userPostsExt) {
        String methodDesc = "获取所有帖子";
        return postsServiceImpl.queryAllPosts(methodDesc, userPostsExt);
    }


    @ApiOperation(value = "获取帖子条数", notes = "获取帖子条数测试")
    @RequestMapping(value = "/queryAllPostsTotal.do", method = RequestMethod.GET)
    @ResponseBody
    @PassToken
    public ResponseData queryAllPostsTotal(UserPostsExt userPostsExt) {
        String methodDesc = "获取帖子条数";
        return postsServiceImpl.queryAllPostsTotal(methodDesc, userPostsExt);
    }

    @ApiOperation(value = "首页获取帖子", notes = "首页获取帖子")
    @RequestMapping(value = "/queryPostsOrderBy.do", method = RequestMethod.GET)
    @ResponseBody
    @PassToken
    public ResponseData queryPostsOrderBy() {
        String methodDesc = "首页获取帖子";
        return postsServiceImpl.queryPostsOrderBy(methodDesc);
    }

    @ApiOperation(value = "查询帖子详情", notes = "查询帖子详情")
    @RequestMapping(value = "/queryPostsDetail.do", method = RequestMethod.GET)
    @ResponseBody
    @PassToken
    public ResponseData queryPostsDetail(String postId) {
        String methodDesc = "查询帖子详情";
        return postsServiceImpl.queryPostsDetail(methodDesc,postId);
    }

    @ApiOperation(value = "发布新帖", notes = "发布新帖")
    @RequestMapping(value = "/addPosts.do", method = RequestMethod.GET)
    @ResponseBody
    @PassToken
    public ResponseData addPosts(UserPosts userPosts) {
        String methodDesc = "发布新帖";
        return postsServiceImpl.addPosts(methodDesc,userPosts);
    }

    @ApiOperation(value = "删除帖子", notes = "删除帖子")
    @RequestMapping(value = "/deletePosts.do", method = RequestMethod.GET)
    @ResponseBody
    @PassToken
    public ResponseData deletePosts(UserPosts userPosts) {
        String methodDesc = "删除帖子";
        return postsServiceImpl.deletePosts(methodDesc,userPosts);
    }


    @ApiOperation(value = "重新编辑帖子", notes = "重新编辑帖子")
    @RequestMapping(value = "/editPosts.do", method = RequestMethod.GET)
    @ResponseBody
    @PassToken
    public ResponseData editPosts(UserPosts userPosts) {
        String methodDesc = "重新编辑帖子";
        return postsServiceImpl.editPosts(methodDesc,userPosts);
    }


    @ApiOperation(value = "收藏帖子", notes = "收藏帖子")
    @RequestMapping(value = "/collectPosts.do", method = RequestMethod.GET)
    @ResponseBody
    @PassToken
    public ResponseData collectPosts(PostsCollect postsCollect) {
        String methodDesc = "收藏帖子";
        return postsServiceImpl.collectPosts(methodDesc,postsCollect);
    }


    @ApiOperation(value = "取消收藏", notes = "取消收藏")
    @RequestMapping(value = "/removeCollect.do", method = RequestMethod.GET)
    @ResponseBody
    @PassToken
    public ResponseData removeCollect(PostsCollect postsCollect) {
        String methodDesc = "取消收藏";
        return postsServiceImpl.removeCollect(methodDesc,postsCollect);
    }

    @ApiOperation(value = "查询该用户收藏的帖子", notes = "查询该用户收藏的帖子")
    @RequestMapping(value = "/getUserPosts.do", method = RequestMethod.GET)
    @ResponseBody
    @PassToken
    public ResponseData getUserPosts(Integer userId) {
        String methodDesc = "查询收藏的帖子";
        return postsServiceImpl.getUserPosts(methodDesc,userId);
    }

    @ApiOperation(value = "查询该用户发布的帖子", notes = "查询该用户发布的帖子")
    @RequestMapping(value = "/getUserReleasePosts.do", method = RequestMethod.GET)
    @ResponseBody
    @PassToken
    public ResponseData getUserReleasePosts(Integer userId) {
        String methodDesc = "查询发布的帖子";
        return postsServiceImpl.getUserReleasePosts(methodDesc,userId);
    }

    @ApiOperation(value = "查询帖子是否被收藏", notes = "查询帖子是否被收藏")
    @RequestMapping(value = "/getUserCollectPosts.do", method = RequestMethod.GET)
    @ResponseBody
    @PassToken
    public ResponseData getUserCollectPosts(PostsCollect postsCollect) {
        String methodDesc = "查询收藏";
        return postsServiceImpl.getUserCollectPosts(methodDesc,postsCollect);
    }


    @ApiOperation(value = "查询帖子是否被点赞", notes = "查询帖子是否被点赞")
    @RequestMapping(value = "/getUserLikedPosts.do", method = RequestMethod.GET)
    @ResponseBody
    @PassToken
    public ResponseData getUserLikedPosts(PostsLiked postsLiked) {
        String methodDesc = "查询点赞";
        return postsServiceImpl.getUserLikedPosts(methodDesc,postsLiked);
    }


    @ApiOperation(value = "查询帖子点赞数", notes = "查询帖子点赞数")
    @RequestMapping(value = "/getPostsLikedNumber.do", method = RequestMethod.GET)
    @ResponseBody
    @PassToken
    public ResponseData getPostsLikedNumber(PostsLiked postsLiked) {
        String methodDesc = "查询帖子点赞数";
        return postsServiceImpl.getPostsLikedNumber(methodDesc,postsLiked);
    }


    @ApiOperation(value = "阅读帖子", notes = "阅读帖子")
    @RequestMapping(value = "/readPosts.do", method = RequestMethod.GET)
    @ResponseBody
    @PassToken
    public ResponseData readPosts(Integer postsId) {
        String methodDesc = "阅读帖子";
        return postsServiceImpl.readPosts(methodDesc,postsId);
    }
}
