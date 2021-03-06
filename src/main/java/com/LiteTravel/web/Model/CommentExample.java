package com.LiteTravel.web.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommentExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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
            addCriterion("comment_id is null");
            return (Criteria) this;
        }

        public Criteria andCommentIdIsNotNull() {
            addCriterion("comment_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommentIdEqualTo(Integer value) {
            addCriterion("comment_id =", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotEqualTo(Integer value) {
            addCriterion("comment_id <>", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThan(Integer value) {
            addCriterion("comment_id >", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_id >=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThan(Integer value) {
            addCriterion("comment_id <", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThanOrEqualTo(Integer value) {
            addCriterion("comment_id <=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdIn(List<Integer> values) {
            addCriterion("comment_id in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotIn(List<Integer> values) {
            addCriterion("comment_id not in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdBetween(Integer value1, Integer value2) {
            addCriterion("comment_id between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_id not between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andParentTypeIsNull() {
            addCriterion("parent_type is null");
            return (Criteria) this;
        }

        public Criteria andParentTypeIsNotNull() {
            addCriterion("parent_type is not null");
            return (Criteria) this;
        }

        public Criteria andParentTypeEqualTo(Integer value) {
            addCriterion("parent_type =", value, "parentType");
            return (Criteria) this;
        }

        public Criteria andParentTypeNotEqualTo(Integer value) {
            addCriterion("parent_type <>", value, "parentType");
            return (Criteria) this;
        }

        public Criteria andParentTypeGreaterThan(Integer value) {
            addCriterion("parent_type >", value, "parentType");
            return (Criteria) this;
        }

        public Criteria andParentTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("parent_type >=", value, "parentType");
            return (Criteria) this;
        }

        public Criteria andParentTypeLessThan(Integer value) {
            addCriterion("parent_type <", value, "parentType");
            return (Criteria) this;
        }

        public Criteria andParentTypeLessThanOrEqualTo(Integer value) {
            addCriterion("parent_type <=", value, "parentType");
            return (Criteria) this;
        }

        public Criteria andParentTypeIn(List<Integer> values) {
            addCriterion("parent_type in", values, "parentType");
            return (Criteria) this;
        }

        public Criteria andParentTypeNotIn(List<Integer> values) {
            addCriterion("parent_type not in", values, "parentType");
            return (Criteria) this;
        }

        public Criteria andParentTypeBetween(Integer value1, Integer value2) {
            addCriterion("parent_type between", value1, value2, "parentType");
            return (Criteria) this;
        }

        public Criteria andParentTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("parent_type not between", value1, value2, "parentType");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(Integer value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(Integer value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(Integer value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(Integer value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(Integer value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<Integer> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<Integer> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(Integer value1, Integer value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andCommentPostTimeIsNull() {
            addCriterion("comment_post_time is null");
            return (Criteria) this;
        }

        public Criteria andCommentPostTimeIsNotNull() {
            addCriterion("comment_post_time is not null");
            return (Criteria) this;
        }

        public Criteria andCommentPostTimeEqualTo(Date value) {
            addCriterion("comment_post_time =", value, "commentPostTime");
            return (Criteria) this;
        }

        public Criteria andCommentPostTimeNotEqualTo(Date value) {
            addCriterion("comment_post_time <>", value, "commentPostTime");
            return (Criteria) this;
        }

        public Criteria andCommentPostTimeGreaterThan(Date value) {
            addCriterion("comment_post_time >", value, "commentPostTime");
            return (Criteria) this;
        }

        public Criteria andCommentPostTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("comment_post_time >=", value, "commentPostTime");
            return (Criteria) this;
        }

        public Criteria andCommentPostTimeLessThan(Date value) {
            addCriterion("comment_post_time <", value, "commentPostTime");
            return (Criteria) this;
        }

        public Criteria andCommentPostTimeLessThanOrEqualTo(Date value) {
            addCriterion("comment_post_time <=", value, "commentPostTime");
            return (Criteria) this;
        }

        public Criteria andCommentPostTimeIn(List<Date> values) {
            addCriterion("comment_post_time in", values, "commentPostTime");
            return (Criteria) this;
        }

        public Criteria andCommentPostTimeNotIn(List<Date> values) {
            addCriterion("comment_post_time not in", values, "commentPostTime");
            return (Criteria) this;
        }

        public Criteria andCommentPostTimeBetween(Date value1, Date value2) {
            addCriterion("comment_post_time between", value1, value2, "commentPostTime");
            return (Criteria) this;
        }

        public Criteria andCommentPostTimeNotBetween(Date value1, Date value2) {
            addCriterion("comment_post_time not between", value1, value2, "commentPostTime");
            return (Criteria) this;
        }

        public Criteria andCommentModifyTimeIsNull() {
            addCriterion("comment_modify_time is null");
            return (Criteria) this;
        }

        public Criteria andCommentModifyTimeIsNotNull() {
            addCriterion("comment_modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andCommentModifyTimeEqualTo(Date value) {
            addCriterion("comment_modify_time =", value, "commentModifyTime");
            return (Criteria) this;
        }

        public Criteria andCommentModifyTimeNotEqualTo(Date value) {
            addCriterion("comment_modify_time <>", value, "commentModifyTime");
            return (Criteria) this;
        }

        public Criteria andCommentModifyTimeGreaterThan(Date value) {
            addCriterion("comment_modify_time >", value, "commentModifyTime");
            return (Criteria) this;
        }

        public Criteria andCommentModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("comment_modify_time >=", value, "commentModifyTime");
            return (Criteria) this;
        }

        public Criteria andCommentModifyTimeLessThan(Date value) {
            addCriterion("comment_modify_time <", value, "commentModifyTime");
            return (Criteria) this;
        }

        public Criteria andCommentModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("comment_modify_time <=", value, "commentModifyTime");
            return (Criteria) this;
        }

        public Criteria andCommentModifyTimeIn(List<Date> values) {
            addCriterion("comment_modify_time in", values, "commentModifyTime");
            return (Criteria) this;
        }

        public Criteria andCommentModifyTimeNotIn(List<Date> values) {
            addCriterion("comment_modify_time not in", values, "commentModifyTime");
            return (Criteria) this;
        }

        public Criteria andCommentModifyTimeBetween(Date value1, Date value2) {
            addCriterion("comment_modify_time between", value1, value2, "commentModifyTime");
            return (Criteria) this;
        }

        public Criteria andCommentModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("comment_modify_time not between", value1, value2, "commentModifyTime");
            return (Criteria) this;
        }

        public Criteria andCommentPosterIdIsNull() {
            addCriterion("comment_poster_id is null");
            return (Criteria) this;
        }

        public Criteria andCommentPosterIdIsNotNull() {
            addCriterion("comment_poster_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommentPosterIdEqualTo(Integer value) {
            addCriterion("comment_poster_id =", value, "commentPosterId");
            return (Criteria) this;
        }

        public Criteria andCommentPosterIdNotEqualTo(Integer value) {
            addCriterion("comment_poster_id <>", value, "commentPosterId");
            return (Criteria) this;
        }

        public Criteria andCommentPosterIdGreaterThan(Integer value) {
            addCriterion("comment_poster_id >", value, "commentPosterId");
            return (Criteria) this;
        }

        public Criteria andCommentPosterIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_poster_id >=", value, "commentPosterId");
            return (Criteria) this;
        }

        public Criteria andCommentPosterIdLessThan(Integer value) {
            addCriterion("comment_poster_id <", value, "commentPosterId");
            return (Criteria) this;
        }

        public Criteria andCommentPosterIdLessThanOrEqualTo(Integer value) {
            addCriterion("comment_poster_id <=", value, "commentPosterId");
            return (Criteria) this;
        }

        public Criteria andCommentPosterIdIn(List<Integer> values) {
            addCriterion("comment_poster_id in", values, "commentPosterId");
            return (Criteria) this;
        }

        public Criteria andCommentPosterIdNotIn(List<Integer> values) {
            addCriterion("comment_poster_id not in", values, "commentPosterId");
            return (Criteria) this;
        }

        public Criteria andCommentPosterIdBetween(Integer value1, Integer value2) {
            addCriterion("comment_poster_id between", value1, value2, "commentPosterId");
            return (Criteria) this;
        }

        public Criteria andCommentPosterIdNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_poster_id not between", value1, value2, "commentPosterId");
            return (Criteria) this;
        }

        public Criteria andCommentLikeCountIsNull() {
            addCriterion("comment_like_count is null");
            return (Criteria) this;
        }

        public Criteria andCommentLikeCountIsNotNull() {
            addCriterion("comment_like_count is not null");
            return (Criteria) this;
        }

        public Criteria andCommentLikeCountEqualTo(Integer value) {
            addCriterion("comment_like_count =", value, "commentLikeCount");
            return (Criteria) this;
        }

        public Criteria andCommentLikeCountNotEqualTo(Integer value) {
            addCriterion("comment_like_count <>", value, "commentLikeCount");
            return (Criteria) this;
        }

        public Criteria andCommentLikeCountGreaterThan(Integer value) {
            addCriterion("comment_like_count >", value, "commentLikeCount");
            return (Criteria) this;
        }

        public Criteria andCommentLikeCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_like_count >=", value, "commentLikeCount");
            return (Criteria) this;
        }

        public Criteria andCommentLikeCountLessThan(Integer value) {
            addCriterion("comment_like_count <", value, "commentLikeCount");
            return (Criteria) this;
        }

        public Criteria andCommentLikeCountLessThanOrEqualTo(Integer value) {
            addCriterion("comment_like_count <=", value, "commentLikeCount");
            return (Criteria) this;
        }

        public Criteria andCommentLikeCountIn(List<Integer> values) {
            addCriterion("comment_like_count in", values, "commentLikeCount");
            return (Criteria) this;
        }

        public Criteria andCommentLikeCountNotIn(List<Integer> values) {
            addCriterion("comment_like_count not in", values, "commentLikeCount");
            return (Criteria) this;
        }

        public Criteria andCommentLikeCountBetween(Integer value1, Integer value2) {
            addCriterion("comment_like_count between", value1, value2, "commentLikeCount");
            return (Criteria) this;
        }

        public Criteria andCommentLikeCountNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_like_count not between", value1, value2, "commentLikeCount");
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