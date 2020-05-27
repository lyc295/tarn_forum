package com.tarn.tarn_forum.server_dbac.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserSigninCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserSigninCriteria() {
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

        public Criteria andSigninIdIsNull() {
            addCriterion("SIGNIN_ID is null");
            return (Criteria) this;
        }

        public Criteria andSigninIdIsNotNull() {
            addCriterion("SIGNIN_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSigninIdEqualTo(Integer value) {
            addCriterion("SIGNIN_ID =", value, "signinId");
            return (Criteria) this;
        }

        public Criteria andSigninIdNotEqualTo(Integer value) {
            addCriterion("SIGNIN_ID <>", value, "signinId");
            return (Criteria) this;
        }

        public Criteria andSigninIdGreaterThan(Integer value) {
            addCriterion("SIGNIN_ID >", value, "signinId");
            return (Criteria) this;
        }

        public Criteria andSigninIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("SIGNIN_ID >=", value, "signinId");
            return (Criteria) this;
        }

        public Criteria andSigninIdLessThan(Integer value) {
            addCriterion("SIGNIN_ID <", value, "signinId");
            return (Criteria) this;
        }

        public Criteria andSigninIdLessThanOrEqualTo(Integer value) {
            addCriterion("SIGNIN_ID <=", value, "signinId");
            return (Criteria) this;
        }

        public Criteria andSigninIdIn(List<Integer> values) {
            addCriterion("SIGNIN_ID in", values, "signinId");
            return (Criteria) this;
        }

        public Criteria andSigninIdNotIn(List<Integer> values) {
            addCriterion("SIGNIN_ID not in", values, "signinId");
            return (Criteria) this;
        }

        public Criteria andSigninIdBetween(Integer value1, Integer value2) {
            addCriterion("SIGNIN_ID between", value1, value2, "signinId");
            return (Criteria) this;
        }

        public Criteria andSigninIdNotBetween(Integer value1, Integer value2) {
            addCriterion("SIGNIN_ID not between", value1, value2, "signinId");
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

        public Criteria andSigninTimeIsNull() {
            addCriterion("SIGNIN_TIME is null");
            return (Criteria) this;
        }

        public Criteria andSigninTimeIsNotNull() {
            addCriterion("SIGNIN_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andSigninTimeEqualTo(Date value) {
            addCriterion("SIGNIN_TIME =", value, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninTimeNotEqualTo(Date value) {
            addCriterion("SIGNIN_TIME <>", value, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninTimeGreaterThan(Date value) {
            addCriterion("SIGNIN_TIME >", value, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("SIGNIN_TIME >=", value, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninTimeLessThan(Date value) {
            addCriterion("SIGNIN_TIME <", value, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninTimeLessThanOrEqualTo(Date value) {
            addCriterion("SIGNIN_TIME <=", value, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninTimeIn(List<Date> values) {
            addCriterion("SIGNIN_TIME in", values, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninTimeNotIn(List<Date> values) {
            addCriterion("SIGNIN_TIME not in", values, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninTimeBetween(Date value1, Date value2) {
            addCriterion("SIGNIN_TIME between", value1, value2, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninTimeNotBetween(Date value1, Date value2) {
            addCriterion("SIGNIN_TIME not between", value1, value2, "signinTime");
            return (Criteria) this;
        }

        public Criteria andContinuitySigninDayIsNull() {
            addCriterion("CONTINUITY_SIGNIN_DAY is null");
            return (Criteria) this;
        }

        public Criteria andContinuitySigninDayIsNotNull() {
            addCriterion("CONTINUITY_SIGNIN_DAY is not null");
            return (Criteria) this;
        }

        public Criteria andContinuitySigninDayEqualTo(Integer value) {
            addCriterion("CONTINUITY_SIGNIN_DAY =", value, "continuitySigninDay");
            return (Criteria) this;
        }

        public Criteria andContinuitySigninDayNotEqualTo(Integer value) {
            addCriterion("CONTINUITY_SIGNIN_DAY <>", value, "continuitySigninDay");
            return (Criteria) this;
        }

        public Criteria andContinuitySigninDayGreaterThan(Integer value) {
            addCriterion("CONTINUITY_SIGNIN_DAY >", value, "continuitySigninDay");
            return (Criteria) this;
        }

        public Criteria andContinuitySigninDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("CONTINUITY_SIGNIN_DAY >=", value, "continuitySigninDay");
            return (Criteria) this;
        }

        public Criteria andContinuitySigninDayLessThan(Integer value) {
            addCriterion("CONTINUITY_SIGNIN_DAY <", value, "continuitySigninDay");
            return (Criteria) this;
        }

        public Criteria andContinuitySigninDayLessThanOrEqualTo(Integer value) {
            addCriterion("CONTINUITY_SIGNIN_DAY <=", value, "continuitySigninDay");
            return (Criteria) this;
        }

        public Criteria andContinuitySigninDayIn(List<Integer> values) {
            addCriterion("CONTINUITY_SIGNIN_DAY in", values, "continuitySigninDay");
            return (Criteria) this;
        }

        public Criteria andContinuitySigninDayNotIn(List<Integer> values) {
            addCriterion("CONTINUITY_SIGNIN_DAY not in", values, "continuitySigninDay");
            return (Criteria) this;
        }

        public Criteria andContinuitySigninDayBetween(Integer value1, Integer value2) {
            addCriterion("CONTINUITY_SIGNIN_DAY between", value1, value2, "continuitySigninDay");
            return (Criteria) this;
        }

        public Criteria andContinuitySigninDayNotBetween(Integer value1, Integer value2) {
            addCriterion("CONTINUITY_SIGNIN_DAY not between", value1, value2, "continuitySigninDay");
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