package com.tarn.tarn_forum.server_dbac.model;

import java.io.Serializable;
import java.util.Date;

public class PostsLiked implements Serializable {
    private Integer likedId;

    private Integer userId;

    private Date likedTime;

    private Integer postId;

    private Byte likedStatus;

    private static final long serialVersionUID = 1L;

    public Integer getLikedId() {
        return likedId;
    }

    public void setLikedId(Integer likedId) {
        this.likedId = likedId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getLikedTime() {
        return likedTime;
    }

    public void setLikedTime(Date likedTime) {
        this.likedTime = likedTime;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Byte getLikedStatus() {
        return likedStatus;
    }

    public void setLikedStatus(Byte likedStatus) {
        this.likedStatus = likedStatus;
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
        PostsLiked other = (PostsLiked) that;
        return (this.getLikedId() == null ? other.getLikedId() == null : this.getLikedId().equals(other.getLikedId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getLikedTime() == null ? other.getLikedTime() == null : this.getLikedTime().equals(other.getLikedTime()))
            && (this.getPostId() == null ? other.getPostId() == null : this.getPostId().equals(other.getPostId()))
            && (this.getLikedStatus() == null ? other.getLikedStatus() == null : this.getLikedStatus().equals(other.getLikedStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLikedId() == null) ? 0 : getLikedId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getLikedTime() == null) ? 0 : getLikedTime().hashCode());
        result = prime * result + ((getPostId() == null) ? 0 : getPostId().hashCode());
        result = prime * result + ((getLikedStatus() == null) ? 0 : getLikedStatus().hashCode());
        return result;
    }
}