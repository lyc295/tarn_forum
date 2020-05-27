package com.tarn.tarn_forum.server_dbml.model;

import java.util.Date;

public class UserInfoExt {

    private Integer userId;

    private String userName;

    private String userHeadpicurl;

    private Integer postId;

    private String postTitle;

    private Byte postType;

    private Date collectTime;

    private Integer continuitySigninDay;

    public Integer getContinuitySigninDay() {
        return continuitySigninDay;
    }

    public void setContinuitySigninDay(Integer continuitySigninDay) {
        this.continuitySigninDay = continuitySigninDay;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

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

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public Byte getPostType() {
        return postType;
    }

    public void setPostType(Byte postType) {
        this.postType = postType;
    }

    public Date getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(Date collectTime) {
        this.collectTime = collectTime;
    }


}
