package com.tarn.tarn_forum.server_dbac.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostsCommentCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PostsCommentCriteria() {
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

        public Criteria andCommentIdIsNull() {
            addCriterion("COMMENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andCommentIdIsNotNull() {
            addCriterion("COMMENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCommentIdEqualTo(Integer value) {
            addCriterion("COMMENT_ID =", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotEqualTo(Integer value) {
            addCriterion("COMMENT_ID <>", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThan(Integer value) {
            addCriterion("COMMENT_ID >", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("COMMENT_ID >=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThan(Integer value) {
            addCriterion("COMMENT_ID <", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThanOrEqualTo(Integer value) {
            addCriterion("COMMENT_ID <=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdIn(List<Integer> values) {
            addCriterion("COMMENT_ID in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotIn(List<Integer> values) {
            addCriterion("COMMENT_ID not in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdBetween(Integer value1, Integer value2) {
            addCriterion("COMMENT_ID between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("COMMENT_ID not between", value1, value2, "commentId");
            return (Criteria) this;
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

        public Criteria andPostIdIsNull() {
            addCriterion("POST_ID is null");
            return (Criteria) this;
        }

        public Criteria andPostIdIsNotNull() {
            addCriterion("POST_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPostIdEqualTo(Integer value) {
            addCriterion("POST_ID =", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdNotEqualTo(Integer value) {
            addCriterion("POST_ID <>", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdGreaterThan(Integer value) {
            addCriterion("POST_ID >", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("POST_ID >=", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdLessThan(Integer value) {
            addCriterion("POST_ID <", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdLessThanOrEqualTo(Integer value) {
            addCriterion("POST_ID <=", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdIn(List<Integer> values) {
            addCriterion("POST_ID in", values, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdNotIn(List<Integer> values) {
            addCriterion("POST_ID not in", values, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdBetween(Integer value1, Integer value2) {
            addCriterion("POST_ID between", value1, value2, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdNotBetween(Integer value1, Integer value2) {
            addCriterion("POST_ID not between", value1, value2, "postId");
            return (Criteria) this;
        }

        public Criteria andCollectContentIsNull() {
            addCriterion("COLLECT_CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andCollectContentIsNotNull() {
            addCriterion("COLLECT_CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andCollectContentEqualTo(String value) {
            addCriterion("COLLECT_CONTENT =", value, "collectContent");
            return (Criteria) this;
        }

        public Criteria andCollectContentNotEqualTo(String value) {
            addCriterion("COLLECT_CONTENT <>", value, "collectContent");
            return (Criteria) this;
        }

        public Criteria andCollectContentGreaterThan(String value) {
            addCriterion("COLLECT_CONTENT >", value, "collectContent");
            return (Criteria) this;
        }

        public Criteria andCollectContentGreaterThanOrEqualTo(String value) {
            addCriterion("COLLECT_CONTENT >=", value, "collectContent");
            return (Criteria) this;
        }

        public Criteria andCollectContentLessThan(String value) {
            addCriterion("COLLECT_CONTENT <", value, "collectContent");
            return (Criteria) this;
        }

        public Criteria andCollectContentLessThanOrEqualTo(String value) {
            addCriterion("COLLECT_CONTENT <=", value, "collectContent");
            return (Criteria) this;
        }

        public Criteria andCollectContentLike(String value) {
            addCriterion("COLLECT_CONTENT like", value, "collectContent");
            return (Criteria) this;
        }

        public Criteria andCollectContentNotLike(String value) {
            addCriterion("COLLECT_CONTENT not like", value, "collectContent");
            return (Criteria) this;
        }

        public Criteria andCollectContentIn(List<String> values) {
            addCriterion("COLLECT_CONTENT in", values, "collectContent");
            return (Criteria) this;
        }

        public Criteria andCollectContentNotIn(List<String> values) {
            addCriterion("COLLECT_CONTENT not in", values, "collectContent");
            return (Criteria) this;
        }

        public Criteria andCollectContentBetween(String value1, String value2) {
            addCriterion("COLLECT_CONTENT between", value1, value2, "collectContent");
            return (Criteria) this;
        }

        public Criteria andCollectContentNotBetween(String value1, String value2) {
            addCriterion("COLLECT_CONTENT not between", value1, value2, "collectContent");
            return (Criteria) this;
        }

        public Criteria andCollectTimeIsNull() {
            addCriterion("COLLECT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCollectTimeIsNotNull() {
            addCriterion("COLLECT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCollectTimeEqualTo(Date value) {
            addCriterion("COLLECT_TIME =", value, "collectTime");
            return (Criteria) this;
        }

        public Criteria andCollectTimeNotEqualTo(Date value) {
            addCriterion("COLLECT_TIME <>", value, "collectTime");
            return (Criteria) this;
        }

        public Criteria andCollectTimeGreaterThan(Date value) {
            addCriterion("COLLECT_TIME >", value, "collectTime");
            return (Criteria) this;
        }

        public Criteria andCollectTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("COLLECT_TIME >=", value, "collectTime");
            return (Criteria) this;
        }

        public Criteria andCollectTimeLessThan(Date value) {
            addCriterion("COLLECT_TIME <", value, "collectTime");
            return (Criteria) this;
        }

        public Criteria andCollectTimeLessThanOrEqualTo(Date value) {
            addCriterion("COLLECT_TIME <=", value, "collectTime");
            return (Criteria) this;
        }

        public Criteria andCollectTimeIn(List<Date> values) {
            addCriterion("COLLECT_TIME in", values, "collectTime");
            return (Criteria) this;
        }

        public Criteria andCollectTimeNotIn(List<Date> values) {
            addCriterion("COLLECT_TIME not in", values, "collectTime");
            return (Criteria) this;
        }

        public Criteria andCollectTimeBetween(Date value1, Date value2) {
            addCriterion("COLLECT_TIME between", value1, value2, "collectTime");
            return (Criteria) this;
        }

        public Criteria andCollectTimeNotBetween(Date value1, Date value2) {
            addCriterion("COLLECT_TIME not between", value1, value2, "collectTime");
            return (Criteria) this;
        }

        public Criteria andCommentFatherIdIsNull() {
            addCriterion("COMMENT_FATHER_ID is null");
            return (Criteria) this;
        }

        public Criteria andCommentFatherIdIsNotNull() {
            addCriterion("COMMENT_FATHER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCommentFatherIdEqualTo(Integer value) {
            addCriterion("COMMENT_FATHER_ID =", value, "commentFatherId");
            return (Criteria) this;
        }

        public Criteria andCommentFatherIdNotEqualTo(Integer value) {
            addCriterion("COMMENT_FATHER_ID <>", value, "commentFatherId");
            return (Criteria) this;
        }

        public Criteria andCommentFatherIdGreaterThan(Integer value) {
            addCriterion("COMMENT_FATHER_ID >", value, "commentFatherId");
            return (Criteria) this;
        }

        public Criteria andCommentFatherIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("COMMENT_FATHER_ID >=", value, "commentFatherId");
            return (Criteria) this;
        }

        public Criteria andCommentFatherIdLessThan(Integer value) {
            addCriterion("COMMENT_FATHER_ID <", value, "commentFatherId");
            return (Criteria) this;
        }

        public Criteria andCommentFatherIdLessThanOrEqualTo(Integer value) {
            addCriterion("COMMENT_FATHER_ID <=", value, "commentFatherId");
            return (Criteria) this;
        }

        public Criteria andCommentFatherIdIn(List<Integer> values) {
            addCriterion("COMMENT_FATHER_ID in", values, "commentFatherId");
            return (Criteria) this;
        }

        public Criteria andCommentFatherIdNotIn(List<Integer> values) {
            addCriterion("COMMENT_FATHER_ID not in", values, "commentFatherId");
            return (Criteria) this;
        }

        public Criteria andCommentFatherIdBetween(Integer value1, Integer value2) {
            addCriterion("COMMENT_FATHER_ID between", value1, value2, "commentFatherId");
            return (Criteria) this;
        }

        public Criteria andCommentFatherIdNotBetween(Integer value1, Integer value2) {
            addCriterion("COMMENT_FATHER_ID not between", value1, value2, "commentFatherId");
            return (Criteria) this;
        }

        public Criteria andCollectFlagIsNull() {
            addCriterion("COLLECT_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andCollectFlagIsNotNull() {
            addCriterion("COLLECT_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andCollectFlagEqualTo(Byte value) {
            addCriterion("COLLECT_FLAG =", value, "collectFlag");
            return (Criteria) this;
        }

        public Criteria andCollectFlagNotEqualTo(Byte value) {
            addCriterion("COLLECT_FLAG <>", value, "collectFlag");
            return (Criteria) this;
        }

        public Criteria andCollectFlagGreaterThan(Byte value) {
            addCriterion("COLLECT_FLAG >", value, "collectFlag");
            return (Criteria) this;
        }

        public Criteria andCollectFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("COLLECT_FLAG >=", value, "collectFlag");
            return (Criteria) this;
        }

        public Criteria andCollectFlagLessThan(Byte value) {
            addCriterion("COLLECT_FLAG <", value, "collectFlag");
            return (Criteria) this;
        }

        public Criteria andCollectFlagLessThanOrEqualTo(Byte value) {
            addCriterion("COLLECT_FLAG <=", value, "collectFlag");
            return (Criteria) this;
        }

        public Criteria andCollectFlagIn(List<Byte> values) {
            addCriterion("COLLECT_FLAG in", values, "collectFlag");
            return (Criteria) this;
        }

        public Criteria andCollectFlagNotIn(List<Byte> values) {
            addCriterion("COLLECT_FLAG not in", values, "collectFlag");
            return (Criteria) this;
        }

        public Criteria andCollectFlagBetween(Byte value1, Byte value2) {
            addCriterion("COLLECT_FLAG between", value1, value2, "collectFlag");
            return (Criteria) this;
        }

        public Criteria andCollectFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("COLLECT_FLAG not between", value1, value2, "collectFlag");
            return (Criteria) this;
        }

        public Criteria andReplyUserIdIsNull() {
            addCriterion("REPLY_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andReplyUserIdIsNotNull() {
            addCriterion("REPLY_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andReplyUserIdEqualTo(Integer value) {
            addCriterion("REPLY_USER_ID =", value, "replyUserId");
            return (Criteria) this;
        }

        public Criteria andReplyUserIdNotEqualTo(Integer value) {
            addCriterion("REPLY_USER_ID <>", value, "replyUserId");
            return (Criteria) this;
        }

        public Criteria andReplyUserIdGreaterThan(Integer value) {
            addCriterion("REPLY_USER_ID >", value, "replyUserId");
            return (Criteria) this;
        }

        public Criteria andReplyUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("REPLY_USER_ID >=", value, "replyUserId");
            return (Criteria) this;
        }

        public Criteria andReplyUserIdLessThan(Integer value) {
            addCriterion("REPLY_USER_ID <", value, "replyUserId");
            return (Criteria) this;
        }

        public Criteria andReplyUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("REPLY_USER_ID <=", value, "replyUserId");
            return (Criteria) this;
        }

        public Criteria andReplyUserIdIn(List<Integer> values) {
            addCriterion("REPLY_USER_ID in", values, "replyUserId");
            return (Criteria) this;
        }

        public Criteria andReplyUserIdNotIn(List<Integer> values) {
            addCriterion("REPLY_USER_ID not in", values, "replyUserId");
            return (Criteria) this;
        }

        public Criteria andReplyUserIdBetween(Integer value1, Integer value2) {
            addCriterion("REPLY_USER_ID between", value1, value2, "replyUserId");
            return (Criteria) this;
        }

        public Criteria andReplyUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("REPLY_USER_ID not between", value1, value2, "replyUserId");
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