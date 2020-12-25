package com.LiteTravel.web.Model;

import java.util.ArrayList;
import java.util.List;

public class RoomExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RoomExample() {
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

        public Criteria andRoomIdIsNull() {
            addCriterion("room_id is null");
            return (Criteria) this;
        }

        public Criteria andRoomIdIsNotNull() {
            addCriterion("room_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoomIdEqualTo(Integer value) {
            addCriterion("room_id =", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotEqualTo(Integer value) {
            addCriterion("room_id <>", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdGreaterThan(Integer value) {
            addCriterion("room_id >", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("room_id >=", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLessThan(Integer value) {
            addCriterion("room_id <", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLessThanOrEqualTo(Integer value) {
            addCriterion("room_id <=", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdIn(List<Integer> values) {
            addCriterion("room_id in", values, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotIn(List<Integer> values) {
            addCriterion("room_id not in", values, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdBetween(Integer value1, Integer value2) {
            addCriterion("room_id between", value1, value2, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotBetween(Integer value1, Integer value2) {
            addCriterion("room_id not between", value1, value2, "roomId");
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

        public Criteria andRoomNameIsNull() {
            addCriterion("room_name is null");
            return (Criteria) this;
        }

        public Criteria andRoomNameIsNotNull() {
            addCriterion("room_name is not null");
            return (Criteria) this;
        }

        public Criteria andRoomNameEqualTo(String value) {
            addCriterion("room_name =", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameNotEqualTo(String value) {
            addCriterion("room_name <>", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameGreaterThan(String value) {
            addCriterion("room_name >", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameGreaterThanOrEqualTo(String value) {
            addCriterion("room_name >=", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameLessThan(String value) {
            addCriterion("room_name <", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameLessThanOrEqualTo(String value) {
            addCriterion("room_name <=", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameLike(String value) {
            addCriterion("room_name like", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameNotLike(String value) {
            addCriterion("room_name not like", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameIn(List<String> values) {
            addCriterion("room_name in", values, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameNotIn(List<String> values) {
            addCriterion("room_name not in", values, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameBetween(String value1, String value2) {
            addCriterion("room_name between", value1, value2, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameNotBetween(String value1, String value2) {
            addCriterion("room_name not between", value1, value2, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomPriceIsNull() {
            addCriterion("room_price is null");
            return (Criteria) this;
        }

        public Criteria andRoomPriceIsNotNull() {
            addCriterion("room_price is not null");
            return (Criteria) this;
        }

        public Criteria andRoomPriceEqualTo(Float value) {
            addCriterion("room_price =", value, "roomPrice");
            return (Criteria) this;
        }

        public Criteria andRoomPriceNotEqualTo(Float value) {
            addCriterion("room_price <>", value, "roomPrice");
            return (Criteria) this;
        }

        public Criteria andRoomPriceGreaterThan(Float value) {
            addCriterion("room_price >", value, "roomPrice");
            return (Criteria) this;
        }

        public Criteria andRoomPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("room_price >=", value, "roomPrice");
            return (Criteria) this;
        }

        public Criteria andRoomPriceLessThan(Float value) {
            addCriterion("room_price <", value, "roomPrice");
            return (Criteria) this;
        }

        public Criteria andRoomPriceLessThanOrEqualTo(Float value) {
            addCriterion("room_price <=", value, "roomPrice");
            return (Criteria) this;
        }

        public Criteria andRoomPriceIn(List<Float> values) {
            addCriterion("room_price in", values, "roomPrice");
            return (Criteria) this;
        }

        public Criteria andRoomPriceNotIn(List<Float> values) {
            addCriterion("room_price not in", values, "roomPrice");
            return (Criteria) this;
        }

        public Criteria andRoomPriceBetween(Float value1, Float value2) {
            addCriterion("room_price between", value1, value2, "roomPrice");
            return (Criteria) this;
        }

        public Criteria andRoomPriceNotBetween(Float value1, Float value2) {
            addCriterion("room_price not between", value1, value2, "roomPrice");
            return (Criteria) this;
        }

        public Criteria andRoomRemainingIsNull() {
            addCriterion("room_remaining is null");
            return (Criteria) this;
        }

        public Criteria andRoomRemainingIsNotNull() {
            addCriterion("room_remaining is not null");
            return (Criteria) this;
        }

        public Criteria andRoomRemainingEqualTo(Integer value) {
            addCriterion("room_remaining =", value, "roomRemaining");
            return (Criteria) this;
        }

        public Criteria andRoomRemainingNotEqualTo(Integer value) {
            addCriterion("room_remaining <>", value, "roomRemaining");
            return (Criteria) this;
        }

        public Criteria andRoomRemainingGreaterThan(Integer value) {
            addCriterion("room_remaining >", value, "roomRemaining");
            return (Criteria) this;
        }

        public Criteria andRoomRemainingGreaterThanOrEqualTo(Integer value) {
            addCriterion("room_remaining >=", value, "roomRemaining");
            return (Criteria) this;
        }

        public Criteria andRoomRemainingLessThan(Integer value) {
            addCriterion("room_remaining <", value, "roomRemaining");
            return (Criteria) this;
        }

        public Criteria andRoomRemainingLessThanOrEqualTo(Integer value) {
            addCriterion("room_remaining <=", value, "roomRemaining");
            return (Criteria) this;
        }

        public Criteria andRoomRemainingIn(List<Integer> values) {
            addCriterion("room_remaining in", values, "roomRemaining");
            return (Criteria) this;
        }

        public Criteria andRoomRemainingNotIn(List<Integer> values) {
            addCriterion("room_remaining not in", values, "roomRemaining");
            return (Criteria) this;
        }

        public Criteria andRoomRemainingBetween(Integer value1, Integer value2) {
            addCriterion("room_remaining between", value1, value2, "roomRemaining");
            return (Criteria) this;
        }

        public Criteria andRoomRemainingNotBetween(Integer value1, Integer value2) {
            addCriterion("room_remaining not between", value1, value2, "roomRemaining");
            return (Criteria) this;
        }

        public Criteria andRoomMaxIsNull() {
            addCriterion("room_max is null");
            return (Criteria) this;
        }

        public Criteria andRoomMaxIsNotNull() {
            addCriterion("room_max is not null");
            return (Criteria) this;
        }

        public Criteria andRoomMaxEqualTo(Integer value) {
            addCriterion("room_max =", value, "roomMax");
            return (Criteria) this;
        }

        public Criteria andRoomMaxNotEqualTo(Integer value) {
            addCriterion("room_max <>", value, "roomMax");
            return (Criteria) this;
        }

        public Criteria andRoomMaxGreaterThan(Integer value) {
            addCriterion("room_max >", value, "roomMax");
            return (Criteria) this;
        }

        public Criteria andRoomMaxGreaterThanOrEqualTo(Integer value) {
            addCriterion("room_max >=", value, "roomMax");
            return (Criteria) this;
        }

        public Criteria andRoomMaxLessThan(Integer value) {
            addCriterion("room_max <", value, "roomMax");
            return (Criteria) this;
        }

        public Criteria andRoomMaxLessThanOrEqualTo(Integer value) {
            addCriterion("room_max <=", value, "roomMax");
            return (Criteria) this;
        }

        public Criteria andRoomMaxIn(List<Integer> values) {
            addCriterion("room_max in", values, "roomMax");
            return (Criteria) this;
        }

        public Criteria andRoomMaxNotIn(List<Integer> values) {
            addCriterion("room_max not in", values, "roomMax");
            return (Criteria) this;
        }

        public Criteria andRoomMaxBetween(Integer value1, Integer value2) {
            addCriterion("room_max between", value1, value2, "roomMax");
            return (Criteria) this;
        }

        public Criteria andRoomMaxNotBetween(Integer value1, Integer value2) {
            addCriterion("room_max not between", value1, value2, "roomMax");
            return (Criteria) this;
        }

        public Criteria andRoomBookMaxIsNull() {
            addCriterion("room_book_max is null");
            return (Criteria) this;
        }

        public Criteria andRoomBookMaxIsNotNull() {
            addCriterion("room_book_max is not null");
            return (Criteria) this;
        }

        public Criteria andRoomBookMaxEqualTo(Integer value) {
            addCriterion("room_book_max =", value, "roomBookMax");
            return (Criteria) this;
        }

        public Criteria andRoomBookMaxNotEqualTo(Integer value) {
            addCriterion("room_book_max <>", value, "roomBookMax");
            return (Criteria) this;
        }

        public Criteria andRoomBookMaxGreaterThan(Integer value) {
            addCriterion("room_book_max >", value, "roomBookMax");
            return (Criteria) this;
        }

        public Criteria andRoomBookMaxGreaterThanOrEqualTo(Integer value) {
            addCriterion("room_book_max >=", value, "roomBookMax");
            return (Criteria) this;
        }

        public Criteria andRoomBookMaxLessThan(Integer value) {
            addCriterion("room_book_max <", value, "roomBookMax");
            return (Criteria) this;
        }

        public Criteria andRoomBookMaxLessThanOrEqualTo(Integer value) {
            addCriterion("room_book_max <=", value, "roomBookMax");
            return (Criteria) this;
        }

        public Criteria andRoomBookMaxIn(List<Integer> values) {
            addCriterion("room_book_max in", values, "roomBookMax");
            return (Criteria) this;
        }

        public Criteria andRoomBookMaxNotIn(List<Integer> values) {
            addCriterion("room_book_max not in", values, "roomBookMax");
            return (Criteria) this;
        }

        public Criteria andRoomBookMaxBetween(Integer value1, Integer value2) {
            addCriterion("room_book_max between", value1, value2, "roomBookMax");
            return (Criteria) this;
        }

        public Criteria andRoomBookMaxNotBetween(Integer value1, Integer value2) {
            addCriterion("room_book_max not between", value1, value2, "roomBookMax");
            return (Criteria) this;
        }

        public Criteria andRoomCancelIsNull() {
            addCriterion("room_cancel is null");
            return (Criteria) this;
        }

        public Criteria andRoomCancelIsNotNull() {
            addCriterion("room_cancel is not null");
            return (Criteria) this;
        }

        public Criteria andRoomCancelEqualTo(Integer value) {
            addCriterion("room_cancel =", value, "roomCancel");
            return (Criteria) this;
        }

        public Criteria andRoomCancelNotEqualTo(Integer value) {
            addCriterion("room_cancel <>", value, "roomCancel");
            return (Criteria) this;
        }

        public Criteria andRoomCancelGreaterThan(Integer value) {
            addCriterion("room_cancel >", value, "roomCancel");
            return (Criteria) this;
        }

        public Criteria andRoomCancelGreaterThanOrEqualTo(Integer value) {
            addCriterion("room_cancel >=", value, "roomCancel");
            return (Criteria) this;
        }

        public Criteria andRoomCancelLessThan(Integer value) {
            addCriterion("room_cancel <", value, "roomCancel");
            return (Criteria) this;
        }

        public Criteria andRoomCancelLessThanOrEqualTo(Integer value) {
            addCriterion("room_cancel <=", value, "roomCancel");
            return (Criteria) this;
        }

        public Criteria andRoomCancelIn(List<Integer> values) {
            addCriterion("room_cancel in", values, "roomCancel");
            return (Criteria) this;
        }

        public Criteria andRoomCancelNotIn(List<Integer> values) {
            addCriterion("room_cancel not in", values, "roomCancel");
            return (Criteria) this;
        }

        public Criteria andRoomCancelBetween(Integer value1, Integer value2) {
            addCriterion("room_cancel between", value1, value2, "roomCancel");
            return (Criteria) this;
        }

        public Criteria andRoomCancelNotBetween(Integer value1, Integer value2) {
            addCriterion("room_cancel not between", value1, value2, "roomCancel");
            return (Criteria) this;
        }

        public Criteria andRoomSizeIsNull() {
            addCriterion("room_size is null");
            return (Criteria) this;
        }

        public Criteria andRoomSizeIsNotNull() {
            addCriterion("room_size is not null");
            return (Criteria) this;
        }

        public Criteria andRoomSizeEqualTo(Integer value) {
            addCriterion("room_size =", value, "roomSize");
            return (Criteria) this;
        }

        public Criteria andRoomSizeNotEqualTo(Integer value) {
            addCriterion("room_size <>", value, "roomSize");
            return (Criteria) this;
        }

        public Criteria andRoomSizeGreaterThan(Integer value) {
            addCriterion("room_size >", value, "roomSize");
            return (Criteria) this;
        }

        public Criteria andRoomSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("room_size >=", value, "roomSize");
            return (Criteria) this;
        }

        public Criteria andRoomSizeLessThan(Integer value) {
            addCriterion("room_size <", value, "roomSize");
            return (Criteria) this;
        }

        public Criteria andRoomSizeLessThanOrEqualTo(Integer value) {
            addCriterion("room_size <=", value, "roomSize");
            return (Criteria) this;
        }

        public Criteria andRoomSizeIn(List<Integer> values) {
            addCriterion("room_size in", values, "roomSize");
            return (Criteria) this;
        }

        public Criteria andRoomSizeNotIn(List<Integer> values) {
            addCriterion("room_size not in", values, "roomSize");
            return (Criteria) this;
        }

        public Criteria andRoomSizeBetween(Integer value1, Integer value2) {
            addCriterion("room_size between", value1, value2, "roomSize");
            return (Criteria) this;
        }

        public Criteria andRoomSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("room_size not between", value1, value2, "roomSize");
            return (Criteria) this;
        }

        public Criteria andRoomWifiIsNull() {
            addCriterion("room_wifi is null");
            return (Criteria) this;
        }

        public Criteria andRoomWifiIsNotNull() {
            addCriterion("room_wifi is not null");
            return (Criteria) this;
        }

        public Criteria andRoomWifiEqualTo(String value) {
            addCriterion("room_wifi =", value, "roomWifi");
            return (Criteria) this;
        }

        public Criteria andRoomWifiNotEqualTo(String value) {
            addCriterion("room_wifi <>", value, "roomWifi");
            return (Criteria) this;
        }

        public Criteria andRoomWifiGreaterThan(String value) {
            addCriterion("room_wifi >", value, "roomWifi");
            return (Criteria) this;
        }

        public Criteria andRoomWifiGreaterThanOrEqualTo(String value) {
            addCriterion("room_wifi >=", value, "roomWifi");
            return (Criteria) this;
        }

        public Criteria andRoomWifiLessThan(String value) {
            addCriterion("room_wifi <", value, "roomWifi");
            return (Criteria) this;
        }

        public Criteria andRoomWifiLessThanOrEqualTo(String value) {
            addCriterion("room_wifi <=", value, "roomWifi");
            return (Criteria) this;
        }

        public Criteria andRoomWifiLike(String value) {
            addCriterion("room_wifi like", value, "roomWifi");
            return (Criteria) this;
        }

        public Criteria andRoomWifiNotLike(String value) {
            addCriterion("room_wifi not like", value, "roomWifi");
            return (Criteria) this;
        }

        public Criteria andRoomWifiIn(List<String> values) {
            addCriterion("room_wifi in", values, "roomWifi");
            return (Criteria) this;
        }

        public Criteria andRoomWifiNotIn(List<String> values) {
            addCriterion("room_wifi not in", values, "roomWifi");
            return (Criteria) this;
        }

        public Criteria andRoomWifiBetween(String value1, String value2) {
            addCriterion("room_wifi between", value1, value2, "roomWifi");
            return (Criteria) this;
        }

        public Criteria andRoomWifiNotBetween(String value1, String value2) {
            addCriterion("room_wifi not between", value1, value2, "roomWifi");
            return (Criteria) this;
        }

        public Criteria andRoomBedAddIsNull() {
            addCriterion("room_bed_add is null");
            return (Criteria) this;
        }

        public Criteria andRoomBedAddIsNotNull() {
            addCriterion("room_bed_add is not null");
            return (Criteria) this;
        }

        public Criteria andRoomBedAddEqualTo(Float value) {
            addCriterion("room_bed_add =", value, "roomBedAdd");
            return (Criteria) this;
        }

        public Criteria andRoomBedAddNotEqualTo(Float value) {
            addCriterion("room_bed_add <>", value, "roomBedAdd");
            return (Criteria) this;
        }

        public Criteria andRoomBedAddGreaterThan(Float value) {
            addCriterion("room_bed_add >", value, "roomBedAdd");
            return (Criteria) this;
        }

        public Criteria andRoomBedAddGreaterThanOrEqualTo(Float value) {
            addCriterion("room_bed_add >=", value, "roomBedAdd");
            return (Criteria) this;
        }

        public Criteria andRoomBedAddLessThan(Float value) {
            addCriterion("room_bed_add <", value, "roomBedAdd");
            return (Criteria) this;
        }

        public Criteria andRoomBedAddLessThanOrEqualTo(Float value) {
            addCriterion("room_bed_add <=", value, "roomBedAdd");
            return (Criteria) this;
        }

        public Criteria andRoomBedAddIn(List<Float> values) {
            addCriterion("room_bed_add in", values, "roomBedAdd");
            return (Criteria) this;
        }

        public Criteria andRoomBedAddNotIn(List<Float> values) {
            addCriterion("room_bed_add not in", values, "roomBedAdd");
            return (Criteria) this;
        }

        public Criteria andRoomBedAddBetween(Float value1, Float value2) {
            addCriterion("room_bed_add between", value1, value2, "roomBedAdd");
            return (Criteria) this;
        }

        public Criteria andRoomBedAddNotBetween(Float value1, Float value2) {
            addCriterion("room_bed_add not between", value1, value2, "roomBedAdd");
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