package net.monitor.dao.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TrafficMonitorDTOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public TrafficMonitorDTOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
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

    public Integer getLimitStart() {
        return limitStart;
    }

    public void setLimitStart(Integer limitStart) {
        this.limitStart = limitStart;
    }

    public Integer getLimitEnd() {
        return limitEnd;
    }

    public void setLimitEnd(Integer limitEnd) {
        this.limitEnd = limitEnd;
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIpIsNull() {
            addCriterion("ip is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("ip is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("ip =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("ip <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("ip >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("ip >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("ip <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("ip <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("ip like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("ip not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("ip in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("ip not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("ip between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("ip not between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andNetworkCardNameIsNull() {
            addCriterion("network_card_name is null");
            return (Criteria) this;
        }

        public Criteria andNetworkCardNameIsNotNull() {
            addCriterion("network_card_name is not null");
            return (Criteria) this;
        }

        public Criteria andNetworkCardNameEqualTo(String value) {
            addCriterion("network_card_name =", value, "networkCardName");
            return (Criteria) this;
        }

        public Criteria andNetworkCardNameNotEqualTo(String value) {
            addCriterion("network_card_name <>", value, "networkCardName");
            return (Criteria) this;
        }

        public Criteria andNetworkCardNameGreaterThan(String value) {
            addCriterion("network_card_name >", value, "networkCardName");
            return (Criteria) this;
        }

        public Criteria andNetworkCardNameGreaterThanOrEqualTo(String value) {
            addCriterion("network_card_name >=", value, "networkCardName");
            return (Criteria) this;
        }

        public Criteria andNetworkCardNameLessThan(String value) {
            addCriterion("network_card_name <", value, "networkCardName");
            return (Criteria) this;
        }

        public Criteria andNetworkCardNameLessThanOrEqualTo(String value) {
            addCriterion("network_card_name <=", value, "networkCardName");
            return (Criteria) this;
        }

        public Criteria andNetworkCardNameLike(String value) {
            addCriterion("network_card_name like", value, "networkCardName");
            return (Criteria) this;
        }

        public Criteria andNetworkCardNameNotLike(String value) {
            addCriterion("network_card_name not like", value, "networkCardName");
            return (Criteria) this;
        }

        public Criteria andNetworkCardNameIn(List<String> values) {
            addCriterion("network_card_name in", values, "networkCardName");
            return (Criteria) this;
        }

        public Criteria andNetworkCardNameNotIn(List<String> values) {
            addCriterion("network_card_name not in", values, "networkCardName");
            return (Criteria) this;
        }

        public Criteria andNetworkCardNameBetween(String value1, String value2) {
            addCriterion("network_card_name between", value1, value2, "networkCardName");
            return (Criteria) this;
        }

        public Criteria andNetworkCardNameNotBetween(String value1, String value2) {
            addCriterion("network_card_name not between", value1, value2, "networkCardName");
            return (Criteria) this;
        }

        public Criteria andReceiveTrafficIsNull() {
            addCriterion("receive_traffic is null");
            return (Criteria) this;
        }

        public Criteria andReceiveTrafficIsNotNull() {
            addCriterion("receive_traffic is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveTrafficEqualTo(Float value) {
            addCriterion("receive_traffic =", value, "receiveTraffic");
            return (Criteria) this;
        }

        public Criteria andReceiveTrafficNotEqualTo(Float value) {
            addCriterion("receive_traffic <>", value, "receiveTraffic");
            return (Criteria) this;
        }

        public Criteria andReceiveTrafficGreaterThan(Float value) {
            addCriterion("receive_traffic >", value, "receiveTraffic");
            return (Criteria) this;
        }

        public Criteria andReceiveTrafficGreaterThanOrEqualTo(Float value) {
            addCriterion("receive_traffic >=", value, "receiveTraffic");
            return (Criteria) this;
        }

        public Criteria andReceiveTrafficLessThan(Float value) {
            addCriterion("receive_traffic <", value, "receiveTraffic");
            return (Criteria) this;
        }

        public Criteria andReceiveTrafficLessThanOrEqualTo(Float value) {
            addCriterion("receive_traffic <=", value, "receiveTraffic");
            return (Criteria) this;
        }

        public Criteria andReceiveTrafficIn(List<Float> values) {
            addCriterion("receive_traffic in", values, "receiveTraffic");
            return (Criteria) this;
        }

        public Criteria andReceiveTrafficNotIn(List<Float> values) {
            addCriterion("receive_traffic not in", values, "receiveTraffic");
            return (Criteria) this;
        }

        public Criteria andReceiveTrafficBetween(Float value1, Float value2) {
            addCriterion("receive_traffic between", value1, value2, "receiveTraffic");
            return (Criteria) this;
        }

        public Criteria andReceiveTrafficNotBetween(Float value1, Float value2) {
            addCriterion("receive_traffic not between", value1, value2, "receiveTraffic");
            return (Criteria) this;
        }

        public Criteria andReceivePacketsIsNull() {
            addCriterion("receive_packets is null");
            return (Criteria) this;
        }

        public Criteria andReceivePacketsIsNotNull() {
            addCriterion("receive_packets is not null");
            return (Criteria) this;
        }

        public Criteria andReceivePacketsEqualTo(Float value) {
            addCriterion("receive_packets =", value, "receivePackets");
            return (Criteria) this;
        }

        public Criteria andReceivePacketsNotEqualTo(Float value) {
            addCriterion("receive_packets <>", value, "receivePackets");
            return (Criteria) this;
        }

        public Criteria andReceivePacketsGreaterThan(Float value) {
            addCriterion("receive_packets >", value, "receivePackets");
            return (Criteria) this;
        }

        public Criteria andReceivePacketsGreaterThanOrEqualTo(Float value) {
            addCriterion("receive_packets >=", value, "receivePackets");
            return (Criteria) this;
        }

        public Criteria andReceivePacketsLessThan(Float value) {
            addCriterion("receive_packets <", value, "receivePackets");
            return (Criteria) this;
        }

        public Criteria andReceivePacketsLessThanOrEqualTo(Float value) {
            addCriterion("receive_packets <=", value, "receivePackets");
            return (Criteria) this;
        }

        public Criteria andReceivePacketsIn(List<Float> values) {
            addCriterion("receive_packets in", values, "receivePackets");
            return (Criteria) this;
        }

        public Criteria andReceivePacketsNotIn(List<Float> values) {
            addCriterion("receive_packets not in", values, "receivePackets");
            return (Criteria) this;
        }

        public Criteria andReceivePacketsBetween(Float value1, Float value2) {
            addCriterion("receive_packets between", value1, value2, "receivePackets");
            return (Criteria) this;
        }

        public Criteria andReceivePacketsNotBetween(Float value1, Float value2) {
            addCriterion("receive_packets not between", value1, value2, "receivePackets");
            return (Criteria) this;
        }

        public Criteria andReceiveErrsIsNull() {
            addCriterion("receive_errs is null");
            return (Criteria) this;
        }

        public Criteria andReceiveErrsIsNotNull() {
            addCriterion("receive_errs is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveErrsEqualTo(Float value) {
            addCriterion("receive_errs =", value, "receiveErrs");
            return (Criteria) this;
        }

        public Criteria andReceiveErrsNotEqualTo(Float value) {
            addCriterion("receive_errs <>", value, "receiveErrs");
            return (Criteria) this;
        }

        public Criteria andReceiveErrsGreaterThan(Float value) {
            addCriterion("receive_errs >", value, "receiveErrs");
            return (Criteria) this;
        }

        public Criteria andReceiveErrsGreaterThanOrEqualTo(Float value) {
            addCriterion("receive_errs >=", value, "receiveErrs");
            return (Criteria) this;
        }

        public Criteria andReceiveErrsLessThan(Float value) {
            addCriterion("receive_errs <", value, "receiveErrs");
            return (Criteria) this;
        }

        public Criteria andReceiveErrsLessThanOrEqualTo(Float value) {
            addCriterion("receive_errs <=", value, "receiveErrs");
            return (Criteria) this;
        }

        public Criteria andReceiveErrsIn(List<Float> values) {
            addCriterion("receive_errs in", values, "receiveErrs");
            return (Criteria) this;
        }

        public Criteria andReceiveErrsNotIn(List<Float> values) {
            addCriterion("receive_errs not in", values, "receiveErrs");
            return (Criteria) this;
        }

        public Criteria andReceiveErrsBetween(Float value1, Float value2) {
            addCriterion("receive_errs between", value1, value2, "receiveErrs");
            return (Criteria) this;
        }

        public Criteria andReceiveErrsNotBetween(Float value1, Float value2) {
            addCriterion("receive_errs not between", value1, value2, "receiveErrs");
            return (Criteria) this;
        }

        public Criteria andTransmitTrafficIsNull() {
            addCriterion("transmit_traffic is null");
            return (Criteria) this;
        }

        public Criteria andTransmitTrafficIsNotNull() {
            addCriterion("transmit_traffic is not null");
            return (Criteria) this;
        }

        public Criteria andTransmitTrafficEqualTo(Float value) {
            addCriterion("transmit_traffic =", value, "transmitTraffic");
            return (Criteria) this;
        }

        public Criteria andTransmitTrafficNotEqualTo(Float value) {
            addCriterion("transmit_traffic <>", value, "transmitTraffic");
            return (Criteria) this;
        }

        public Criteria andTransmitTrafficGreaterThan(Float value) {
            addCriterion("transmit_traffic >", value, "transmitTraffic");
            return (Criteria) this;
        }

        public Criteria andTransmitTrafficGreaterThanOrEqualTo(Float value) {
            addCriterion("transmit_traffic >=", value, "transmitTraffic");
            return (Criteria) this;
        }

        public Criteria andTransmitTrafficLessThan(Float value) {
            addCriterion("transmit_traffic <", value, "transmitTraffic");
            return (Criteria) this;
        }

        public Criteria andTransmitTrafficLessThanOrEqualTo(Float value) {
            addCriterion("transmit_traffic <=", value, "transmitTraffic");
            return (Criteria) this;
        }

        public Criteria andTransmitTrafficIn(List<Float> values) {
            addCriterion("transmit_traffic in", values, "transmitTraffic");
            return (Criteria) this;
        }

        public Criteria andTransmitTrafficNotIn(List<Float> values) {
            addCriterion("transmit_traffic not in", values, "transmitTraffic");
            return (Criteria) this;
        }

        public Criteria andTransmitTrafficBetween(Float value1, Float value2) {
            addCriterion("transmit_traffic between", value1, value2, "transmitTraffic");
            return (Criteria) this;
        }

        public Criteria andTransmitTrafficNotBetween(Float value1, Float value2) {
            addCriterion("transmit_traffic not between", value1, value2, "transmitTraffic");
            return (Criteria) this;
        }

        public Criteria andTransmitPacketsIsNull() {
            addCriterion("transmit_packets is null");
            return (Criteria) this;
        }

        public Criteria andTransmitPacketsIsNotNull() {
            addCriterion("transmit_packets is not null");
            return (Criteria) this;
        }

        public Criteria andTransmitPacketsEqualTo(Float value) {
            addCriterion("transmit_packets =", value, "transmitPackets");
            return (Criteria) this;
        }

        public Criteria andTransmitPacketsNotEqualTo(Float value) {
            addCriterion("transmit_packets <>", value, "transmitPackets");
            return (Criteria) this;
        }

        public Criteria andTransmitPacketsGreaterThan(Float value) {
            addCriterion("transmit_packets >", value, "transmitPackets");
            return (Criteria) this;
        }

        public Criteria andTransmitPacketsGreaterThanOrEqualTo(Float value) {
            addCriterion("transmit_packets >=", value, "transmitPackets");
            return (Criteria) this;
        }

        public Criteria andTransmitPacketsLessThan(Float value) {
            addCriterion("transmit_packets <", value, "transmitPackets");
            return (Criteria) this;
        }

        public Criteria andTransmitPacketsLessThanOrEqualTo(Float value) {
            addCriterion("transmit_packets <=", value, "transmitPackets");
            return (Criteria) this;
        }

        public Criteria andTransmitPacketsIn(List<Float> values) {
            addCriterion("transmit_packets in", values, "transmitPackets");
            return (Criteria) this;
        }

        public Criteria andTransmitPacketsNotIn(List<Float> values) {
            addCriterion("transmit_packets not in", values, "transmitPackets");
            return (Criteria) this;
        }

        public Criteria andTransmitPacketsBetween(Float value1, Float value2) {
            addCriterion("transmit_packets between", value1, value2, "transmitPackets");
            return (Criteria) this;
        }

        public Criteria andTransmitPacketsNotBetween(Float value1, Float value2) {
            addCriterion("transmit_packets not between", value1, value2, "transmitPackets");
            return (Criteria) this;
        }

        public Criteria andTransmitErrsIsNull() {
            addCriterion("transmit_errs is null");
            return (Criteria) this;
        }

        public Criteria andTransmitErrsIsNotNull() {
            addCriterion("transmit_errs is not null");
            return (Criteria) this;
        }

        public Criteria andTransmitErrsEqualTo(Float value) {
            addCriterion("transmit_errs =", value, "transmitErrs");
            return (Criteria) this;
        }

        public Criteria andTransmitErrsNotEqualTo(Float value) {
            addCriterion("transmit_errs <>", value, "transmitErrs");
            return (Criteria) this;
        }

        public Criteria andTransmitErrsGreaterThan(Float value) {
            addCriterion("transmit_errs >", value, "transmitErrs");
            return (Criteria) this;
        }

        public Criteria andTransmitErrsGreaterThanOrEqualTo(Float value) {
            addCriterion("transmit_errs >=", value, "transmitErrs");
            return (Criteria) this;
        }

        public Criteria andTransmitErrsLessThan(Float value) {
            addCriterion("transmit_errs <", value, "transmitErrs");
            return (Criteria) this;
        }

        public Criteria andTransmitErrsLessThanOrEqualTo(Float value) {
            addCriterion("transmit_errs <=", value, "transmitErrs");
            return (Criteria) this;
        }

        public Criteria andTransmitErrsIn(List<Float> values) {
            addCriterion("transmit_errs in", values, "transmitErrs");
            return (Criteria) this;
        }

        public Criteria andTransmitErrsNotIn(List<Float> values) {
            addCriterion("transmit_errs not in", values, "transmitErrs");
            return (Criteria) this;
        }

        public Criteria andTransmitErrsBetween(Float value1, Float value2) {
            addCriterion("transmit_errs between", value1, value2, "transmitErrs");
            return (Criteria) this;
        }

        public Criteria andTransmitErrsNotBetween(Float value1, Float value2) {
            addCriterion("transmit_errs not between", value1, value2, "transmitErrs");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNull() {
            addCriterion("gmt_create is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNotNull() {
            addCriterion("gmt_create is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateEqualTo(Date value) {
            addCriterion("gmt_create =", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(Date value) {
            addCriterion("gmt_create <>", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThan(Date value) {
            addCriterion("gmt_create >", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_create >=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(Date value) {
            addCriterion("gmt_create <", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            addCriterion("gmt_create <=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIn(List<Date> values) {
            addCriterion("gmt_create in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<Date> values) {
            addCriterion("gmt_create not in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(Date value1, Date value2) {
            addCriterion("gmt_create between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            addCriterion("gmt_create not between", value1, value2, "gmtCreate");
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
    }
}