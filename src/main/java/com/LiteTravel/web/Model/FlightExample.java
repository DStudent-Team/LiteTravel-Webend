package com.LiteTravel.web.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FlightExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FlightExample() {
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

        public Criteria andFlightIdIsNull() {
            addCriterion("flight_id is null");
            return (Criteria) this;
        }

        public Criteria andFlightIdIsNotNull() {
            addCriterion("flight_id is not null");
            return (Criteria) this;
        }

        public Criteria andFlightIdEqualTo(Integer value) {
            addCriterion("flight_id =", value, "flightId");
            return (Criteria) this;
        }

        public Criteria andFlightIdNotEqualTo(Integer value) {
            addCriterion("flight_id <>", value, "flightId");
            return (Criteria) this;
        }

        public Criteria andFlightIdGreaterThan(Integer value) {
            addCriterion("flight_id >", value, "flightId");
            return (Criteria) this;
        }

        public Criteria andFlightIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("flight_id >=", value, "flightId");
            return (Criteria) this;
        }

        public Criteria andFlightIdLessThan(Integer value) {
            addCriterion("flight_id <", value, "flightId");
            return (Criteria) this;
        }

        public Criteria andFlightIdLessThanOrEqualTo(Integer value) {
            addCriterion("flight_id <=", value, "flightId");
            return (Criteria) this;
        }

        public Criteria andFlightIdIn(List<Integer> values) {
            addCriterion("flight_id in", values, "flightId");
            return (Criteria) this;
        }

        public Criteria andFlightIdNotIn(List<Integer> values) {
            addCriterion("flight_id not in", values, "flightId");
            return (Criteria) this;
        }

        public Criteria andFlightIdBetween(Integer value1, Integer value2) {
            addCriterion("flight_id between", value1, value2, "flightId");
            return (Criteria) this;
        }

        public Criteria andFlightIdNotBetween(Integer value1, Integer value2) {
            addCriterion("flight_id not between", value1, value2, "flightId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andFlightLevelIsNull() {
            addCriterion("flight_level is null");
            return (Criteria) this;
        }

        public Criteria andFlightLevelIsNotNull() {
            addCriterion("flight_level is not null");
            return (Criteria) this;
        }

        public Criteria andFlightLevelEqualTo(Integer value) {
            addCriterion("flight_level =", value, "flightLevel");
            return (Criteria) this;
        }

        public Criteria andFlightLevelNotEqualTo(Integer value) {
            addCriterion("flight_level <>", value, "flightLevel");
            return (Criteria) this;
        }

        public Criteria andFlightLevelGreaterThan(Integer value) {
            addCriterion("flight_level >", value, "flightLevel");
            return (Criteria) this;
        }

        public Criteria andFlightLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("flight_level >=", value, "flightLevel");
            return (Criteria) this;
        }

        public Criteria andFlightLevelLessThan(Integer value) {
            addCriterion("flight_level <", value, "flightLevel");
            return (Criteria) this;
        }

        public Criteria andFlightLevelLessThanOrEqualTo(Integer value) {
            addCriterion("flight_level <=", value, "flightLevel");
            return (Criteria) this;
        }

        public Criteria andFlightLevelIn(List<Integer> values) {
            addCriterion("flight_level in", values, "flightLevel");
            return (Criteria) this;
        }

        public Criteria andFlightLevelNotIn(List<Integer> values) {
            addCriterion("flight_level not in", values, "flightLevel");
            return (Criteria) this;
        }

        public Criteria andFlightLevelBetween(Integer value1, Integer value2) {
            addCriterion("flight_level between", value1, value2, "flightLevel");
            return (Criteria) this;
        }

        public Criteria andFlightLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("flight_level not between", value1, value2, "flightLevel");
            return (Criteria) this;
        }

        public Criteria andFlightFromIsNull() {
            addCriterion("flight_from is null");
            return (Criteria) this;
        }

        public Criteria andFlightFromIsNotNull() {
            addCriterion("flight_from is not null");
            return (Criteria) this;
        }

        public Criteria andFlightFromEqualTo(Integer value) {
            addCriterion("flight_from =", value, "flightFrom");
            return (Criteria) this;
        }

        public Criteria andFlightFromNotEqualTo(Integer value) {
            addCriterion("flight_from <>", value, "flightFrom");
            return (Criteria) this;
        }

        public Criteria andFlightFromGreaterThan(Integer value) {
            addCriterion("flight_from >", value, "flightFrom");
            return (Criteria) this;
        }

        public Criteria andFlightFromGreaterThanOrEqualTo(Integer value) {
            addCriterion("flight_from >=", value, "flightFrom");
            return (Criteria) this;
        }

        public Criteria andFlightFromLessThan(Integer value) {
            addCriterion("flight_from <", value, "flightFrom");
            return (Criteria) this;
        }

        public Criteria andFlightFromLessThanOrEqualTo(Integer value) {
            addCriterion("flight_from <=", value, "flightFrom");
            return (Criteria) this;
        }

        public Criteria andFlightFromIn(List<Integer> values) {
            addCriterion("flight_from in", values, "flightFrom");
            return (Criteria) this;
        }

        public Criteria andFlightFromNotIn(List<Integer> values) {
            addCriterion("flight_from not in", values, "flightFrom");
            return (Criteria) this;
        }

        public Criteria andFlightFromBetween(Integer value1, Integer value2) {
            addCriterion("flight_from between", value1, value2, "flightFrom");
            return (Criteria) this;
        }

        public Criteria andFlightFromNotBetween(Integer value1, Integer value2) {
            addCriterion("flight_from not between", value1, value2, "flightFrom");
            return (Criteria) this;
        }

        public Criteria andFlightToIsNull() {
            addCriterion("flight_to is null");
            return (Criteria) this;
        }

        public Criteria andFlightToIsNotNull() {
            addCriterion("flight_to is not null");
            return (Criteria) this;
        }

        public Criteria andFlightToEqualTo(Integer value) {
            addCriterion("flight_to =", value, "flightTo");
            return (Criteria) this;
        }

        public Criteria andFlightToNotEqualTo(Integer value) {
            addCriterion("flight_to <>", value, "flightTo");
            return (Criteria) this;
        }

        public Criteria andFlightToGreaterThan(Integer value) {
            addCriterion("flight_to >", value, "flightTo");
            return (Criteria) this;
        }

        public Criteria andFlightToGreaterThanOrEqualTo(Integer value) {
            addCriterion("flight_to >=", value, "flightTo");
            return (Criteria) this;
        }

        public Criteria andFlightToLessThan(Integer value) {
            addCriterion("flight_to <", value, "flightTo");
            return (Criteria) this;
        }

        public Criteria andFlightToLessThanOrEqualTo(Integer value) {
            addCriterion("flight_to <=", value, "flightTo");
            return (Criteria) this;
        }

        public Criteria andFlightToIn(List<Integer> values) {
            addCriterion("flight_to in", values, "flightTo");
            return (Criteria) this;
        }

        public Criteria andFlightToNotIn(List<Integer> values) {
            addCriterion("flight_to not in", values, "flightTo");
            return (Criteria) this;
        }

        public Criteria andFlightToBetween(Integer value1, Integer value2) {
            addCriterion("flight_to between", value1, value2, "flightTo");
            return (Criteria) this;
        }

        public Criteria andFlightToNotBetween(Integer value1, Integer value2) {
            addCriterion("flight_to not between", value1, value2, "flightTo");
            return (Criteria) this;
        }

        public Criteria andFlightDepartIsNull() {
            addCriterion("flight_depart is null");
            return (Criteria) this;
        }

        public Criteria andFlightDepartIsNotNull() {
            addCriterion("flight_depart is not null");
            return (Criteria) this;
        }

        public Criteria andFlightDepartEqualTo(Date value) {
            addCriterion("flight_depart =", value, "flightDepart");
            return (Criteria) this;
        }

        public Criteria andFlightDepartNotEqualTo(Date value) {
            addCriterion("flight_depart <>", value, "flightDepart");
            return (Criteria) this;
        }

        public Criteria andFlightDepartGreaterThan(Date value) {
            addCriterion("flight_depart >", value, "flightDepart");
            return (Criteria) this;
        }

        public Criteria andFlightDepartGreaterThanOrEqualTo(Date value) {
            addCriterion("flight_depart >=", value, "flightDepart");
            return (Criteria) this;
        }

        public Criteria andFlightDepartLessThan(Date value) {
            addCriterion("flight_depart <", value, "flightDepart");
            return (Criteria) this;
        }

        public Criteria andFlightDepartLessThanOrEqualTo(Date value) {
            addCriterion("flight_depart <=", value, "flightDepart");
            return (Criteria) this;
        }

        public Criteria andFlightDepartIn(List<Date> values) {
            addCriterion("flight_depart in", values, "flightDepart");
            return (Criteria) this;
        }

        public Criteria andFlightDepartNotIn(List<Date> values) {
            addCriterion("flight_depart not in", values, "flightDepart");
            return (Criteria) this;
        }

        public Criteria andFlightDepartBetween(Date value1, Date value2) {
            addCriterion("flight_depart between", value1, value2, "flightDepart");
            return (Criteria) this;
        }

        public Criteria andFlightDepartNotBetween(Date value1, Date value2) {
            addCriterion("flight_depart not between", value1, value2, "flightDepart");
            return (Criteria) this;
        }

        public Criteria andFlightArrivedIsNull() {
            addCriterion("flight_arrived is null");
            return (Criteria) this;
        }

        public Criteria andFlightArrivedIsNotNull() {
            addCriterion("flight_arrived is not null");
            return (Criteria) this;
        }

        public Criteria andFlightArrivedEqualTo(Date value) {
            addCriterion("flight_arrived =", value, "flightArrived");
            return (Criteria) this;
        }

        public Criteria andFlightArrivedNotEqualTo(Date value) {
            addCriterion("flight_arrived <>", value, "flightArrived");
            return (Criteria) this;
        }

        public Criteria andFlightArrivedGreaterThan(Date value) {
            addCriterion("flight_arrived >", value, "flightArrived");
            return (Criteria) this;
        }

        public Criteria andFlightArrivedGreaterThanOrEqualTo(Date value) {
            addCriterion("flight_arrived >=", value, "flightArrived");
            return (Criteria) this;
        }

        public Criteria andFlightArrivedLessThan(Date value) {
            addCriterion("flight_arrived <", value, "flightArrived");
            return (Criteria) this;
        }

        public Criteria andFlightArrivedLessThanOrEqualTo(Date value) {
            addCriterion("flight_arrived <=", value, "flightArrived");
            return (Criteria) this;
        }

        public Criteria andFlightArrivedIn(List<Date> values) {
            addCriterion("flight_arrived in", values, "flightArrived");
            return (Criteria) this;
        }

        public Criteria andFlightArrivedNotIn(List<Date> values) {
            addCriterion("flight_arrived not in", values, "flightArrived");
            return (Criteria) this;
        }

        public Criteria andFlightArrivedBetween(Date value1, Date value2) {
            addCriterion("flight_arrived between", value1, value2, "flightArrived");
            return (Criteria) this;
        }

        public Criteria andFlightArrivedNotBetween(Date value1, Date value2) {
            addCriterion("flight_arrived not between", value1, value2, "flightArrived");
            return (Criteria) this;
        }

        public Criteria andFlightTotalIsNull() {
            addCriterion("flight_total is null");
            return (Criteria) this;
        }

        public Criteria andFlightTotalIsNotNull() {
            addCriterion("flight_total is not null");
            return (Criteria) this;
        }

        public Criteria andFlightTotalEqualTo(Float value) {
            addCriterion("flight_total =", value, "flightTotal");
            return (Criteria) this;
        }

        public Criteria andFlightTotalNotEqualTo(Float value) {
            addCriterion("flight_total <>", value, "flightTotal");
            return (Criteria) this;
        }

        public Criteria andFlightTotalGreaterThan(Float value) {
            addCriterion("flight_total >", value, "flightTotal");
            return (Criteria) this;
        }

        public Criteria andFlightTotalGreaterThanOrEqualTo(Float value) {
            addCriterion("flight_total >=", value, "flightTotal");
            return (Criteria) this;
        }

        public Criteria andFlightTotalLessThan(Float value) {
            addCriterion("flight_total <", value, "flightTotal");
            return (Criteria) this;
        }

        public Criteria andFlightTotalLessThanOrEqualTo(Float value) {
            addCriterion("flight_total <=", value, "flightTotal");
            return (Criteria) this;
        }

        public Criteria andFlightTotalIn(List<Float> values) {
            addCriterion("flight_total in", values, "flightTotal");
            return (Criteria) this;
        }

        public Criteria andFlightTotalNotIn(List<Float> values) {
            addCriterion("flight_total not in", values, "flightTotal");
            return (Criteria) this;
        }

        public Criteria andFlightTotalBetween(Float value1, Float value2) {
            addCriterion("flight_total between", value1, value2, "flightTotal");
            return (Criteria) this;
        }

        public Criteria andFlightTotalNotBetween(Float value1, Float value2) {
            addCriterion("flight_total not between", value1, value2, "flightTotal");
            return (Criteria) this;
        }

        public Criteria andFlightSeatsIsNull() {
            addCriterion("flight_seats is null");
            return (Criteria) this;
        }

        public Criteria andFlightSeatsIsNotNull() {
            addCriterion("flight_seats is not null");
            return (Criteria) this;
        }

        public Criteria andFlightSeatsEqualTo(Integer value) {
            addCriterion("flight_seats =", value, "flightSeats");
            return (Criteria) this;
        }

        public Criteria andFlightSeatsNotEqualTo(Integer value) {
            addCriterion("flight_seats <>", value, "flightSeats");
            return (Criteria) this;
        }

        public Criteria andFlightSeatsGreaterThan(Integer value) {
            addCriterion("flight_seats >", value, "flightSeats");
            return (Criteria) this;
        }

        public Criteria andFlightSeatsGreaterThanOrEqualTo(Integer value) {
            addCriterion("flight_seats >=", value, "flightSeats");
            return (Criteria) this;
        }

        public Criteria andFlightSeatsLessThan(Integer value) {
            addCriterion("flight_seats <", value, "flightSeats");
            return (Criteria) this;
        }

        public Criteria andFlightSeatsLessThanOrEqualTo(Integer value) {
            addCriterion("flight_seats <=", value, "flightSeats");
            return (Criteria) this;
        }

        public Criteria andFlightSeatsIn(List<Integer> values) {
            addCriterion("flight_seats in", values, "flightSeats");
            return (Criteria) this;
        }

        public Criteria andFlightSeatsNotIn(List<Integer> values) {
            addCriterion("flight_seats not in", values, "flightSeats");
            return (Criteria) this;
        }

        public Criteria andFlightSeatsBetween(Integer value1, Integer value2) {
            addCriterion("flight_seats between", value1, value2, "flightSeats");
            return (Criteria) this;
        }

        public Criteria andFlightSeatsNotBetween(Integer value1, Integer value2) {
            addCriterion("flight_seats not between", value1, value2, "flightSeats");
            return (Criteria) this;
        }

        public Criteria andFlightStatusIsNull() {
            addCriterion("flight_status is null");
            return (Criteria) this;
        }

        public Criteria andFlightStatusIsNotNull() {
            addCriterion("flight_status is not null");
            return (Criteria) this;
        }

        public Criteria andFlightStatusEqualTo(Integer value) {
            addCriterion("flight_status =", value, "flightStatus");
            return (Criteria) this;
        }

        public Criteria andFlightStatusNotEqualTo(Integer value) {
            addCriterion("flight_status <>", value, "flightStatus");
            return (Criteria) this;
        }

        public Criteria andFlightStatusGreaterThan(Integer value) {
            addCriterion("flight_status >", value, "flightStatus");
            return (Criteria) this;
        }

        public Criteria andFlightStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("flight_status >=", value, "flightStatus");
            return (Criteria) this;
        }

        public Criteria andFlightStatusLessThan(Integer value) {
            addCriterion("flight_status <", value, "flightStatus");
            return (Criteria) this;
        }

        public Criteria andFlightStatusLessThanOrEqualTo(Integer value) {
            addCriterion("flight_status <=", value, "flightStatus");
            return (Criteria) this;
        }

        public Criteria andFlightStatusIn(List<Integer> values) {
            addCriterion("flight_status in", values, "flightStatus");
            return (Criteria) this;
        }

        public Criteria andFlightStatusNotIn(List<Integer> values) {
            addCriterion("flight_status not in", values, "flightStatus");
            return (Criteria) this;
        }

        public Criteria andFlightStatusBetween(Integer value1, Integer value2) {
            addCriterion("flight_status between", value1, value2, "flightStatus");
            return (Criteria) this;
        }

        public Criteria andFlightStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("flight_status not between", value1, value2, "flightStatus");
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