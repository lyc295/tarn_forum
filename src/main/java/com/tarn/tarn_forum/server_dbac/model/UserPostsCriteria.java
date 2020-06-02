package com.tarn.tarn_forum.server_dbac.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserPostsCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserPostsCriteria() {
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

        public Criteria andPostTitleIsNull() {
            addCriterion("POST_TITLE is null");
            return (Criteria) this;
        }

        public Criteria andPostTitleIsNotNull() {
            addCriterion("POST_TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andPostTitleEqualTo(String value) {
            addCriterion("POST_TITLE =", value, "postTitle");
            return (Criteria) this;
        }

        public Criteria andPostTitleNotEqualTo(String value) {
            addCriterion("POST_TITLE <>", value, "postTitle");
            return (Criteria) this;
        }

        public Criteria andPostTitleGreaterThan(String value) {
            addCriterion("POST_TITLE >", value, "postTitle");
            return (Criteria) this;
        }

        public Criteria andPostTitleGreaterThanOrEqualTo(String value) {
            addCriterion("POST_TITLE >=", value, "postTitle");
            return (Criteria) this;
        }

        public Criteria andPostTitleLessThan(String value) {
            addCriterion("POST_TITLE <", value, "postTitle");
            return (Criteria) this;
        }

        public Criteria andPostTitleLessThanOrEqualTo(String value) {
            addCriterion("POST_TITLE <=", value, "postTitle");
            return (Criteria) this;
        }

        public Criteria andPostTitleLike(String value) {
            addCriterion("POST_TITLE like", value, "postTitle");
            return (Criteria) this;
        }

        public Criteria andPostTitleNotLike(String value) {
            addCriterion("POST_TITLE not like", value, "postTitle");
            return (Criteria) this;
        }

        public Criteria andPostTitleIn(List<String> values) {
            addCriterion("POST_TITLE in", values, "postTitle");
            return (Criteria) this;
        }

        public Criteria andPostTitleNotIn(List<String> values) {
            addCriterion("POST_TITLE not in", values, "postTitle");
            return (Criteria) this;
        }

        public Criteria andPostTitleBetween(String value1, String value2) {
            addCriterion("POST_TITLE between", value1, value2, "postTitle");
            return (Criteria) this;
        }

        public Criteria andPostTitleNotBetween(String value1, String value2) {
            addCriterion("POST_TITLE not between", value1, value2, "postTitle");
            return (Criteria) this;
        }

        public Criteria andPostBiboidIsNull() {
            addCriterion("POST_BIBOID is null");
            return (Criteria) this;
        }

        public Criteria andPostBiboidIsNotNull() {
            addCriterion("POST_BIBOID is not null");
            return (Criteria) this;
        }

        public Criteria andPostBiboidEqualTo(Integer value) {
            addCriterion("POST_BIBOID =", value, "postBiboid");
            return (Criteria) this;
        }

        public Criteria andPostBiboidNotEqualTo(Integer value) {
            addCriterion("POST_BIBOID <>", value, "postBiboid");
            return (Criteria) this;
        }

        public Criteria andPostBiboidGreaterThan(Integer value) {
            addCriterion("POST_BIBOID >", value, "postBiboid");
            return (Criteria) this;
        }

        public Criteria andPostBiboidGreaterThanOrEqualTo(Integer value) {
            addCriterion("POST_BIBOID >=", value, "postBiboid");
            return (Criteria) this;
        }

        public Criteria andPostBiboidLessThan(Integer value) {
            addCriterion("POST_BIBOID <", value, "postBiboid");
            return (Criteria) this;
        }

        public Criteria andPostBiboidLessThanOrEqualTo(Integer value) {
            addCriterion("POST_BIBOID <=", value, "postBiboid");
            return (Criteria) this;
        }

        public Criteria andPostBiboidIn(List<Integer> values) {
            addCriterion("POST_BIBOID in", values, "postBiboid");
            return (Criteria) this;
        }

        public Criteria andPostBiboidNotIn(List<Integer> values) {
            addCriterion("POST_BIBOID not in", values, "postBiboid");
            return (Criteria) this;
        }

        public Criteria andPostBiboidBetween(Integer value1, Integer value2) {
            addCriterion("POST_BIBOID between", value1, value2, "postBiboid");
            return (Criteria) this;
        }

        public Criteria andPostBiboidNotBetween(Integer value1, Integer value2) {
            addCriterion("POST_BIBOID not between", value1, value2, "postBiboid");
            return (Criteria) this;
        }

        public Criteria andPostUseridIsNull() {
            addCriterion("POST_USERID is null");
            return (Criteria) this;
        }

        public Criteria andPostUseridIsNotNull() {
            addCriterion("POST_USERID is not null");
            return (Criteria) this;
        }

        public Criteria andPostUseridEqualTo(Integer value) {
            addCriterion("POST_USERID =", value, "postUserid");
            return (Criteria) this;
        }

        public Criteria andPostUseridNotEqualTo(Integer value) {
            addCriterion("POST_USERID <>", value, "postUserid");
            return (Criteria) this;
        }

        public Criteria andPostUseridGreaterThan(Integer value) {
            addCriterion("POST_USERID >", value, "postUserid");
            return (Criteria) this;
        }

        public Criteria andPostUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("POST_USERID >=", value, "postUserid");
            return (Criteria) this;
        }

        public Criteria andPostUseridLessThan(Integer value) {
            addCriterion("POST_USERID <", value, "postUserid");
            return (Criteria) this;
        }

        public Criteria andPostUseridLessThanOrEqualTo(Integer value) {
            addCriterion("POST_USERID <=", value, "postUserid");
            return (Criteria) this;
        }

        public Criteria andPostUseridIn(List<Integer> values) {
            addCriterion("POST_USERID in", values, "postUserid");
            return (Criteria) this;
        }

        public Criteria andPostUseridNotIn(List<Integer> values) {
            addCriterion("POST_USERID not in", values, "postUserid");
            return (Criteria) this;
        }

        public Criteria andPostUseridBetween(Integer value1, Integer value2) {
            addCriterion("POST_USERID between", value1, value2, "postUserid");
            return (Criteria) this;
        }

        public Criteria andPostUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("POST_USERID not between", value1, value2, "postUserid");
            return (Criteria) this;
        }

        public Criteria andPostCreatetimeIsNull() {
            addCriterion("POST_CREATETIME is null");
            return (Criteria) this;
        }

        public Criteria andPostCreatetimeIsNotNull() {
            addCriterion("POST_CREATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andPostCreatetimeEqualTo(Date value) {
            addCriterion("POST_CREATETIME =", value, "postCreatetime");
            return (Criteria) this;
        }

        public Criteria andPostCreatetimeNotEqualTo(Date value) {
            addCriterion("POST_CREATETIME <>", value, "postCreatetime");
            return (Criteria) this;
        }

        public Criteria andPostCreatetimeGreaterThan(Date value) {
            addCriterion("POST_CREATETIME >", value, "postCreatetime");
            return (Criteria) this;
        }

        public Criteria andPostCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("POST_CREATETIME >=", value, "postCreatetime");
            return (Criteria) this;
        }

        public Criteria andPostCreatetimeLessThan(Date value) {
            addCriterion("POST_CREATETIME <", value, "postCreatetime");
            return (Criteria) this;
        }

        public Criteria andPostCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("POST_CREATETIME <=", value, "postCreatetime");
            return (Criteria) this;
        }

        public Criteria andPostCreatetimeIn(List<Date> values) {
            addCriterion("POST_CREATETIME in", values, "postCreatetime");
            return (Criteria) this;
        }

        public Criteria andPostCreatetimeNotIn(List<Date> values) {
            addCriterion("POST_CREATETIME not in", values, "postCreatetime");
            return (Criteria) this;
        }

        public Criteria andPostCreatetimeBetween(Date value1, Date value2) {
            addCriterion("POST_CREATETIME between", value1, value2, "postCreatetime");
            return (Criteria) this;
        }

        public Criteria andPostCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("POST_CREATETIME not between", value1, value2, "postCreatetime");
            return (Criteria) this;
        }

        public Criteria andPostUpdatetimeIsNull() {
            addCriterion("POST_UPDATETIME is null");
            return (Criteria) this;
        }

        public Criteria andPostUpdatetimeIsNotNull() {
            addCriterion("POST_UPDATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andPostUpdatetimeEqualTo(Date value) {
            addCriterion("POST_UPDATETIME =", value, "postUpdatetime");
            return (Criteria) this;
        }

        public Criteria andPostUpdatetimeNotEqualTo(Date value) {
            addCriterion("POST_UPDATETIME <>", value, "postUpdatetime");
            return (Criteria) this;
        }

        public Criteria andPostUpdatetimeGreaterThan(Date value) {
            addCriterion("POST_UPDATETIME >", value, "postUpdatetime");
            return (Criteria) this;
        }

        public Criteria andPostUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("POST_UPDATETIME >=", value, "postUpdatetime");
            return (Criteria) this;
        }

        public Criteria andPostUpdatetimeLessThan(Date value) {
            addCriterion("POST_UPDATETIME <", value, "postUpdatetime");
            return (Criteria) this;
        }

        public Criteria andPostUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("POST_UPDATETIME <=", value, "postUpdatetime");
            return (Criteria) this;
        }

        public Criteria andPostUpdatetimeIn(List<Date> values) {
            addCriterion("POST_UPDATETIME in", values, "postUpdatetime");
            return (Criteria) this;
        }

        public Criteria andPostUpdatetimeNotIn(List<Date> values) {
            addCriterion("POST_UPDATETIME not in", values, "postUpdatetime");
            return (Criteria) this;
        }

        public Criteria andPostUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("POST_UPDATETIME between", value1, value2, "postUpdatetime");
            return (Criteria) this;
        }

        public Criteria andPostUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("POST_UPDATETIME not between", value1, value2, "postUpdatetime");
            return (Criteria) this;
        }

        public Criteria andPostContentIsNull() {
            addCriterion("POST_CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andPostContentIsNotNull() {
            addCriterion("POST_CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andPostContentEqualTo(String value) {
            addCriterion("POST_CONTENT =", value, "postContent");
            return (Criteria) this;
        }

        public Criteria andPostContentNotEqualTo(String value) {
            addCriterion("POST_CONTENT <>", value, "postContent");
            return (Criteria) this;
        }

        public Criteria andPostContentGreaterThan(String value) {
            addCriterion("POST_CONTENT >", value, "postContent");
            return (Criteria) this;
        }

        public Criteria andPostContentGreaterThanOrEqualTo(String value) {
            addCriterion("POST_CONTENT >=", value, "postContent");
            return (Criteria) this;
        }

        public Criteria andPostContentLessThan(String value) {
            addCriterion("POST_CONTENT <", value, "postContent");
            return (Criteria) this;
        }

        public Criteria andPostContentLessThanOrEqualTo(String value) {
            addCriterion("POST_CONTENT <=", value, "postContent");
            return (Criteria) this;
        }

        public Criteria andPostContentLike(String value) {
            addCriterion("POST_CONTENT like", value, "postContent");
            return (Criteria) this;
        }

        public Criteria andPostContentNotLike(String value) {
            addCriterion("POST_CONTENT not like", value, "postContent");
            return (Criteria) this;
        }

        public Criteria andPostContentIn(List<String> values) {
            addCriterion("POST_CONTENT in", values, "postContent");
            return (Criteria) this;
        }

        public Criteria andPostContentNotIn(List<String> values) {
            addCriterion("POST_CONTENT not in", values, "postContent");
            return (Criteria) this;
        }

        public Criteria andPostContentBetween(String value1, String value2) {
            addCriterion("POST_CONTENT between", value1, value2, "postContent");
            return (Criteria) this;
        }

        public Criteria andPostContentNotBetween(String value1, String value2) {
            addCriterion("POST_CONTENT not between", value1, value2, "postContent");
            return (Criteria) this;
        }

        public Criteria andPostRewardIsNull() {
            addCriterion("POST_REWARD is null");
            return (Criteria) this;
        }

        public Criteria andPostRewardIsNotNull() {
            addCriterion("POST_REWARD is not null");
            return (Criteria) this;
        }

        public Criteria andPostRewardEqualTo(Integer value) {
            addCriterion("POST_REWARD =", value, "postReward");
            return (Criteria) this;
        }

        public Criteria andPostRewardNotEqualTo(Integer value) {
            addCriterion("POST_REWARD <>", value, "postReward");
            return (Criteria) this;
        }

        public Criteria andPostRewardGreaterThan(Integer value) {
            addCriterion("POST_REWARD >", value, "postReward");
            return (Criteria) this;
        }

        public Criteria andPostRewardGreaterThanOrEqualTo(Integer value) {
            addCriterion("POST_REWARD >=", value, "postReward");
            return (Criteria) this;
        }

        public Criteria andPostRewardLessThan(Integer value) {
            addCriterion("POST_REWARD <", value, "postReward");
            return (Criteria) this;
        }

        public Criteria andPostRewardLessThanOrEqualTo(Integer value) {
            addCriterion("POST_REWARD <=", value, "postReward");
            return (Criteria) this;
        }

        public Criteria andPostRewardIn(List<Integer> values) {
            addCriterion("POST_REWARD in", values, "postReward");
            return (Criteria) this;
        }

        public Criteria andPostRewardNotIn(List<Integer> values) {
            addCriterion("POST_REWARD not in", values, "postReward");
            return (Criteria) this;
        }

        public Criteria andPostRewardBetween(Integer value1, Integer value2) {
            addCriterion("POST_REWARD between", value1, value2, "postReward");
            return (Criteria) this;
        }

        public Criteria andPostRewardNotBetween(Integer value1, Integer value2) {
            addCriterion("POST_REWARD not between", value1, value2, "postReward");
            return (Criteria) this;
        }

        public Criteria andPostScoreIsNull() {
            addCriterion("POST_SCORE is null");
            return (Criteria) this;
        }

        public Criteria andPostScoreIsNotNull() {
            addCriterion("POST_SCORE is not null");
            return (Criteria) this;
        }

        public Criteria andPostScoreEqualTo(Integer value) {
            addCriterion("POST_SCORE =", value, "postScore");
            return (Criteria) this;
        }

        public Criteria andPostScoreNotEqualTo(Integer value) {
            addCriterion("POST_SCORE <>", value, "postScore");
            return (Criteria) this;
        }

        public Criteria andPostScoreGreaterThan(Integer value) {
            addCriterion("POST_SCORE >", value, "postScore");
            return (Criteria) this;
        }

        public Criteria andPostScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("POST_SCORE >=", value, "postScore");
            return (Criteria) this;
        }

        public Criteria andPostScoreLessThan(Integer value) {
            addCriterion("POST_SCORE <", value, "postScore");
            return (Criteria) this;
        }

        public Criteria andPostScoreLessThanOrEqualTo(Integer value) {
            addCriterion("POST_SCORE <=", value, "postScore");
            return (Criteria) this;
        }

        public Criteria andPostScoreIn(List<Integer> values) {
            addCriterion("POST_SCORE in", values, "postScore");
            return (Criteria) this;
        }

        public Criteria andPostScoreNotIn(List<Integer> values) {
            addCriterion("POST_SCORE not in", values, "postScore");
            return (Criteria) this;
        }

        public Criteria andPostScoreBetween(Integer value1, Integer value2) {
            addCriterion("POST_SCORE between", value1, value2, "postScore");
            return (Criteria) this;
        }

        public Criteria andPostScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("POST_SCORE not between", value1, value2, "postScore");
            return (Criteria) this;
        }

        public Criteria andPostIspayIsNull() {
            addCriterion("POST_ISPAY is null");
            return (Criteria) this;
        }

        public Criteria andPostIspayIsNotNull() {
            addCriterion("POST_ISPAY is not null");
            return (Criteria) this;
        }

        public Criteria andPostIspayEqualTo(Byte value) {
            addCriterion("POST_ISPAY =", value, "postIspay");
            return (Criteria) this;
        }

        public Criteria andPostIspayNotEqualTo(Byte value) {
            addCriterion("POST_ISPAY <>", value, "postIspay");
            return (Criteria) this;
        }

        public Criteria andPostIspayGreaterThan(Byte value) {
            addCriterion("POST_ISPAY >", value, "postIspay");
            return (Criteria) this;
        }

        public Criteria andPostIspayGreaterThanOrEqualTo(Byte value) {
            addCriterion("POST_ISPAY >=", value, "postIspay");
            return (Criteria) this;
        }

        public Criteria andPostIspayLessThan(Byte value) {
            addCriterion("POST_ISPAY <", value, "postIspay");
            return (Criteria) this;
        }

        public Criteria andPostIspayLessThanOrEqualTo(Byte value) {
            addCriterion("POST_ISPAY <=", value, "postIspay");
            return (Criteria) this;
        }

        public Criteria andPostIspayIn(List<Byte> values) {
            addCriterion("POST_ISPAY in", values, "postIspay");
            return (Criteria) this;
        }

        public Criteria andPostIspayNotIn(List<Byte> values) {
            addCriterion("POST_ISPAY not in", values, "postIspay");
            return (Criteria) this;
        }

        public Criteria andPostIspayBetween(Byte value1, Byte value2) {
            addCriterion("POST_ISPAY between", value1, value2, "postIspay");
            return (Criteria) this;
        }

        public Criteria andPostIspayNotBetween(Byte value1, Byte value2) {
            addCriterion("POST_ISPAY not between", value1, value2, "postIspay");
            return (Criteria) this;
        }

        public Criteria andPostTypeIsNull() {
            addCriterion("POST_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPostTypeIsNotNull() {
            addCriterion("POST_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPostTypeEqualTo(Byte value) {
            addCriterion("POST_TYPE =", value, "postType");
            return (Criteria) this;
        }

        public Criteria andPostTypeNotEqualTo(Byte value) {
            addCriterion("POST_TYPE <>", value, "postType");
            return (Criteria) this;
        }

        public Criteria andPostTypeGreaterThan(Byte value) {
            addCriterion("POST_TYPE >", value, "postType");
            return (Criteria) this;
        }

        public Criteria andPostTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("POST_TYPE >=", value, "postType");
            return (Criteria) this;
        }

        public Criteria andPostTypeLessThan(Byte value) {
            addCriterion("POST_TYPE <", value, "postType");
            return (Criteria) this;
        }

        public Criteria andPostTypeLessThanOrEqualTo(Byte value) {
            addCriterion("POST_TYPE <=", value, "postType");
            return (Criteria) this;
        }

        public Criteria andPostTypeIn(List<Byte> values) {
            addCriterion("POST_TYPE in", values, "postType");
            return (Criteria) this;
        }

        public Criteria andPostTypeNotIn(List<Byte> values) {
            addCriterion("POST_TYPE not in", values, "postType");
            return (Criteria) this;
        }

        public Criteria andPostTypeBetween(Byte value1, Byte value2) {
            addCriterion("POST_TYPE between", value1, value2, "postType");
            return (Criteria) this;
        }

        public Criteria andPostTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("POST_TYPE not between", value1, value2, "postType");
            return (Criteria) this;
        }

        public Criteria andPostFlagIsNull() {
            addCriterion("POST_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andPostFlagIsNotNull() {
            addCriterion("POST_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andPostFlagEqualTo(Byte value) {
            addCriterion("POST_FLAG =", value, "postFlag");
            return (Criteria) this;
        }

        public Criteria andPostFlagNotEqualTo(Byte value) {
            addCriterion("POST_FLAG <>", value, "postFlag");
            return (Criteria) this;
        }

        public Criteria andPostFlagGreaterThan(Byte value) {
            addCriterion("POST_FLAG >", value, "postFlag");
            return (Criteria) this;
        }

        public Criteria andPostFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("POST_FLAG >=", value, "postFlag");
            return (Criteria) this;
        }

        public Criteria andPostFlagLessThan(Byte value) {
            addCriterion("POST_FLAG <", value, "postFlag");
            return (Criteria) this;
        }

        public Criteria andPostFlagLessThanOrEqualTo(Byte value) {
            addCriterion("POST_FLAG <=", value, "postFlag");
            return (Criteria) this;
        }

        public Criteria andPostFlagIn(List<Byte> values) {
            addCriterion("POST_FLAG in", values, "postFlag");
            return (Criteria) this;
        }

        public Criteria andPostFlagNotIn(List<Byte> values) {
            addCriterion("POST_FLAG not in", values, "postFlag");
            return (Criteria) this;
        }

        public Criteria andPostFlagBetween(Byte value1, Byte value2) {
            addCriterion("POST_FLAG between", value1, value2, "postFlag");
            return (Criteria) this;
        }

        public Criteria andPostFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("POST_FLAG not between", value1, value2, "postFlag");
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