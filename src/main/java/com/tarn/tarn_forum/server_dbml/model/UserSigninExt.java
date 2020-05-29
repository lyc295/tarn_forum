package com.tarn.tarn_forum.server_dbml.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class UserSigninExt implements Serializable {
    private Integer signinId;

    private Integer userId;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    private Date signinTime;

    private Integer continuitySigninDay;

    private boolean signInFlag;

    public boolean isSignInFlag() {
        return signInFlag;
    }

    public void setSignInFlag(boolean signInFlag) {
        this.signInFlag = signInFlag;
    }

    private static final long serialVersionUID = 1L;

    public Integer getSigninId() {
        return signinId;
    }

    public void setSigninId(Integer signinId) {
        this.signinId = signinId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getSigninTime() {
        return signinTime;
    }

    public void setSigninTime(Date signinTime) {
        this.signinTime = signinTime;
    }

    public Integer getContinuitySigninDay() {
        return continuitySigninDay;
    }

    public void setContinuitySigninDay(Integer continuitySigninDay) {
        this.continuitySigninDay = continuitySigninDay;
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
        UserSigninExt other = (UserSigninExt) that;
        return (this.getSigninId() == null ? other.getSigninId() == null : this.getSigninId().equals(other.getSigninId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getSigninTime() == null ? other.getSigninTime() == null : this.getSigninTime().equals(other.getSigninTime()))
            && (this.getContinuitySigninDay() == null ? other.getContinuitySigninDay() == null : this.getContinuitySigninDay().equals(other.getContinuitySigninDay()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSigninId() == null) ? 0 : getSigninId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getSigninTime() == null) ? 0 : getSigninTime().hashCode());
        result = prime * result + ((getContinuitySigninDay() == null) ? 0 : getContinuitySigninDay().hashCode());
        return result;
    }
}