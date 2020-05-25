package com.tarn.tarn_forum.server_dbml.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class PostsCommentExt implements Serializable {
    private Integer commentId;

    private Integer userId;

    private Integer postId;

    private String collectContent;

    private Date collectTime;

    private Integer commentFatherId;

    private Byte collectFlag;

    private Integer replyUserId;

    private String userName;

    private String replyUserName;

    public String getReplyUserName() {
        return replyUserName;
    }

    public void setReplyUserName(String replyUserName) {
        this.replyUserName = replyUserName;
    }

    private String userHeadpicurl;

    public List<PostsCommentExt> getPostsCommentExtList() {
        return postsCommentExtList;
    }

    public void setPostsCommentExtList(List<PostsCommentExt> postsCommentExtList) {
        this.postsCommentExtList = postsCommentExtList;
    }

    private List<PostsCommentExt> postsCommentExtList;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserHeadpicurl() {
        return userHeadpicurl;
    }

    public void setUserHeadpicurl(String userHeadpicurl) {
        this.userHeadpicurl = userHeadpicurl;
    }

    private static final long serialVersionUID = 1L;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getCollectContent() {
        return collectContent;
    }

    public void setCollectContent(String collectContent) {
        this.collectContent = collectContent == null ? null : collectContent.trim();
    }

    public Date getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(Date collectTime) {
        this.collectTime = collectTime;
    }

    public Integer getCommentFatherId() {
        return commentFatherId;
    }

    public void setCommentFatherId(Integer commentFatherId) {
        this.commentFatherId = commentFatherId;
    }

    public Byte getCollectFlag() {
        return collectFlag;
    }

    public void setCollectFlag(Byte collectFlag) {
        this.collectFlag = collectFlag;
    }

    public Integer getReplyUserId() {
        return replyUserId;
    }

    public void setReplyUserId(Integer replyUserId) {
        this.replyUserId = replyUserId;
    }

}