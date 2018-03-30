package net.monitor.dao.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NetstatMonitorDTOExample {

  protected String orderByClause;

  protected boolean distinct;

  protected List<Criteria> oredCriteria;

  protected Integer limitStart;

  protected Integer limitEnd;

  public NetstatMonitorDTOExample() {
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

    public Criteria andPortIsNull() {
      addCriterion("port is null");
      return (Criteria) this;
    }

    public Criteria andPortIsNotNull() {
      addCriterion("port is not null");
      return (Criteria) this;
    }

    public Criteria andPortEqualTo(Integer value) {
      addCriterion("port =", value, "port");
      return (Criteria) this;
    }

    public Criteria andPortNotEqualTo(Integer value) {
      addCriterion("port <>", value, "port");
      return (Criteria) this;
    }

    public Criteria andPortGreaterThan(Integer value) {
      addCriterion("port >", value, "port");
      return (Criteria) this;
    }

    public Criteria andPortGreaterThanOrEqualTo(Integer value) {
      addCriterion("port >=", value, "port");
      return (Criteria) this;
    }

    public Criteria andPortLessThan(Integer value) {
      addCriterion("port <", value, "port");
      return (Criteria) this;
    }

    public Criteria andPortLessThanOrEqualTo(Integer value) {
      addCriterion("port <=", value, "port");
      return (Criteria) this;
    }

    public Criteria andPortIn(List<Integer> values) {
      addCriterion("port in", values, "port");
      return (Criteria) this;
    }

    public Criteria andPortNotIn(List<Integer> values) {
      addCriterion("port not in", values, "port");
      return (Criteria) this;
    }

    public Criteria andPortBetween(Integer value1, Integer value2) {
      addCriterion("port between", value1, value2, "port");
      return (Criteria) this;
    }

    public Criteria andPortNotBetween(Integer value1, Integer value2) {
      addCriterion("port not between", value1, value2, "port");
      return (Criteria) this;
    }

    public Criteria andTotalIsNull() {
      addCriterion("total is null");
      return (Criteria) this;
    }

    public Criteria andTotalIsNotNull() {
      addCriterion("total is not null");
      return (Criteria) this;
    }

    public Criteria andTotalEqualTo(Integer value) {
      addCriterion("total =", value, "total");
      return (Criteria) this;
    }

    public Criteria andTotalNotEqualTo(Integer value) {
      addCriterion("total <>", value, "total");
      return (Criteria) this;
    }

    public Criteria andTotalGreaterThan(Integer value) {
      addCriterion("total >", value, "total");
      return (Criteria) this;
    }

    public Criteria andTotalGreaterThanOrEqualTo(Integer value) {
      addCriterion("total >=", value, "total");
      return (Criteria) this;
    }

    public Criteria andTotalLessThan(Integer value) {
      addCriterion("total <", value, "total");
      return (Criteria) this;
    }

    public Criteria andTotalLessThanOrEqualTo(Integer value) {
      addCriterion("total <=", value, "total");
      return (Criteria) this;
    }

    public Criteria andTotalIn(List<Integer> values) {
      addCriterion("total in", values, "total");
      return (Criteria) this;
    }

    public Criteria andTotalNotIn(List<Integer> values) {
      addCriterion("total not in", values, "total");
      return (Criteria) this;
    }

    public Criteria andTotalBetween(Integer value1, Integer value2) {
      addCriterion("total between", value1, value2, "total");
      return (Criteria) this;
    }

    public Criteria andTotalNotBetween(Integer value1, Integer value2) {
      addCriterion("total not between", value1, value2, "total");
      return (Criteria) this;
    }

    public Criteria andEstablishedIsNull() {
      addCriterion("established is null");
      return (Criteria) this;
    }

    public Criteria andEstablishedIsNotNull() {
      addCriterion("established is not null");
      return (Criteria) this;
    }

    public Criteria andEstablishedEqualTo(Integer value) {
      addCriterion("established =", value, "established");
      return (Criteria) this;
    }

    public Criteria andEstablishedNotEqualTo(Integer value) {
      addCriterion("established <>", value, "established");
      return (Criteria) this;
    }

    public Criteria andEstablishedGreaterThan(Integer value) {
      addCriterion("established >", value, "established");
      return (Criteria) this;
    }

    public Criteria andEstablishedGreaterThanOrEqualTo(Integer value) {
      addCriterion("established >=", value, "established");
      return (Criteria) this;
    }

    public Criteria andEstablishedLessThan(Integer value) {
      addCriterion("established <", value, "established");
      return (Criteria) this;
    }

    public Criteria andEstablishedLessThanOrEqualTo(Integer value) {
      addCriterion("established <=", value, "established");
      return (Criteria) this;
    }

    public Criteria andEstablishedIn(List<Integer> values) {
      addCriterion("established in", values, "established");
      return (Criteria) this;
    }

    public Criteria andEstablishedNotIn(List<Integer> values) {
      addCriterion("established not in", values, "established");
      return (Criteria) this;
    }

    public Criteria andEstablishedBetween(Integer value1, Integer value2) {
      addCriterion("established between", value1, value2, "established");
      return (Criteria) this;
    }

    public Criteria andEstablishedNotBetween(Integer value1, Integer value2) {
      addCriterion("established not between", value1, value2, "established");
      return (Criteria) this;
    }

    public Criteria andTimeWaitIsNull() {
      addCriterion("time_wait is null");
      return (Criteria) this;
    }

    public Criteria andTimeWaitIsNotNull() {
      addCriterion("time_wait is not null");
      return (Criteria) this;
    }

    public Criteria andTimeWaitEqualTo(Integer value) {
      addCriterion("time_wait =", value, "timeWait");
      return (Criteria) this;
    }

    public Criteria andTimeWaitNotEqualTo(Integer value) {
      addCriterion("time_wait <>", value, "timeWait");
      return (Criteria) this;
    }

    public Criteria andTimeWaitGreaterThan(Integer value) {
      addCriterion("time_wait >", value, "timeWait");
      return (Criteria) this;
    }

    public Criteria andTimeWaitGreaterThanOrEqualTo(Integer value) {
      addCriterion("time_wait >=", value, "timeWait");
      return (Criteria) this;
    }

    public Criteria andTimeWaitLessThan(Integer value) {
      addCriterion("time_wait <", value, "timeWait");
      return (Criteria) this;
    }

    public Criteria andTimeWaitLessThanOrEqualTo(Integer value) {
      addCriterion("time_wait <=", value, "timeWait");
      return (Criteria) this;
    }

    public Criteria andTimeWaitIn(List<Integer> values) {
      addCriterion("time_wait in", values, "timeWait");
      return (Criteria) this;
    }

    public Criteria andTimeWaitNotIn(List<Integer> values) {
      addCriterion("time_wait not in", values, "timeWait");
      return (Criteria) this;
    }

    public Criteria andTimeWaitBetween(Integer value1, Integer value2) {
      addCriterion("time_wait between", value1, value2, "timeWait");
      return (Criteria) this;
    }

    public Criteria andTimeWaitNotBetween(Integer value1, Integer value2) {
      addCriterion("time_wait not between", value1, value2, "timeWait");
      return (Criteria) this;
    }

    public Criteria andFinWait2IsNull() {
      addCriterion("fin_wait2 is null");
      return (Criteria) this;
    }

    public Criteria andFinWait2IsNotNull() {
      addCriterion("fin_wait2 is not null");
      return (Criteria) this;
    }

    public Criteria andFinWait2EqualTo(Integer value) {
      addCriterion("fin_wait2 =", value, "finWait2");
      return (Criteria) this;
    }

    public Criteria andFinWait2NotEqualTo(Integer value) {
      addCriterion("fin_wait2 <>", value, "finWait2");
      return (Criteria) this;
    }

    public Criteria andFinWait2GreaterThan(Integer value) {
      addCriterion("fin_wait2 >", value, "finWait2");
      return (Criteria) this;
    }

    public Criteria andFinWait2GreaterThanOrEqualTo(Integer value) {
      addCriterion("fin_wait2 >=", value, "finWait2");
      return (Criteria) this;
    }

    public Criteria andFinWait2LessThan(Integer value) {
      addCriterion("fin_wait2 <", value, "finWait2");
      return (Criteria) this;
    }

    public Criteria andFinWait2LessThanOrEqualTo(Integer value) {
      addCriterion("fin_wait2 <=", value, "finWait2");
      return (Criteria) this;
    }

    public Criteria andFinWait2In(List<Integer> values) {
      addCriterion("fin_wait2 in", values, "finWait2");
      return (Criteria) this;
    }

    public Criteria andFinWait2NotIn(List<Integer> values) {
      addCriterion("fin_wait2 not in", values, "finWait2");
      return (Criteria) this;
    }

    public Criteria andFinWait2Between(Integer value1, Integer value2) {
      addCriterion("fin_wait2 between", value1, value2, "finWait2");
      return (Criteria) this;
    }

    public Criteria andFinWait2NotBetween(Integer value1, Integer value2) {
      addCriterion("fin_wait2 not between", value1, value2, "finWait2");
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