package com.tarn.tarn_forum.controller;


import com.tarn.tarn_forum.server.CommentService;
import com.tarn.tarn_forum.server_dbac.model.PostsComment;
import com.tarn.tarn_forum.server_dbml.model.PostsCommentExt;
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
@RequestMapping("/comment")
@Api(tags = "帖子评论操作", value = "评论类")
public class CommentController {

    @Resource(name = "commentServicelmpl")
    private CommentService commentServicelmpl;

    private static Logger logger = LoggerFactory.getLogger(PostsController.class);


    @ApiOperation(value = "新增评论", notes = "新增评论")
    @RequestMapping(value = "/addUserComment.do", method = RequestMethod.GET)
    @ResponseBody
    @PassToken
    public ResponseData addUserComment(PostsComment postsComment) {
        String methodDesc = "新增评论";
        return commentServicelmpl.addUserComment(methodDesc,postsComment);
    }



    @ApiOperation(value = "查询评论详情", notes = "查询评论详情")
    @RequestMapping(value = "/getUserComment.do", method = RequestMethod.GET)
    @ResponseBody
    @PassToken
    public ResponseData getUserComment(PostsComment postsComment) {
        String methodDesc = "查询评论详情";
        return commentServicelmpl.getUserComment(methodDesc,postsComment);
    }


    @ApiOperation(value = "查询评论数量", notes = "查询评论数量")
    @RequestMapping(value = "/getCommentNumber.do", method = RequestMethod.GET)
    @ResponseBody
    @PassToken
    public ResponseData getCommentNumber(PostsComment postsComment) {
        String methodDesc = "查询评论数量";
        return commentServicelmpl.getCommentNumber(methodDesc,postsComment);
    }

    @ApiOperation(value = "删除评论", notes = "删除评论")
    @RequestMapping(value = "/deleteComment.do", method = RequestMethod.GET)
    @ResponseBody
    @PassToken
    public ResponseData deleteComment(PostsComment postsComment) {
        String methodDesc = "删除评论";
        return commentServicelmpl.deleteComment(methodDesc,postsComment);
    }
}
