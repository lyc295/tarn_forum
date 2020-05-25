package com.tarn.tarn_forum.server_dbac.model;

import java.io.Serializable;
import java.util.Date;

public class PostsComment implements Serializable {
    private Integer commentId;

    private Integer userId;

    private Integer postId;

    private String collectContent;

    private Date collectTime;

    private Integer commentFatherId;

    private Byte collectFlag;

    private Integer replyUserId;

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
        PostsComment other = (PostsComment) that;
        return (this.getCommentId() == null ? other.getCommentId() == null : this.getCommentId().equals(other.getCommentId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getPostId() == null ? other.getPostId() == null : this.getPostId().equals(other.getPostId()))
            && (this.getCollectContent() == null ? other.getCollectContent() == null : this.getCollectContent().equals(other.getCollectContent()))
            && (this.getCollectTime() == null ? other.getCollectTime() == null : this.getCollectTime().equals(other.getCollectTime()))
            && (this.getCommentFatherId() == null ? other.getCommentFatherId() == null : this.getCommentFatherId().equals(other.getCommentFatherId()))
            && (this.getCollectFlag() == null ? other.getCollectFlag() == null : this.getCollectFlag().equals(other.getCollectFlag()))
            && (this.getReplyUserId() == null ? other.getReplyUserId() == null : this.getReplyUserId().equals(other.getReplyUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCommentId() == null) ? 0 : getCommentId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getPostId() == null) ? 0 : getPostId().hashCode());
        result = prime * result + ((getCollectContent() == null) ? 0 : getCollectContent().hashCode());
        result = prime * result + ((getCollectTime() == null) ? 0 : getCollectTime().hashCode());
        result = prime * result + ((getCommentFatherId() == null) ? 0 : getCommentFatherId().hashCode());
        result = prime * result + ((getCollectFlag() == null) ? 0 : getCollectFlag().hashCode());
        result = prime * result + ((getReplyUserId() == null) ? 0 : getReplyUserId().hashCode());
        return result;
    }
}