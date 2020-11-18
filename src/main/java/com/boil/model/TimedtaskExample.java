package com.boil.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TimedtaskExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table timedtask
     *
     * @mbg.generated Wed Nov 18 17:54:42 CST 2020
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table timedtask
     *
     * @mbg.generated Wed Nov 18 17:54:42 CST 2020
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table timedtask
     *
     * @mbg.generated Wed Nov 18 17:54:42 CST 2020
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table timedtask
     *
     * @mbg.generated Wed Nov 18 17:54:42 CST 2020
     */
    public TimedtaskExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table timedtask
     *
     * @mbg.generated Wed Nov 18 17:54:42 CST 2020
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table timedtask
     *
     * @mbg.generated Wed Nov 18 17:54:42 CST 2020
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table timedtask
     *
     * @mbg.generated Wed Nov 18 17:54:42 CST 2020
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table timedtask
     *
     * @mbg.generated Wed Nov 18 17:54:42 CST 2020
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table timedtask
     *
     * @mbg.generated Wed Nov 18 17:54:42 CST 2020
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table timedtask
     *
     * @mbg.generated Wed Nov 18 17:54:42 CST 2020
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table timedtask
     *
     * @mbg.generated Wed Nov 18 17:54:42 CST 2020
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table timedtask
     *
     * @mbg.generated Wed Nov 18 17:54:42 CST 2020
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table timedtask
     *
     * @mbg.generated Wed Nov 18 17:54:42 CST 2020
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table timedtask
     *
     * @mbg.generated Wed Nov 18 17:54:42 CST 2020
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table timedtask
     *
     * @mbg.generated Wed Nov 18 17:54:42 CST 2020
     */
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCreatedByIsNull() {
            addCriterion("created_by is null");
            return (Criteria) this;
        }

        public Criteria andCreatedByIsNotNull() {
            addCriterion("created_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedByEqualTo(String value) {
            addCriterion("created_by =", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotEqualTo(String value) {
            addCriterion("created_by <>", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThan(String value) {
            addCriterion("created_by >", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThanOrEqualTo(String value) {
            addCriterion("created_by >=", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThan(String value) {
            addCriterion("created_by <", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThanOrEqualTo(String value) {
            addCriterion("created_by <=", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLike(String value) {
            addCriterion("created_by like", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotLike(String value) {
            addCriterion("created_by not like", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByIn(List<String> values) {
            addCriterion("created_by in", values, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotIn(List<String> values) {
            addCriterion("created_by not in", values, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByBetween(String value1, String value2) {
            addCriterion("created_by between", value1, value2, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotBetween(String value1, String value2) {
            addCriterion("created_by not between", value1, value2, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("created_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("created_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(Date value) {
            addCriterion("created_time =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(Date value) {
            addCriterion("created_time <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(Date value) {
            addCriterion("created_time >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("created_time >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(Date value) {
            addCriterion("created_time <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("created_time <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<Date> values) {
            addCriterion("created_time in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<Date> values) {
            addCriterion("created_time not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(Date value1, Date value2) {
            addCriterion("created_time between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("created_time not between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedByIsNull() {
            addCriterion("updated_by is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedByIsNotNull() {
            addCriterion("updated_by is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedByEqualTo(String value) {
            addCriterion("updated_by =", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNotEqualTo(String value) {
            addCriterion("updated_by <>", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByGreaterThan(String value) {
            addCriterion("updated_by >", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByGreaterThanOrEqualTo(String value) {
            addCriterion("updated_by >=", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByLessThan(String value) {
            addCriterion("updated_by <", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByLessThanOrEqualTo(String value) {
            addCriterion("updated_by <=", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByLike(String value) {
            addCriterion("updated_by like", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNotLike(String value) {
            addCriterion("updated_by not like", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByIn(List<String> values) {
            addCriterion("updated_by in", values, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNotIn(List<String> values) {
            addCriterion("updated_by not in", values, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByBetween(String value1, String value2) {
            addCriterion("updated_by between", value1, value2, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNotBetween(String value1, String value2) {
            addCriterion("updated_by not between", value1, value2, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIsNull() {
            addCriterion("updated_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIsNotNull() {
            addCriterion("updated_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeEqualTo(Date value) {
            addCriterion("updated_time =", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotEqualTo(Date value) {
            addCriterion("updated_time <>", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeGreaterThan(Date value) {
            addCriterion("updated_time >", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updated_time >=", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeLessThan(Date value) {
            addCriterion("updated_time <", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("updated_time <=", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIn(List<Date> values) {
            addCriterion("updated_time in", values, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotIn(List<Date> values) {
            addCriterion("updated_time not in", values, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeBetween(Date value1, Date value2) {
            addCriterion("updated_time between", value1, value2, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("updated_time not between", value1, value2, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andCycletypeIsNull() {
            addCriterion("cycletype is null");
            return (Criteria) this;
        }

        public Criteria andCycletypeIsNotNull() {
            addCriterion("cycletype is not null");
            return (Criteria) this;
        }

        public Criteria andCycletypeEqualTo(Integer value) {
            addCriterion("cycletype =", value, "cycletype");
            return (Criteria) this;
        }

        public Criteria andCycletypeNotEqualTo(Integer value) {
            addCriterion("cycletype <>", value, "cycletype");
            return (Criteria) this;
        }

        public Criteria andCycletypeGreaterThan(Integer value) {
            addCriterion("cycletype >", value, "cycletype");
            return (Criteria) this;
        }

        public Criteria andCycletypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("cycletype >=", value, "cycletype");
            return (Criteria) this;
        }

        public Criteria andCycletypeLessThan(Integer value) {
            addCriterion("cycletype <", value, "cycletype");
            return (Criteria) this;
        }

        public Criteria andCycletypeLessThanOrEqualTo(Integer value) {
            addCriterion("cycletype <=", value, "cycletype");
            return (Criteria) this;
        }

        public Criteria andCycletypeIn(List<Integer> values) {
            addCriterion("cycletype in", values, "cycletype");
            return (Criteria) this;
        }

        public Criteria andCycletypeNotIn(List<Integer> values) {
            addCriterion("cycletype not in", values, "cycletype");
            return (Criteria) this;
        }

        public Criteria andCycletypeBetween(Integer value1, Integer value2) {
            addCriterion("cycletype between", value1, value2, "cycletype");
            return (Criteria) this;
        }

        public Criteria andCycletypeNotBetween(Integer value1, Integer value2) {
            addCriterion("cycletype not between", value1, value2, "cycletype");
            return (Criteria) this;
        }

        public Criteria andDatetypeIsNull() {
            addCriterion("datetype is null");
            return (Criteria) this;
        }

        public Criteria andDatetypeIsNotNull() {
            addCriterion("datetype is not null");
            return (Criteria) this;
        }

        public Criteria andDatetypeEqualTo(Integer value) {
            addCriterion("datetype =", value, "datetype");
            return (Criteria) this;
        }

        public Criteria andDatetypeNotEqualTo(Integer value) {
            addCriterion("datetype <>", value, "datetype");
            return (Criteria) this;
        }

        public Criteria andDatetypeGreaterThan(Integer value) {
            addCriterion("datetype >", value, "datetype");
            return (Criteria) this;
        }

        public Criteria andDatetypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("datetype >=", value, "datetype");
            return (Criteria) this;
        }

        public Criteria andDatetypeLessThan(Integer value) {
            addCriterion("datetype <", value, "datetype");
            return (Criteria) this;
        }

        public Criteria andDatetypeLessThanOrEqualTo(Integer value) {
            addCriterion("datetype <=", value, "datetype");
            return (Criteria) this;
        }

        public Criteria andDatetypeIn(List<Integer> values) {
            addCriterion("datetype in", values, "datetype");
            return (Criteria) this;
        }

        public Criteria andDatetypeNotIn(List<Integer> values) {
            addCriterion("datetype not in", values, "datetype");
            return (Criteria) this;
        }

        public Criteria andDatetypeBetween(Integer value1, Integer value2) {
            addCriterion("datetype between", value1, value2, "datetype");
            return (Criteria) this;
        }

        public Criteria andDatetypeNotBetween(Integer value1, Integer value2) {
            addCriterion("datetype not between", value1, value2, "datetype");
            return (Criteria) this;
        }

        public Criteria andSomedayIsNull() {
            addCriterion("someday is null");
            return (Criteria) this;
        }

        public Criteria andSomedayIsNotNull() {
            addCriterion("someday is not null");
            return (Criteria) this;
        }

        public Criteria andSomedayEqualTo(Integer value) {
            addCriterion("someday =", value, "someday");
            return (Criteria) this;
        }

        public Criteria andSomedayNotEqualTo(Integer value) {
            addCriterion("someday <>", value, "someday");
            return (Criteria) this;
        }

        public Criteria andSomedayGreaterThan(Integer value) {
            addCriterion("someday >", value, "someday");
            return (Criteria) this;
        }

        public Criteria andSomedayGreaterThanOrEqualTo(Integer value) {
            addCriterion("someday >=", value, "someday");
            return (Criteria) this;
        }

        public Criteria andSomedayLessThan(Integer value) {
            addCriterion("someday <", value, "someday");
            return (Criteria) this;
        }

        public Criteria andSomedayLessThanOrEqualTo(Integer value) {
            addCriterion("someday <=", value, "someday");
            return (Criteria) this;
        }

        public Criteria andSomedayIn(List<Integer> values) {
            addCriterion("someday in", values, "someday");
            return (Criteria) this;
        }

        public Criteria andSomedayNotIn(List<Integer> values) {
            addCriterion("someday not in", values, "someday");
            return (Criteria) this;
        }

        public Criteria andSomedayBetween(Integer value1, Integer value2) {
            addCriterion("someday between", value1, value2, "someday");
            return (Criteria) this;
        }

        public Criteria andSomedayNotBetween(Integer value1, Integer value2) {
            addCriterion("someday not between", value1, value2, "someday");
            return (Criteria) this;
        }

        public Criteria andStartingtimeIsNull() {
            addCriterion("startingtime is null");
            return (Criteria) this;
        }

        public Criteria andStartingtimeIsNotNull() {
            addCriterion("startingtime is not null");
            return (Criteria) this;
        }

        public Criteria andStartingtimeEqualTo(Integer value) {
            addCriterion("startingtime =", value, "startingtime");
            return (Criteria) this;
        }

        public Criteria andStartingtimeNotEqualTo(Integer value) {
            addCriterion("startingtime <>", value, "startingtime");
            return (Criteria) this;
        }

        public Criteria andStartingtimeGreaterThan(Integer value) {
            addCriterion("startingtime >", value, "startingtime");
            return (Criteria) this;
        }

        public Criteria andStartingtimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("startingtime >=", value, "startingtime");
            return (Criteria) this;
        }

        public Criteria andStartingtimeLessThan(Integer value) {
            addCriterion("startingtime <", value, "startingtime");
            return (Criteria) this;
        }

        public Criteria andStartingtimeLessThanOrEqualTo(Integer value) {
            addCriterion("startingtime <=", value, "startingtime");
            return (Criteria) this;
        }

        public Criteria andStartingtimeIn(List<Integer> values) {
            addCriterion("startingtime in", values, "startingtime");
            return (Criteria) this;
        }

        public Criteria andStartingtimeNotIn(List<Integer> values) {
            addCriterion("startingtime not in", values, "startingtime");
            return (Criteria) this;
        }

        public Criteria andStartingtimeBetween(Integer value1, Integer value2) {
            addCriterion("startingtime between", value1, value2, "startingtime");
            return (Criteria) this;
        }

        public Criteria andStartingtimeNotBetween(Integer value1, Integer value2) {
            addCriterion("startingtime not between", value1, value2, "startingtime");
            return (Criteria) this;
        }

        public Criteria andGroupnumIsNull() {
            addCriterion("groupnum is null");
            return (Criteria) this;
        }

        public Criteria andGroupnumIsNotNull() {
            addCriterion("groupnum is not null");
            return (Criteria) this;
        }

        public Criteria andGroupnumEqualTo(String value) {
            addCriterion("groupnum =", value, "groupnum");
            return (Criteria) this;
        }

        public Criteria andGroupnumNotEqualTo(String value) {
            addCriterion("groupnum <>", value, "groupnum");
            return (Criteria) this;
        }

        public Criteria andGroupnumGreaterThan(String value) {
            addCriterion("groupnum >", value, "groupnum");
            return (Criteria) this;
        }

        public Criteria andGroupnumGreaterThanOrEqualTo(String value) {
            addCriterion("groupnum >=", value, "groupnum");
            return (Criteria) this;
        }

        public Criteria andGroupnumLessThan(String value) {
            addCriterion("groupnum <", value, "groupnum");
            return (Criteria) this;
        }

        public Criteria andGroupnumLessThanOrEqualTo(String value) {
            addCriterion("groupnum <=", value, "groupnum");
            return (Criteria) this;
        }

        public Criteria andGroupnumLike(String value) {
            addCriterion("groupnum like", value, "groupnum");
            return (Criteria) this;
        }

        public Criteria andGroupnumNotLike(String value) {
            addCriterion("groupnum not like", value, "groupnum");
            return (Criteria) this;
        }

        public Criteria andGroupnumIn(List<String> values) {
            addCriterion("groupnum in", values, "groupnum");
            return (Criteria) this;
        }

        public Criteria andGroupnumNotIn(List<String> values) {
            addCriterion("groupnum not in", values, "groupnum");
            return (Criteria) this;
        }

        public Criteria andGroupnumBetween(String value1, String value2) {
            addCriterion("groupnum between", value1, value2, "groupnum");
            return (Criteria) this;
        }

        public Criteria andGroupnumNotBetween(String value1, String value2) {
            addCriterion("groupnum not between", value1, value2, "groupnum");
            return (Criteria) this;
        }

        public Criteria andLasttimeIsNull() {
            addCriterion("lasttime is null");
            return (Criteria) this;
        }

        public Criteria andLasttimeIsNotNull() {
            addCriterion("lasttime is not null");
            return (Criteria) this;
        }

        public Criteria andLasttimeEqualTo(String value) {
            addCriterion("lasttime =", value, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeNotEqualTo(String value) {
            addCriterion("lasttime <>", value, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeGreaterThan(String value) {
            addCriterion("lasttime >", value, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeGreaterThanOrEqualTo(String value) {
            addCriterion("lasttime >=", value, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeLessThan(String value) {
            addCriterion("lasttime <", value, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeLessThanOrEqualTo(String value) {
            addCriterion("lasttime <=", value, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeLike(String value) {
            addCriterion("lasttime like", value, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeNotLike(String value) {
            addCriterion("lasttime not like", value, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeIn(List<String> values) {
            addCriterion("lasttime in", values, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeNotIn(List<String> values) {
            addCriterion("lasttime not in", values, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeBetween(String value1, String value2) {
            addCriterion("lasttime between", value1, value2, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeNotBetween(String value1, String value2) {
            addCriterion("lasttime not between", value1, value2, "lasttime");
            return (Criteria) this;
        }

        public Criteria andSuccessIsNull() {
            addCriterion("success is null");
            return (Criteria) this;
        }

        public Criteria andSuccessIsNotNull() {
            addCriterion("success is not null");
            return (Criteria) this;
        }

        public Criteria andSuccessEqualTo(Integer value) {
            addCriterion("success =", value, "success");
            return (Criteria) this;
        }

        public Criteria andSuccessNotEqualTo(Integer value) {
            addCriterion("success <>", value, "success");
            return (Criteria) this;
        }

        public Criteria andSuccessGreaterThan(Integer value) {
            addCriterion("success >", value, "success");
            return (Criteria) this;
        }

        public Criteria andSuccessGreaterThanOrEqualTo(Integer value) {
            addCriterion("success >=", value, "success");
            return (Criteria) this;
        }

        public Criteria andSuccessLessThan(Integer value) {
            addCriterion("success <", value, "success");
            return (Criteria) this;
        }

        public Criteria andSuccessLessThanOrEqualTo(Integer value) {
            addCriterion("success <=", value, "success");
            return (Criteria) this;
        }

        public Criteria andSuccessIn(List<Integer> values) {
            addCriterion("success in", values, "success");
            return (Criteria) this;
        }

        public Criteria andSuccessNotIn(List<Integer> values) {
            addCriterion("success not in", values, "success");
            return (Criteria) this;
        }

        public Criteria andSuccessBetween(Integer value1, Integer value2) {
            addCriterion("success between", value1, value2, "success");
            return (Criteria) this;
        }

        public Criteria andSuccessNotBetween(Integer value1, Integer value2) {
            addCriterion("success not between", value1, value2, "success");
            return (Criteria) this;
        }

        public Criteria andFailedIsNull() {
            addCriterion("failed is null");
            return (Criteria) this;
        }

        public Criteria andFailedIsNotNull() {
            addCriterion("failed is not null");
            return (Criteria) this;
        }

        public Criteria andFailedEqualTo(Integer value) {
            addCriterion("failed =", value, "failed");
            return (Criteria) this;
        }

        public Criteria andFailedNotEqualTo(Integer value) {
            addCriterion("failed <>", value, "failed");
            return (Criteria) this;
        }

        public Criteria andFailedGreaterThan(Integer value) {
            addCriterion("failed >", value, "failed");
            return (Criteria) this;
        }

        public Criteria andFailedGreaterThanOrEqualTo(Integer value) {
            addCriterion("failed >=", value, "failed");
            return (Criteria) this;
        }

        public Criteria andFailedLessThan(Integer value) {
            addCriterion("failed <", value, "failed");
            return (Criteria) this;
        }

        public Criteria andFailedLessThanOrEqualTo(Integer value) {
            addCriterion("failed <=", value, "failed");
            return (Criteria) this;
        }

        public Criteria andFailedIn(List<Integer> values) {
            addCriterion("failed in", values, "failed");
            return (Criteria) this;
        }

        public Criteria andFailedNotIn(List<Integer> values) {
            addCriterion("failed not in", values, "failed");
            return (Criteria) this;
        }

        public Criteria andFailedBetween(Integer value1, Integer value2) {
            addCriterion("failed between", value1, value2, "failed");
            return (Criteria) this;
        }

        public Criteria andFailedNotBetween(Integer value1, Integer value2) {
            addCriterion("failed not between", value1, value2, "failed");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table timedtask
     *
     * @mbg.generated do_not_delete_during_merge Wed Nov 18 17:54:42 CST 2020
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table timedtask
     *
     * @mbg.generated Wed Nov 18 17:54:42 CST 2020
     */
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