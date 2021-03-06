package com.LiteTravel.web.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BlogExample() {
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

        public Criteria andBlogIdIsNull() {
            addCriterion("blog_id is null");
            return (Criteria) this;
        }

        public Criteria andBlogIdIsNotNull() {
            addCriterion("blog_id is not null");
            return (Criteria) this;
        }

        public Criteria andBlogIdEqualTo(Integer value) {
            addCriterion("blog_id =", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdNotEqualTo(Integer value) {
            addCriterion("blog_id <>", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdGreaterThan(Integer value) {
            addCriterion("blog_id >", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("blog_id >=", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdLessThan(Integer value) {
            addCriterion("blog_id <", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdLessThanOrEqualTo(Integer value) {
            addCriterion("blog_id <=", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdIn(List<Integer> values) {
            addCriterion("blog_id in", values, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdNotIn(List<Integer> values) {
            addCriterion("blog_id not in", values, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdBetween(Integer value1, Integer value2) {
            addCriterion("blog_id between", value1, value2, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdNotBetween(Integer value1, Integer value2) {
            addCriterion("blog_id not between", value1, value2, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogTitleIsNull() {
            addCriterion("blog_title is null");
            return (Criteria) this;
        }

        public Criteria andBlogTitleIsNotNull() {
            addCriterion("blog_title is not null");
            return (Criteria) this;
        }

        public Criteria andBlogTitleEqualTo(String value) {
            addCriterion("blog_title =", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleNotEqualTo(String value) {
            addCriterion("blog_title <>", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleGreaterThan(String value) {
            addCriterion("blog_title >", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleGreaterThanOrEqualTo(String value) {
            addCriterion("blog_title >=", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleLessThan(String value) {
            addCriterion("blog_title <", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleLessThanOrEqualTo(String value) {
            addCriterion("blog_title <=", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleLike(String value) {
            addCriterion("blog_title like", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleNotLike(String value) {
            addCriterion("blog_title not like", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleIn(List<String> values) {
            addCriterion("blog_title in", values, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleNotIn(List<String> values) {
            addCriterion("blog_title not in", values, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleBetween(String value1, String value2) {
            addCriterion("blog_title between", value1, value2, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleNotBetween(String value1, String value2) {
            addCriterion("blog_title not between", value1, value2, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogPostTimeIsNull() {
            addCriterion("blog_post_time is null");
            return (Criteria) this;
        }

        public Criteria andBlogPostTimeIsNotNull() {
            addCriterion("blog_post_time is not null");
            return (Criteria) this;
        }

        public Criteria andBlogPostTimeEqualTo(Date value) {
            addCriterion("blog_post_time =", value, "blogPostTime");
            return (Criteria) this;
        }

        public Criteria andBlogPostTimeNotEqualTo(Date value) {
            addCriterion("blog_post_time <>", value, "blogPostTime");
            return (Criteria) this;
        }

        public Criteria andBlogPostTimeGreaterThan(Date value) {
            addCriterion("blog_post_time >", value, "blogPostTime");
            return (Criteria) this;
        }

        public Criteria andBlogPostTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("blog_post_time >=", value, "blogPostTime");
            return (Criteria) this;
        }

        public Criteria andBlogPostTimeLessThan(Date value) {
            addCriterion("blog_post_time <", value, "blogPostTime");
            return (Criteria) this;
        }

        public Criteria andBlogPostTimeLessThanOrEqualTo(Date value) {
            addCriterion("blog_post_time <=", value, "blogPostTime");
            return (Criteria) this;
        }

        public Criteria andBlogPostTimeIn(List<Date> values) {
            addCriterion("blog_post_time in", values, "blogPostTime");
            return (Criteria) this;
        }

        public Criteria andBlogPostTimeNotIn(List<Date> values) {
            addCriterion("blog_post_time not in", values, "blogPostTime");
            return (Criteria) this;
        }

        public Criteria andBlogPostTimeBetween(Date value1, Date value2) {
            addCriterion("blog_post_time between", value1, value2, "blogPostTime");
            return (Criteria) this;
        }

        public Criteria andBlogPostTimeNotBetween(Date value1, Date value2) {
            addCriterion("blog_post_time not between", value1, value2, "blogPostTime");
            return (Criteria) this;
        }

        public Criteria andBlogModifyTimeIsNull() {
            addCriterion("blog_modify_time is null");
            return (Criteria) this;
        }

        public Criteria andBlogModifyTimeIsNotNull() {
            addCriterion("blog_modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andBlogModifyTimeEqualTo(Date value) {
            addCriterion("blog_modify_time =", value, "blogModifyTime");
            return (Criteria) this;
        }

        public Criteria andBlogModifyTimeNotEqualTo(Date value) {
            addCriterion("blog_modify_time <>", value, "blogModifyTime");
            return (Criteria) this;
        }

        public Criteria andBlogModifyTimeGreaterThan(Date value) {
            addCriterion("blog_modify_time >", value, "blogModifyTime");
            return (Criteria) this;
        }

        public Criteria andBlogModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("blog_modify_time >=", value, "blogModifyTime");
            return (Criteria) this;
        }

        public Criteria andBlogModifyTimeLessThan(Date value) {
            addCriterion("blog_modify_time <", value, "blogModifyTime");
            return (Criteria) this;
        }

        public Criteria andBlogModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("blog_modify_time <=", value, "blogModifyTime");
            return (Criteria) this;
        }

        public Criteria andBlogModifyTimeIn(List<Date> values) {
            addCriterion("blog_modify_time in", values, "blogModifyTime");
            return (Criteria) this;
        }

        public Criteria andBlogModifyTimeNotIn(List<Date> values) {
            addCriterion("blog_modify_time not in", values, "blogModifyTime");
            return (Criteria) this;
        }

        public Criteria andBlogModifyTimeBetween(Date value1, Date value2) {
            addCriterion("blog_modify_time between", value1, value2, "blogModifyTime");
            return (Criteria) this;
        }

        public Criteria andBlogModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("blog_modify_time not between", value1, value2, "blogModifyTime");
            return (Criteria) this;
        }

        public Criteria andBlogPosterIdIsNull() {
            addCriterion("blog_poster_id is null");
            return (Criteria) this;
        }

        public Criteria andBlogPosterIdIsNotNull() {
            addCriterion("blog_poster_id is not null");
            return (Criteria) this;
        }

        public Criteria andBlogPosterIdEqualTo(Integer value) {
            addCriterion("blog_poster_id =", value, "blogPosterId");
            return (Criteria) this;
        }

        public Criteria andBlogPosterIdNotEqualTo(Integer value) {
            addCriterion("blog_poster_id <>", value, "blogPosterId");
            return (Criteria) this;
        }

        public Criteria andBlogPosterIdGreaterThan(Integer value) {
            addCriterion("blog_poster_id >", value, "blogPosterId");
            return (Criteria) this;
        }

        public Criteria andBlogPosterIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("blog_poster_id >=", value, "blogPosterId");
            return (Criteria) this;
        }

        public Criteria andBlogPosterIdLessThan(Integer value) {
            addCriterion("blog_poster_id <", value, "blogPosterId");
            return (Criteria) this;
        }

        public Criteria andBlogPosterIdLessThanOrEqualTo(Integer value) {
            addCriterion("blog_poster_id <=", value, "blogPosterId");
            return (Criteria) this;
        }

        public Criteria andBlogPosterIdIn(List<Integer> values) {
            addCriterion("blog_poster_id in", values, "blogPosterId");
            return (Criteria) this;
        }

        public Criteria andBlogPosterIdNotIn(List<Integer> values) {
            addCriterion("blog_poster_id not in", values, "blogPosterId");
            return (Criteria) this;
        }

        public Criteria andBlogPosterIdBetween(Integer value1, Integer value2) {
            addCriterion("blog_poster_id between", value1, value2, "blogPosterId");
            return (Criteria) this;
        }

        public Criteria andBlogPosterIdNotBetween(Integer value1, Integer value2) {
            addCriterion("blog_poster_id not between", value1, value2, "blogPosterId");
            return (Criteria) this;
        }

        public Criteria andBlogImgUriIsNull() {
            addCriterion("blog_img_uri is null");
            return (Criteria) this;
        }

        public Criteria andBlogImgUriIsNotNull() {
            addCriterion("blog_img_uri is not null");
            return (Criteria) this;
        }

        public Criteria andBlogImgUriEqualTo(String value) {
            addCriterion("blog_img_uri =", value, "blogImgUri");
            return (Criteria) this;
        }

        public Criteria andBlogImgUriNotEqualTo(String value) {
            addCriterion("blog_img_uri <>", value, "blogImgUri");
            return (Criteria) this;
        }

        public Criteria andBlogImgUriGreaterThan(String value) {
            addCriterion("blog_img_uri >", value, "blogImgUri");
            return (Criteria) this;
        }

        public Criteria andBlogImgUriGreaterThanOrEqualTo(String value) {
            addCriterion("blog_img_uri >=", value, "blogImgUri");
            return (Criteria) this;
        }

        public Criteria andBlogImgUriLessThan(String value) {
            addCriterion("blog_img_uri <", value, "blogImgUri");
            return (Criteria) this;
        }

        public Criteria andBlogImgUriLessThanOrEqualTo(String value) {
            addCriterion("blog_img_uri <=", value, "blogImgUri");
            return (Criteria) this;
        }

        public Criteria andBlogImgUriLike(String value) {
            addCriterion("blog_img_uri like", value, "blogImgUri");
            return (Criteria) this;
        }

        public Criteria andBlogImgUriNotLike(String value) {
            addCriterion("blog_img_uri not like", value, "blogImgUri");
            return (Criteria) this;
        }

        public Criteria andBlogImgUriIn(List<String> values) {
            addCriterion("blog_img_uri in", values, "blogImgUri");
            return (Criteria) this;
        }

        public Criteria andBlogImgUriNotIn(List<String> values) {
            addCriterion("blog_img_uri not in", values, "blogImgUri");
            return (Criteria) this;
        }

        public Criteria andBlogImgUriBetween(String value1, String value2) {
            addCriterion("blog_img_uri between", value1, value2, "blogImgUri");
            return (Criteria) this;
        }

        public Criteria andBlogImgUriNotBetween(String value1, String value2) {
            addCriterion("blog_img_uri not between", value1, value2, "blogImgUri");
            return (Criteria) this;
        }

        public Criteria andBlogLikeCountIsNull() {
            addCriterion("blog_like_count is null");
            return (Criteria) this;
        }

        public Criteria andBlogLikeCountIsNotNull() {
            addCriterion("blog_like_count is not null");
            return (Criteria) this;
        }

        public Criteria andBlogLikeCountEqualTo(Integer value) {
            addCriterion("blog_like_count =", value, "blogLikeCount");
            return (Criteria) this;
        }

        public Criteria andBlogLikeCountNotEqualTo(Integer value) {
            addCriterion("blog_like_count <>", value, "blogLikeCount");
            return (Criteria) this;
        }

        public Criteria andBlogLikeCountGreaterThan(Integer value) {
            addCriterion("blog_like_count >", value, "blogLikeCount");
            return (Criteria) this;
        }

        public Criteria andBlogLikeCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("blog_like_count >=", value, "blogLikeCount");
            return (Criteria) this;
        }

        public Criteria andBlogLikeCountLessThan(Integer value) {
            addCriterion("blog_like_count <", value, "blogLikeCount");
            return (Criteria) this;
        }

        public Criteria andBlogLikeCountLessThanOrEqualTo(Integer value) {
            addCriterion("blog_like_count <=", value, "blogLikeCount");
            return (Criteria) this;
        }

        public Criteria andBlogLikeCountIn(List<Integer> values) {
            addCriterion("blog_like_count in", values, "blogLikeCount");
            return (Criteria) this;
        }

        public Criteria andBlogLikeCountNotIn(List<Integer> values) {
            addCriterion("blog_like_count not in", values, "blogLikeCount");
            return (Criteria) this;
        }

        public Criteria andBlogLikeCountBetween(Integer value1, Integer value2) {
            addCriterion("blog_like_count between", value1, value2, "blogLikeCount");
            return (Criteria) this;
        }

        public Criteria andBlogLikeCountNotBetween(Integer value1, Integer value2) {
            addCriterion("blog_like_count not between", value1, value2, "blogLikeCount");
            return (Criteria) this;
        }

        public Criteria andBlogCommentCountIsNull() {
            addCriterion("blog_comment_count is null");
            return (Criteria) this;
        }

        public Criteria andBlogCommentCountIsNotNull() {
            addCriterion("blog_comment_count is not null");
            return (Criteria) this;
        }

        public Criteria andBlogCommentCountEqualTo(Integer value) {
            addCriterion("blog_comment_count =", value, "blogCommentCount");
            return (Criteria) this;
        }

        public Criteria andBlogCommentCountNotEqualTo(Integer value) {
            addCriterion("blog_comment_count <>", value, "blogCommentCount");
            return (Criteria) this;
        }

        public Criteria andBlogCommentCountGreaterThan(Integer value) {
            addCriterion("blog_comment_count >", value, "blogCommentCount");
            return (Criteria) this;
        }

        public Criteria andBlogCommentCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("blog_comment_count >=", value, "blogCommentCount");
            return (Criteria) this;
        }

        public Criteria andBlogCommentCountLessThan(Integer value) {
            addCriterion("blog_comment_count <", value, "blogCommentCount");
            return (Criteria) this;
        }

        public Criteria andBlogCommentCountLessThanOrEqualTo(Integer value) {
            addCriterion("blog_comment_count <=", value, "blogCommentCount");
            return (Criteria) this;
        }

        public Criteria andBlogCommentCountIn(List<Integer> values) {
            addCriterion("blog_comment_count in", values, "blogCommentCount");
            return (Criteria) this;
        }

        public Criteria andBlogCommentCountNotIn(List<Integer> values) {
            addCriterion("blog_comment_count not in", values, "blogCommentCount");
            return (Criteria) this;
        }

        public Criteria andBlogCommentCountBetween(Integer value1, Integer value2) {
            addCriterion("blog_comment_count between", value1, value2, "blogCommentCount");
            return (Criteria) this;
        }

        public Criteria andBlogCommentCountNotBetween(Integer value1, Integer value2) {
            addCriterion("blog_comment_count not between", value1, value2, "blogCommentCount");
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