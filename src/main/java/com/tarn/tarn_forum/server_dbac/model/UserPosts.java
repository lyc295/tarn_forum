package com.tarn.tarn_forum.server_dbac.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class UserPosts implements Serializable {
    private Integer postId;

    private String postTitle;

    private Integer postBiboid;

    private Integer postUserid;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    private Date postCreatetime;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    private Date postUpdatetime;

    private String postContent;

    private Integer postReward;

    private Integer postScore;

    private Byte postIspay;

    private Byte postType;

    private Byte postFlag;

    private Integer postRead;

    private static final long serialVersionUID = 1L;

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
        this.postTitle = postTitle == null ? null : postTitle.trim();
    }

    public Integer getPostBiboid() {
        return postBiboid;
    }

    public void setPostBiboid(Integer postBiboid) {
        this.postBiboid = postBiboid;
    }

    public Integer getPostUserid() {
        return postUserid;
    }

    public void setPostUserid(Integer postUserid) {
        this.postUserid = postUserid;
    }

    public Date getPostCreatetime() {
        return postCreatetime;
    }

    public void setPostCreatetime(Date postCreatetime) {
        this.postCreatetime = postCreatetime;
    }

    public Date getPostUpdatetime() {
        return postUpdatetime;
    }

    public void setPostUpdatetime(Date postUpdatetime) {
        this.postUpdatetime = postUpdatetime;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent == null ? null : postContent.trim();
    }

    public Integer getPostReward() {
        return postReward;
    }

    public void setPostReward(Integer postReward) {
        this.postReward = postReward;
    }

    public Integer getPostScore() {
        return postScore;
    }

    public void setPostScore(Integer postScore) {
        this.postScore = postScore;
    }

    public Byte getPostIspay() {
        return postIspay;
    }

    public void setPostIspay(Byte postIspay) {
        this.postIspay = postIspay;
    }

    public Byte getPostType() {
        return postType;
    }

    public void setPostType(Byte postType) {
        this.postType = postType;
    }

    public Byte getPostFlag() {
        return postFlag;
    }

    public void setPostFlag(Byte postFlag) {
        this.postFlag = postFlag;
    }

    public Integer getPostRead() {
        return postRead;
    }

    public void setPostRead(Integer postRead) {
        this.postRead = postRead;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        UserPosts other = (UserPosts) that;
        return (this.getPostId() == null ? other.getPostId() == null : this.getPostId().equals(other.getPostId()))
            && (this.getPostTitle() == null ? other.getPostTitle() == null : this.getPostTitle().equals(other.getPostTitle()))
            && (this.getPostBiboid() == null ? other.getPostBiboid() == null : this.getPostBiboid().equals(other.getPostBiboid()))
            && (this.getPostUserid() == null ? other.getPostUserid() == null : this.getPostUserid().equals(other.getPostUserid()))
            && (this.getPostCreatetime() == null ? other.getPostCreatetime() == null : this.getPostCreatetime().equals(other.getPostCreatetime()))
            && (this.getPostUpdatetime() == null ? other.getPostUpdatetime() == null : this.getPostUpdatetime().equals(other.getPostUpdatetime()))
            && (this.getPostContent() == null ? other.getPostContent() == null : this.getPostContent().equals(other.getPostContent()))
            && (this.getPostReward() == null ? other.getPostReward() == null : this.getPostReward().equals(other.getPostReward()))
            && (this.getPostScore() == null ? other.getPostScore() == null : this.getPostScore().equals(other.getPostScore()))
            && (this.getPostIspay() == null ? other.getPostIspay() == null : this.getPostIspay().equals(other.getPostIspay()))
            && (this.getPostType() == null ? other.getPostType() == null : this.getPostType().equals(other.getPostType()))
            && (this.getPostFlag() == null ? other.getPostFlag() == null : this.getPostFlag().equals(other.getPostFlag()))
            && (this.getPostRead() == null ? other.getPostRead() == null : this.getPostRead().equals(other.getPostRead()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPostId() == null) ? 0 : getPostId().hashCode());
        result = prime * result + ((getPostTitle() == null) ? 0 : getPostTitle().hashCode());
        result = prime * result + ((getPostBiboid() == null) ? 0 : getPostBiboid().hashCode());
        result = prime * result + ((getPostUserid() == null) ? 0 : getPostUserid().hashCode());
        result = prime * result + ((getPostCreatetime() == null) ? 0 : getPostCreatetime().hashCode());
        result = prime * result + ((getPostUpdatetime() == null) ? 0 : getPostUpdatetime().hashCode());
        result = prime * result + ((getPostContent() == null) ? 0 : getPostContent().hashCode());
        result = prime * result + ((getPostReward() == null) ? 0 : getPostReward().hashCode());
        result = prime * result + ((getPostScore() == null) ? 0 : getPostScore().hashCode());
        result = prime * result + ((getPostIspay() == null) ? 0 : getPostIspay().hashCode());
        result = prime * result + ((getPostType() == null) ? 0 : getPostType().hashCode());
        result = prime * result + ((getPostFlag() == null) ? 0 : getPostFlag().hashCode());
        result = prime * result + ((getPostRead() == null) ? 0 : getPostRead().hashCode());
        return result;
    }
}