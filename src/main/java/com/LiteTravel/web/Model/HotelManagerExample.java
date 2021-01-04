package com.LiteTravel.web.Model;

import java.util.ArrayList;
import java.util.List;

public class HotelManagerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HotelManagerExample() {
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

        public Criteria andManagerIdIsNull() {
            addCriterion("manager_id is null");
            return (Criteria) this;
        }

        public Criteria andManagerIdIsNotNull() {
            addCriterion("manager_id is not null");
            return (Criteria) this;
        }

        public Criteria andManagerIdEqualTo(Integer value) {
            addCriterion("manager_id =", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdNotEqualTo(Integer value) {
            addCriterion("manager_id <>", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdGreaterThan(Integer value) {
            addCriterion("manager_id >", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("manager_id >=", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdLessThan(Integer value) {
            addCriterion("manager_id <", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdLessThanOrEqualTo(Integer value) {
            addCriterion("manager_id <=", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdIn(List<Integer> values) {
            addCriterion("manager_id in", values, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdNotIn(List<Integer> values) {
            addCriterion("manager_id not in", values, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdBetween(Integer value1, Integer value2) {
            addCriterion("manager_id between", value1, value2, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("manager_id not between", value1, value2, "managerId");
            return (Criteria) this;
        }

        public Criteria andHotelManagerIdIsNull() {
            addCriterion("hotel_manager_id is null");
            return (Criteria) this;
        }

        public Criteria andHotelManagerIdIsNotNull() {
            addCriterion("hotel_manager_id is not null");
            return (Criteria) this;
        }

        public Criteria andHotelManagerIdEqualTo(Integer value) {
            addCriterion("hotel_manager_id =", value, "hotelManagerId");
            return (Criteria) this;
        }

        public Criteria andHotelManagerIdNotEqualTo(Integer value) {
            addCriterion("hotel_manager_id <>", value, "hotelManagerId");
            return (Criteria) this;
        }

        public Criteria andHotelManagerIdGreaterThan(Integer value) {
            addCriterion("hotel_manager_id >", value, "hotelManagerId");
            return (Criteria) this;
        }

        public Criteria andHotelManagerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("hotel_manager_id >=", value, "hotelManagerId");
            return (Criteria) this;
        }

        public Criteria andHotelManagerIdLessThan(Integer value) {
            addCriterion("hotel_manager_id <", value, "hotelManagerId");
            return (Criteria) this;
        }

        public Criteria andHotelManagerIdLessThanOrEqualTo(Integer value) {
            addCriterion("hotel_manager_id <=", value, "hotelManagerId");
            return (Criteria) this;
        }

        public Criteria andHotelManagerIdIn(List<Integer> values) {
            addCriterion("hotel_manager_id in", values, "hotelManagerId");
            return (Criteria) this;
        }

        public Criteria andHotelManagerIdNotIn(List<Integer> values) {
            addCriterion("hotel_manager_id not in", values, "hotelManagerId");
            return (Criteria) this;
        }

        public Criteria andHotelManagerIdBetween(Integer value1, Integer value2) {
            addCriterion("hotel_manager_id between", value1, value2, "hotelManagerId");
            return (Criteria) this;
        }

        public Criteria andHotelManagerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("hotel_manager_id not between", value1, value2, "hotelManagerId");
            return (Criteria) this;
        }

        public Criteria andHotelManagerNameIsNull() {
            addCriterion("hotel_manager_name is null");
            return (Criteria) this;
        }

        public Criteria andHotelManagerNameIsNotNull() {
            addCriterion("hotel_manager_name is not null");
            return (Criteria) this;
        }

        public Criteria andHotelManagerNameEqualTo(String value) {
            addCriterion("hotel_manager_name =", value, "hotelManagerName");
            return (Criteria) this;
        }

        public Criteria andHotelManagerNameNotEqualTo(String value) {
            addCriterion("hotel_manager_name <>", value, "hotelManagerName");
            return (Criteria) this;
        }

        public Criteria andHotelManagerNameGreaterThan(String value) {
            addCriterion("hotel_manager_name >", value, "hotelManagerName");
            return (Criteria) this;
        }

        public Criteria andHotelManagerNameGreaterThanOrEqualTo(String value) {
            addCriterion("hotel_manager_name >=", value, "hotelManagerName");
            return (Criteria) this;
        }

        public Criteria andHotelManagerNameLessThan(String value) {
            addCriterion("hotel_manager_name <", value, "hotelManagerName");
            return (Criteria) this;
        }

        public Criteria andHotelManagerNameLessThanOrEqualTo(String value) {
            addCriterion("hotel_manager_name <=", value, "hotelManagerName");
            return (Criteria) this;
        }

        public Criteria andHotelManagerNameLike(String value) {
            addCriterion("hotel_manager_name like", value, "hotelManagerName");
            return (Criteria) this;
        }

        public Criteria andHotelManagerNameNotLike(String value) {
            addCriterion("hotel_manager_name not like", value, "hotelManagerName");
            return (Criteria) this;
        }

        public Criteria andHotelManagerNameIn(List<String> values) {
            addCriterion("hotel_manager_name in", values, "hotelManagerName");
            return (Criteria) this;
        }

        public Criteria andHotelManagerNameNotIn(List<String> values) {
            addCriterion("hotel_manager_name not in", values, "hotelManagerName");
            return (Criteria) this;
        }

        public Criteria andHotelManagerNameBetween(String value1, String value2) {
            addCriterion("hotel_manager_name between", value1, value2, "hotelManagerName");
            return (Criteria) this;
        }

        public Criteria andHotelManagerNameNotBetween(String value1, String value2) {
            addCriterion("hotel_manager_name not between", value1, value2, "hotelManagerName");
            return (Criteria) this;
        }

        public Criteria andHotelManagerPhoneIsNull() {
            addCriterion("hotel_manager_phone is null");
            return (Criteria) this;
        }

        public Criteria andHotelManagerPhoneIsNotNull() {
            addCriterion("hotel_manager_phone is not null");
            return (Criteria) this;
        }

        public Criteria andHotelManagerPhoneEqualTo(String value) {
            addCriterion("hotel_manager_phone =", value, "hotelManagerPhone");
            return (Criteria) this;
        }

        public Criteria andHotelManagerPhoneNotEqualTo(String value) {
            addCriterion("hotel_manager_phone <>", value, "hotelManagerPhone");
            return (Criteria) this;
        }

        public Criteria andHotelManagerPhoneGreaterThan(String value) {
            addCriterion("hotel_manager_phone >", value, "hotelManagerPhone");
            return (Criteria) this;
        }

        public Criteria andHotelManagerPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("hotel_manager_phone >=", value, "hotelManagerPhone");
            return (Criteria) this;
        }

        public Criteria andHotelManagerPhoneLessThan(String value) {
            addCriterion("hotel_manager_phone <", value, "hotelManagerPhone");
            return (Criteria) this;
        }

        public Criteria andHotelManagerPhoneLessThanOrEqualTo(String value) {
            addCriterion("hotel_manager_phone <=", value, "hotelManagerPhone");
            return (Criteria) this;
        }

        public Criteria andHotelManagerPhoneLike(String value) {
            addCriterion("hotel_manager_phone like", value, "hotelManagerPhone");
            return (Criteria) this;
        }

        public Criteria andHotelManagerPhoneNotLike(String value) {
            addCriterion("hotel_manager_phone not like", value, "hotelManagerPhone");
            return (Criteria) this;
        }

        public Criteria andHotelManagerPhoneIn(List<String> values) {
            addCriterion("hotel_manager_phone in", values, "hotelManagerPhone");
            return (Criteria) this;
        }

        public Criteria andHotelManagerPhoneNotIn(List<String> values) {
            addCriterion("hotel_manager_phone not in", values, "hotelManagerPhone");
            return (Criteria) this;
        }

        public Criteria andHotelManagerPhoneBetween(String value1, String value2) {
            addCriterion("hotel_manager_phone between", value1, value2, "hotelManagerPhone");
            return (Criteria) this;
        }

        public Criteria andHotelManagerPhoneNotBetween(String value1, String value2) {
            addCriterion("hotel_manager_phone not between", value1, value2, "hotelManagerPhone");
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