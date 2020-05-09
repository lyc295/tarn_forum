package com.tarn.tarn_forum.server_dbac.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserInfoCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserInfoCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("USER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("USER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("USER_NAME =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("USER_NAME <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("USER_NAME >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("USER_NAME >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("USER_NAME <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("USER_NAME <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("USER_NAME like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("USER_NAME not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("USER_NAME in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("USER_NAME not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("USER_NAME between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("USER_NAME not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserPwdIsNull() {
            addCriterion("USER_PWD is null");
            return (Criteria) this;
        }

        public Criteria andUserPwdIsNotNull() {
            addCriterion("USER_PWD is not null");
            return (Criteria) this;
        }

        public Criteria andUserPwdEqualTo(String value) {
            addCriterion("USER_PWD =", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdNotEqualTo(String value) {
            addCriterion("USER_PWD <>", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdGreaterThan(String value) {
            addCriterion("USER_PWD >", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdGreaterThanOrEqualTo(String value) {
            addCriterion("USER_PWD >=", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdLessThan(String value) {
            addCriterion("USER_PWD <", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdLessThanOrEqualTo(String value) {
            addCriterion("USER_PWD <=", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdLike(String value) {
            addCriterion("USER_PWD like", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdNotLike(String value) {
            addCriterion("USER_PWD not like", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdIn(List<String> values) {
            addCriterion("USER_PWD in", values, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdNotIn(List<String> values) {
            addCriterion("USER_PWD not in", values, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdBetween(String value1, String value2) {
            addCriterion("USER_PWD between", value1, value2, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdNotBetween(String value1, String value2) {
            addCriterion("USER_PWD not between", value1, value2, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserEmailIsNull() {
            addCriterion("USER_EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andUserEmailIsNotNull() {
            addCriterion("USER_EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andUserEmailEqualTo(String value) {
            addCriterion("USER_EMAIL =", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotEqualTo(String value) {
            addCriterion("USER_EMAIL <>", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailGreaterThan(String value) {
            addCriterion("USER_EMAIL >", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailGreaterThanOrEqualTo(String value) {
            addCriterion("USER_EMAIL >=", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLessThan(String value) {
            addCriterion("USER_EMAIL <", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLessThanOrEqualTo(String value) {
            addCriterion("USER_EMAIL <=", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLike(String value) {
            addCriterion("USER_EMAIL like", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotLike(String value) {
            addCriterion("USER_EMAIL not like", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailIn(List<String> values) {
            addCriterion("USER_EMAIL in", values, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotIn(List<String> values) {
            addCriterion("USER_EMAIL not in", values, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailBetween(String value1, String value2) {
            addCriterion("USER_EMAIL between", value1, value2, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotBetween(String value1, String value2) {
            addCriterion("USER_EMAIL not between", value1, value2, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserHeadpicurlIsNull() {
            addCriterion("USER_HEADPICURL is null");
            return (Criteria) this;
        }

        public Criteria andUserHeadpicurlIsNotNull() {
            addCriterion("USER_HEADPICURL is not null");
            return (Criteria) this;
        }

        public Criteria andUserHeadpicurlEqualTo(String value) {
            addCriterion("USER_HEADPICURL =", value, "userHeadpicurl");
            return (Criteria) this;
        }

        public Criteria andUserHeadpicurlNotEqualTo(String value) {
            addCriterion("USER_HEADPICURL <>", value, "userHeadpicurl");
            return (Criteria) this;
        }

        public Criteria andUserHeadpicurlGreaterThan(String value) {
            addCriterion("USER_HEADPICURL >", value, "userHeadpicurl");
            return (Criteria) this;
        }

        public Criteria andUserHeadpicurlGreaterThanOrEqualTo(String value) {
            addCriterion("USER_HEADPICURL >=", value, "userHeadpicurl");
            return (Criteria) this;
        }

        public Criteria andUserHeadpicurlLessThan(String value) {
            addCriterion("USER_HEADPICURL <", value, "userHeadpicurl");
            return (Criteria) this;
        }

        public Criteria andUserHeadpicurlLessThanOrEqualTo(String value) {
            addCriterion("USER_HEADPICURL <=", value, "userHeadpicurl");
            return (Criteria) this;
        }

        public Criteria andUserHeadpicurlLike(String value) {
            addCriterion("USER_HEADPICURL like", value, "userHeadpicurl");
            return (Criteria) this;
        }

        public Criteria andUserHeadpicurlNotLike(String value) {
            addCriterion("USER_HEADPICURL not like", value, "userHeadpicurl");
            return (Criteria) this;
        }

        public Criteria andUserHeadpicurlIn(List<String> values) {
            addCriterion("USER_HEADPICURL in", values, "userHeadpicurl");
            return (Criteria) this;
        }

        public Criteria andUserHeadpicurlNotIn(List<String> values) {
            addCriterion("USER_HEADPICURL not in", values, "userHeadpicurl");
            return (Criteria) this;
        }

        public Criteria andUserHeadpicurlBetween(String value1, String value2) {
            addCriterion("USER_HEADPICURL between", value1, value2, "userHeadpicurl");
            return (Criteria) this;
        }

        public Criteria andUserHeadpicurlNotBetween(String value1, String value2) {
            addCriterion("USER_HEADPICURL not between", value1, value2, "userHeadpicurl");
            return (Criteria) this;
        }

        public Criteria andUserAllmarksIsNull() {
            addCriterion("USER_ALLMARKS is null");
            return (Criteria) this;
        }

        public Criteria andUserAllmarksIsNotNull() {
            addCriterion("USER_ALLMARKS is not null");
            return (Criteria) this;
        }

        public Criteria andUserAllmarksEqualTo(Integer value) {
            addCriterion("USER_ALLMARKS =", value, "userAllmarks");
            return (Criteria) this;
        }

        public Criteria andUserAllmarksNotEqualTo(Integer value) {
            addCriterion("USER_ALLMARKS <>", value, "userAllmarks");
            return (Criteria) this;
        }

        public Criteria andUserAllmarksGreaterThan(Integer value) {
            addCriterion("USER_ALLMARKS >", value, "userAllmarks");
            return (Criteria) this;
        }

        public Criteria andUserAllmarksGreaterThanOrEqualTo(Integer value) {
            addCriterion("USER_ALLMARKS >=", value, "userAllmarks");
            return (Criteria) this;
        }

        public Criteria andUserAllmarksLessThan(Integer value) {
            addCriterion("USER_ALLMARKS <", value, "userAllmarks");
            return (Criteria) this;
        }

        public Criteria andUserAllmarksLessThanOrEqualTo(Integer value) {
            addCriterion("USER_ALLMARKS <=", value, "userAllmarks");
            return (Criteria) this;
        }

        public Criteria andUserAllmarksIn(List<Integer> values) {
            addCriterion("USER_ALLMARKS in", values, "userAllmarks");
            return (Criteria) this;
        }

        public Criteria andUserAllmarksNotIn(List<Integer> values) {
            addCriterion("USER_ALLMARKS not in", values, "userAllmarks");
            return (Criteria) this;
        }

        public Criteria andUserAllmarksBetween(Integer value1, Integer value2) {
            addCriterion("USER_ALLMARKS between", value1, value2, "userAllmarks");
            return (Criteria) this;
        }

        public Criteria andUserAllmarksNotBetween(Integer value1, Integer value2) {
            addCriterion("USER_ALLMARKS not between", value1, value2, "userAllmarks");
            return (Criteria) this;
        }

        public Criteria andUserFlagIsNull() {
            addCriterion("USER_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andUserFlagIsNotNull() {
            addCriterion("USER_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andUserFlagEqualTo(Byte value) {
            addCriterion("USER_FLAG =", value, "userFlag");
            return (Criteria) this;
        }

        public Criteria andUserFlagNotEqualTo(Byte value) {
            addCriterion("USER_FLAG <>", value, "userFlag");
            return (Criteria) this;
        }

        public Criteria andUserFlagGreaterThan(Byte value) {
            addCriterion("USER_FLAG >", value, "userFlag");
            return (Criteria) this;
        }

        public Criteria andUserFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("USER_FLAG >=", value, "userFlag");
            return (Criteria) this;
        }

        public Criteria andUserFlagLessThan(Byte value) {
            addCriterion("USER_FLAG <", value, "userFlag");
            return (Criteria) this;
        }

        public Criteria andUserFlagLessThanOrEqualTo(Byte value) {
            addCriterion("USER_FLAG <=", value, "userFlag");
            return (Criteria) this;
        }

        public Criteria andUserFlagIn(List<Byte> values) {
            addCriterion("USER_FLAG in", values, "userFlag");
            return (Criteria) this;
        }

        public Criteria andUserFlagNotIn(List<Byte> values) {
            addCriterion("USER_FLAG not in", values, "userFlag");
            return (Criteria) this;
        }

        public Criteria andUserFlagBetween(Byte value1, Byte value2) {
            addCriterion("USER_FLAG between", value1, value2, "userFlag");
            return (Criteria) this;
        }

        public Criteria andUserFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("USER_FLAG not between", value1, value2, "userFlag");
            return (Criteria) this;
        }

        public Criteria andUserCreatetimeIsNull() {
            addCriterion("USER_CREATETIME is null");
            return (Criteria) this;
        }

        public Criteria andUserCreatetimeIsNotNull() {
            addCriterion("USER_CREATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andUserCreatetimeEqualTo(Date value) {
            addCriterion("USER_CREATETIME =", value, "userCreatetime");
            return (Criteria) this;
        }

        public Criteria andUserCreatetimeNotEqualTo(Date value) {
            addCriterion("USER_CREATETIME <>", value, "userCreatetime");
            return (Criteria) this;
        }

        public Criteria andUserCreatetimeGreaterThan(Date value) {
            addCriterion("USER_CREATETIME >", value, "userCreatetime");
            return (Criteria) this;
        }

        public Criteria andUserCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("USER_CREATETIME >=", value, "userCreatetime");
            return (Criteria) this;
        }

        public Criteria andUserCreatetimeLessThan(Date value) {
            addCriterion("USER_CREATETIME <", value, "userCreatetime");
            return (Criteria) this;
        }

        public Criteria andUserCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("USER_CREATETIME <=", value, "userCreatetime");
            return (Criteria) this;
        }

        public Criteria andUserCreatetimeIn(List<Date> values) {
            addCriterion("USER_CREATETIME in", values, "userCreatetime");
            return (Criteria) this;
        }

        public Criteria andUserCreatetimeNotIn(List<Date> values) {
            addCriterion("USER_CREATETIME not in", values, "userCreatetime");
            return (Criteria) this;
        }

        public Criteria andUserCreatetimeBetween(Date value1, Date value2) {
            addCriterion("USER_CREATETIME between", value1, value2, "userCreatetime");
            return (Criteria) this;
        }

        public Criteria andUserCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("USER_CREATETIME not between", value1, value2, "userCreatetime");
            return (Criteria) this;
        }

        public Criteria andUserModifytimeIsNull() {
            addCriterion("USER_MODIFYTIME is null");
            return (Criteria) this;
        }

        public Criteria andUserModifytimeIsNotNull() {
            addCriterion("USER_MODIFYTIME is not null");
            return (Criteria) this;
        }

        public Criteria andUserModifytimeEqualTo(Date value) {
            addCriterion("USER_MODIFYTIME =", value, "userModifytime");
            return (Criteria) this;
        }

        public Criteria andUserModifytimeNotEqualTo(Date value) {
            addCriterion("USER_MODIFYTIME <>", value, "userModifytime");
            return (Criteria) this;
        }

        public Criteria andUserModifytimeGreaterThan(Date value) {
            addCriterion("USER_MODIFYTIME >", value, "userModifytime");
            return (Criteria) this;
        }

        public Criteria andUserModifytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("USER_MODIFYTIME >=", value, "userModifytime");
            return (Criteria) this;
        }

        public Criteria andUserModifytimeLessThan(Date value) {
            addCriterion("USER_MODIFYTIME <", value, "userModifytime");
            return (Criteria) this;
        }

        public Criteria andUserModifytimeLessThanOrEqualTo(Date value) {
            addCriterion("USER_MODIFYTIME <=", value, "userModifytime");
            return (Criteria) this;
        }

        public Criteria andUserModifytimeIn(List<Date> values) {
            addCriterion("USER_MODIFYTIME in", values, "userModifytime");
            return (Criteria) this;
        }

        public Criteria andUserModifytimeNotIn(List<Date> values) {
            addCriterion("USER_MODIFYTIME not in", values, "userModifytime");
            return (Criteria) this;
        }

        public Criteria andUserModifytimeBetween(Date value1, Date value2) {
            addCriterion("USER_MODIFYTIME between", value1, value2, "userModifytime");
            return (Criteria) this;
        }

        public Criteria andUserModifytimeNotBetween(Date value1, Date value2) {
            addCriterion("USER_MODIFYTIME not between", value1, value2, "userModifytime");
            return (Criteria) this;
        }

        public Criteria andUserAutographIsNull() {
            addCriterion("USER_AUTOGRAPH is null");
            return (Criteria) this;
        }

        public Criteria andUserAutographIsNotNull() {
            addCriterion("USER_AUTOGRAPH is not null");
            return (Criteria) this;
        }

        public Criteria andUserAutographEqualTo(String value) {
            addCriterion("USER_AUTOGRAPH =", value, "userAutograph");
            return (Criteria) this;
        }

        public Criteria andUserAutographNotEqualTo(String value) {
            addCriterion("USER_AUTOGRAPH <>", value, "userAutograph");
            return (Criteria) this;
        }

        public Criteria andUserAutographGreaterThan(String value) {
            addCriterion("USER_AUTOGRAPH >", value, "userAutograph");
            return (Criteria) this;
        }

        public Criteria andUserAutographGreaterThanOrEqualTo(String value) {
            addCriterion("USER_AUTOGRAPH >=", value, "userAutograph");
            return (Criteria) this;
        }

        public Criteria andUserAutographLessThan(String value) {
            addCriterion("USER_AUTOGRAPH <", value, "userAutograph");
            return (Criteria) this;
        }

        public Criteria andUserAutographLessThanOrEqualTo(String value) {
            addCriterion("USER_AUTOGRAPH <=", value, "userAutograph");
            return (Criteria) this;
        }

        public Criteria andUserAutographLike(String value) {
            addCriterion("USER_AUTOGRAPH like", value, "userAutograph");
            return (Criteria) this;
        }

        public Criteria andUserAutographNotLike(String value) {
            addCriterion("USER_AUTOGRAPH not like", value, "userAutograph");
            return (Criteria) this;
        }

        public Criteria andUserAutographIn(List<String> values) {
            addCriterion("USER_AUTOGRAPH in", values, "userAutograph");
            return (Criteria) this;
        }

        public Criteria andUserAutographNotIn(List<String> values) {
            addCriterion("USER_AUTOGRAPH not in", values, "userAutograph");
            return (Criteria) this;
        }

        public Criteria andUserAutographBetween(String value1, String value2) {
            addCriterion("USER_AUTOGRAPH between", value1, value2, "userAutograph");
            return (Criteria) this;
        }

        public Criteria andUserAutographNotBetween(String value1, String value2) {
            addCriterion("USER_AUTOGRAPH not between", value1, value2, "userAutograph");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}