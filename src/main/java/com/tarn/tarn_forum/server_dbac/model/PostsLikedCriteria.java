package com.tarn.tarn_forum.server_dbac.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostsLikedCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PostsLikedCriteria() {
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

        public Criteria andLikedIdIsNull() {
            addCriterion("LIKED_ID is null");
            return (Criteria) this;
        }

        public Criteria andLikedIdIsNotNull() {
            addCriterion("LIKED_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLikedIdEqualTo(Integer value) {
            addCriterion("LIKED_ID =", value, "likedId");
            return (Criteria) this;
        }

        public Criteria andLikedIdNotEqualTo(Integer value) {
            addCriterion("LIKED_ID <>", value, "likedId");
            return (Criteria) this;
        }

        public Criteria andLikedIdGreaterThan(Integer value) {
            addCriterion("LIKED_ID >", value, "likedId");
            return (Criteria) this;
        }

        public Criteria andLikedIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("LIKED_ID >=", value, "likedId");
            return (Criteria) this;
        }

        public Criteria andLikedIdLessThan(Integer value) {
            addCriterion("LIKED_ID <", value, "likedId");
            return (Criteria) this;
        }

        public Criteria andLikedIdLessThanOrEqualTo(Integer value) {
            addCriterion("LIKED_ID <=", value, "likedId");
            return (Criteria) this;
        }

        public Criteria andLikedIdIn(List<Integer> values) {
            addCriterion("LIKED_ID in", values, "likedId");
            return (Criteria) this;
        }

        public Criteria andLikedIdNotIn(List<Integer> values) {
            addCriterion("LIKED_ID not in", values, "likedId");
            return (Criteria) this;
        }

        public Criteria andLikedIdBetween(Integer value1, Integer value2) {
            addCriterion("LIKED_ID between", value1, value2, "likedId");
            return (Criteria) this;
        }

        public Criteria andLikedIdNotBetween(Integer value1, Integer value2) {
            addCriterion("LIKED_ID not between", value1, value2, "likedId");
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

        public Criteria andLikedTimeIsNull() {
            addCriterion("LIKED_TIME is null");
            return (Criteria) this;
        }

        public Criteria andLikedTimeIsNotNull() {
            addCriterion("LIKED_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andLikedTimeEqualTo(Date value) {
            addCriterion("LIKED_TIME =", value, "likedTime");
            return (Criteria) this;
        }

        public Criteria andLikedTimeNotEqualTo(Date value) {
            addCriterion("LIKED_TIME <>", value, "likedTime");
            return (Criteria) this;
        }

        public Criteria andLikedTimeGreaterThan(Date value) {
            addCriterion("LIKED_TIME >", value, "likedTime");
            return (Criteria) this;
        }

        public Criteria andLikedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LIKED_TIME >=", value, "likedTime");
            return (Criteria) this;
        }

        public Criteria andLikedTimeLessThan(Date value) {
            addCriterion("LIKED_TIME <", value, "likedTime");
            return (Criteria) this;
        }

        public Criteria andLikedTimeLessThanOrEqualTo(Date value) {
            addCriterion("LIKED_TIME <=", value, "likedTime");
            return (Criteria) this;
        }

        public Criteria andLikedTimeIn(List<Date> values) {
            addCriterion("LIKED_TIME in", values, "likedTime");
            return (Criteria) this;
        }

        public Criteria andLikedTimeNotIn(List<Date> values) {
            addCriterion("LIKED_TIME not in", values, "likedTime");
            return (Criteria) this;
        }

        public Criteria andLikedTimeBetween(Date value1, Date value2) {
            addCriterion("LIKED_TIME between", value1, value2, "likedTime");
            return (Criteria) this;
        }

        public Criteria andLikedTimeNotBetween(Date value1, Date value2) {
            addCriterion("LIKED_TIME not between", value1, value2, "likedTime");
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

        public Criteria andLikedStatusIsNull() {
            addCriterion("LIKED_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andLikedStatusIsNotNull() {
            addCriterion("LIKED_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andLikedStatusEqualTo(Byte value) {
            addCriterion("LIKED_STATUS =", value, "likedStatus");
            return (Criteria) this;
        }

        public Criteria andLikedStatusNotEqualTo(Byte value) {
            addCriterion("LIKED_STATUS <>", value, "likedStatus");
            return (Criteria) this;
        }

        public Criteria andLikedStatusGreaterThan(Byte value) {
            addCriterion("LIKED_STATUS >", value, "likedStatus");
            return (Criteria) this;
        }

        public Criteria andLikedStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("LIKED_STATUS >=", value, "likedStatus");
            return (Criteria) this;
        }

        public Criteria andLikedStatusLessThan(Byte value) {
            addCriterion("LIKED_STATUS <", value, "likedStatus");
            return (Criteria) this;
        }

        public Criteria andLikedStatusLessThanOrEqualTo(Byte value) {
            addCriterion("LIKED_STATUS <=", value, "likedStatus");
            return (Criteria) this;
        }

        public Criteria andLikedStatusIn(List<Byte> values) {
            addCriterion("LIKED_STATUS in", values, "likedStatus");
            return (Criteria) this;
        }

        public Criteria andLikedStatusNotIn(List<Byte> values) {
            addCriterion("LIKED_STATUS not in", values, "likedStatus");
            return (Criteria) this;
        }

        public Criteria andLikedStatusBetween(Byte value1, Byte value2) {
            addCriterion("LIKED_STATUS between", value1, value2, "likedStatus");
            return (Criteria) this;
        }

        public Criteria andLikedStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("LIKED_STATUS not between", value1, value2, "likedStatus");
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