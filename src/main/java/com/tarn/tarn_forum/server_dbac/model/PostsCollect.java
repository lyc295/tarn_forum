package com.tarn.tarn_forum.server_dbac.model;

import java.io.Serializable;
import java.util.Date;

public class PostsCollect implements Serializable {
    private Integer collectId;

    private Integer userId;

    private Integer postId;

    private Byte collectFlag;

    private Date collectTime;

    private static final long serialVersionUID = 1L;

    public Integer getCollectId() {
        return collectId;
    }

    public void setCollectId(Integer collectId) {
        this.collectId = collectId;
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

    public Byte getCollectFlag() {
        return collectFlag;
    }

    public void setCollectFlag(Byte collectFlag) {
        this.collectFlag = collectFlag;
    }

    public Date getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(Date collectTime) {
        this.collectTime = collectTime;
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
        PostsCollect other = (PostsCollect) that;
        return (this.getCollectId() == null ? other.getCollectId() == null : this.getCollectId().equals(other.getCollectId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getPostId() == null ? other.getPostId() == null : this.getPostId().equals(other.getPostId()))
            && (this.getCollectFlag() == null ? other.getCollectFlag() == null : this.getCollectFlag().equals(other.getCollectFlag()))
            && (this.getCollectTime() == null ? other.getCollectTime() == null : this.getCollectTime().equals(other.getCollectTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCollectId() == null) ? 0 : getCollectId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getPostId() == null) ? 0 : getPostId().hashCode());
        result = prime * result + ((getCollectFlag() == null) ? 0 : getCollectFlag().hashCode());
        result = prime * result + ((getCollectTime() == null) ? 0 : getCollectTime().hashCode());
        return result;
    }
}