package com.LiteTravel.web.Model;

import java.util.ArrayList;
import java.util.List;

public class OrderCommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderCommentExample() {
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

        public Criteria andOcIdIsNull() {
            addCriterion("oc_id is null");
            return (Criteria) this;
        }

        public Criteria andOcIdIsNotNull() {
            addCriterion("oc_id is not null");
            return (Criteria) this;
        }

        public Criteria andOcIdEqualTo(Integer value) {
            addCriterion("oc_id =", value, "ocId");
            return (Criteria) this;
        }

        public Criteria andOcIdNotEqualTo(Integer value) {
            addCriterion("oc_id <>", value, "ocId");
            return (Criteria) this;
        }

        public Criteria andOcIdGreaterThan(Integer value) {
            addCriterion("oc_id >", value, "ocId");
            return (Criteria) this;
        }

        public Criteria andOcIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("oc_id >=", value, "ocId");
            return (Criteria) this;
        }

        public Criteria andOcIdLessThan(Integer value) {
            addCriterion("oc_id <", value, "ocId");
            return (Criteria) this;
        }

        public Criteria andOcIdLessThanOrEqualTo(Integer value) {
            addCriterion("oc_id <=", value, "ocId");
            return (Criteria) this;
        }

        public Criteria andOcIdIn(List<Integer> values) {
            addCriterion("oc_id in", values, "ocId");
            return (Criteria) this;
        }

        public Criteria andOcIdNotIn(List<Integer> values) {
            addCriterion("oc_id not in", values, "ocId");
            return (Criteria) this;
        }

        public Criteria andOcIdBetween(Integer value1, Integer value2) {
            addCriterion("oc_id between", value1, value2, "ocId");
            return (Criteria) this;
        }

        public Criteria andOcIdNotBetween(Integer value1, Integer value2) {
            addCriterion("oc_id not between", value1, value2, "ocId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andHotelIdIsNull() {
            addCriterion("hotel_id is null");
            return (Criteria) this;
        }

        public Criteria andHotelIdIsNotNull() {
            addCriterion("hotel_id is not null");
            return (Criteria) this;
        }

        public Criteria andHotelIdEqualTo(Integer value) {
            addCriterion("hotel_id =", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdNotEqualTo(Integer value) {
            addCriterion("hotel_id <>", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdGreaterThan(Integer value) {
            addCriterion("hotel_id >", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("hotel_id >=", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdLessThan(Integer value) {
            addCriterion("hotel_id <", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdLessThanOrEqualTo(Integer value) {
            addCriterion("hotel_id <=", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdIn(List<Integer> values) {
            addCriterion("hotel_id in", values, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdNotIn(List<Integer> values) {
            addCriterion("hotel_id not in", values, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdBetween(Integer value1, Integer value2) {
            addCriterion("hotel_id between", value1, value2, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdNotBetween(Integer value1, Integer value2) {
            addCriterion("hotel_id not between", value1, value2, "hotelId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Integer value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Integer value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Integer value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Integer value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Integer> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Integer> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOcScoreIsNull() {
            addCriterion("oc_score is null");
            return (Criteria) this;
        }

        public Criteria andOcScoreIsNotNull() {
            addCriterion("oc_score is not null");
            return (Criteria) this;
        }

        public Criteria andOcScoreEqualTo(Integer value) {
            addCriterion("oc_score =", value, "ocScore");
            return (Criteria) this;
        }

        public Criteria andOcScoreNotEqualTo(Integer value) {
            addCriterion("oc_score <>", value, "ocScore");
            return (Criteria) this;
        }

        public Criteria andOcScoreGreaterThan(Integer value) {
            addCriterion("oc_score >", value, "ocScore");
            return (Criteria) this;
        }

        public Criteria andOcScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("oc_score >=", value, "ocScore");
            return (Criteria) this;
        }

        public Criteria andOcScoreLessThan(Integer value) {
            addCriterion("oc_score <", value, "ocScore");
            return (Criteria) this;
        }

        public Criteria andOcScoreLessThanOrEqualTo(Integer value) {
            addCriterion("oc_score <=", value, "ocScore");
            return (Criteria) this;
        }

        public Criteria andOcScoreIn(List<Integer> values) {
            addCriterion("oc_score in", values, "ocScore");
            return (Criteria) this;
        }

        public Criteria andOcScoreNotIn(List<Integer> values) {
            addCriterion("oc_score not in", values, "ocScore");
            return (Criteria) this;
        }

        public Criteria andOcScoreBetween(Integer value1, Integer value2) {
            addCriterion("oc_score between", value1, value2, "ocScore");
            return (Criteria) this;
        }

        public Criteria andOcScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("oc_score not between", value1, value2, "ocScore");
            return (Criteria) this;
        }

        public Criteria andOcDetailIsNull() {
            addCriterion("oc_detail is null");
            return (Criteria) this;
        }

        public Criteria andOcDetailIsNotNull() {
            addCriterion("oc_detail is not null");
            return (Criteria) this;
        }

        public Criteria andOcDetailEqualTo(String value) {
            addCriterion("oc_detail =", value, "ocDetail");
            return (Criteria) this;
        }

        public Criteria andOcDetailNotEqualTo(String value) {
            addCriterion("oc_detail <>", value, "ocDetail");
            return (Criteria) this;
        }

        public Criteria andOcDetailGreaterThan(String value) {
            addCriterion("oc_detail >", value, "ocDetail");
            return (Criteria) this;
        }

        public Criteria andOcDetailGreaterThanOrEqualTo(String value) {
            addCriterion("oc_detail >=", value, "ocDetail");
            return (Criteria) this;
        }

        public Criteria andOcDetailLessThan(String value) {
            addCriterion("oc_detail <", value, "ocDetail");
            return (Criteria) this;
        }

        public Criteria andOcDetailLessThanOrEqualTo(String value) {
            addCriterion("oc_detail <=", value, "ocDetail");
            return (Criteria) this;
        }

        public Criteria andOcDetailLike(String value) {
            addCriterion("oc_detail like", value, "ocDetail");
            return (Criteria) this;
        }

        public Criteria andOcDetailNotLike(String value) {
            addCriterion("oc_detail not like", value, "ocDetail");
            return (Criteria) this;
        }

        public Criteria andOcDetailIn(List<String> values) {
            addCriterion("oc_detail in", values, "ocDetail");
            return (Criteria) this;
        }

        public Criteria andOcDetailNotIn(List<String> values) {
            addCriterion("oc_detail not in", values, "ocDetail");
            return (Criteria) this;
        }

        public Criteria andOcDetailBetween(String value1, String value2) {
            addCriterion("oc_detail between", value1, value2, "ocDetail");
            return (Criteria) this;
        }

        public Criteria andOcDetailNotBetween(String value1, String value2) {
            addCriterion("oc_detail not between", value1, value2, "ocDetail");
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