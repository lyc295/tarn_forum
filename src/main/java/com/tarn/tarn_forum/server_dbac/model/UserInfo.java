package com.tarn.tarn_forum.server_dbac.model;

import java.io.Serializable;
import java.util.Date;

public class UserInfo implements Serializable {
    private Integer userId;

    private String userName;

    private String userPwd;

    private String userEmail;

    private String userHeadpicurl;

    private Integer userAllmarks;

    private Byte userFlag;

    private Date userCreatetime;

    private Date userModifytime;

    private String userAutograph;

    private static final long serialVersionUID = 1L;

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
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getUserHeadpicurl() {
        return userHeadpicurl;
    }

    public void setUserHeadpicurl(String userHeadpicurl) {
        this.userHeadpicurl = userHeadpicurl == null ? null : userHeadpicurl.trim();
    }

    public Integer getUserAllmarks() {
        return userAllmarks;
    }

    public void setUserAllmarks(Integer userAllmarks) {
        this.userAllmarks = userAllmarks;
    }

    public Byte getUserFlag() {
        return userFlag;
    }

    public void setUserFlag(Byte userFlag) {
        this.userFlag = userFlag;
    }

    public Date getUserCreatetime() {
        return userCreatetime;
    }

    public void setUserCreatetime(Date userCreatetime) {
        this.userCreatetime = userCreatetime;
    }

    public Date getUserModifytime() {
        return userModifytime;
    }

    public void setUserModifytime(Date userModifytime) {
        this.userModifytime = userModifytime;
    }

    public String getUserAutograph() {
        return userAutograph;
    }

    public void setUserAutograph(String userAutograph) {
        this.userAutograph = userAutograph == null ? null : userAutograph.trim();
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
        UserInfo other = (UserInfo) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getUserPwd() == null ? other.getUserPwd() == null : this.getUserPwd().equals(other.getUserPwd()))
            && (this.getUserEmail() == null ? other.getUserEmail() == null : this.getUserEmail().equals(other.getUserEmail()))
            && (this.getUserHeadpicurl() == null ? other.getUserHeadpicurl() == null : this.getUserHeadpicurl().equals(other.getUserHeadpicurl()))
            && (this.getUserAllmarks() == null ? other.getUserAllmarks() == null : this.getUserAllmarks().equals(other.getUserAllmarks()))
            && (this.getUserFlag() == null ? other.getUserFlag() == null : this.getUserFlag().equals(other.getUserFlag()))
            && (this.getUserCreatetime() == null ? other.getUserCreatetime() == null : this.getUserCreatetime().equals(other.getUserCreatetime()))
            && (this.getUserModifytime() == null ? other.getUserModifytime() == null : this.getUserModifytime().equals(other.getUserModifytime()))
            && (this.getUserAutograph() == null ? other.getUserAutograph() == null : this.getUserAutograph().equals(other.getUserAutograph()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getUserPwd() == null) ? 0 : getUserPwd().hashCode());
        result = prime * result + ((getUserEmail() == null) ? 0 : getUserEmail().hashCode());
        result = prime * result + ((getUserHeadpicurl() == null) ? 0 : getUserHeadpicurl().hashCode());
        result = prime * result + ((getUserAllmarks() == null) ? 0 : getUserAllmarks().hashCode());
        result = prime * result + ((getUserFlag() == null) ? 0 : getUserFlag().hashCode());
        result = prime * result + ((getUserCreatetime() == null) ? 0 : getUserCreatetime().hashCode());
        result = prime * result + ((getUserModifytime() == null) ? 0 : getUserModifytime().hashCode());
        result = prime * result + ((getUserAutograph() == null) ? 0 : getUserAutograph().hashCode());
        return result;
    }
}