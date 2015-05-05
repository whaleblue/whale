package com.bwc.mybatis;

import java.util.ArrayList;
import java.util.List;

public class BwMapBrandEntityExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table bw_map_brand_entity
     *
     * @mbggenerated Mon Apr 27 14:46:01 CST 2015
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table bw_map_brand_entity
     *
     * @mbggenerated Mon Apr 27 14:46:01 CST 2015
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table bw_map_brand_entity
     *
     * @mbggenerated Mon Apr 27 14:46:01 CST 2015
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bw_map_brand_entity
     *
     * @mbggenerated Mon Apr 27 14:46:01 CST 2015
     */
    public BwMapBrandEntityExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bw_map_brand_entity
     *
     * @mbggenerated Mon Apr 27 14:46:01 CST 2015
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bw_map_brand_entity
     *
     * @mbggenerated Mon Apr 27 14:46:01 CST 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bw_map_brand_entity
     *
     * @mbggenerated Mon Apr 27 14:46:01 CST 2015
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bw_map_brand_entity
     *
     * @mbggenerated Mon Apr 27 14:46:01 CST 2015
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bw_map_brand_entity
     *
     * @mbggenerated Mon Apr 27 14:46:01 CST 2015
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bw_map_brand_entity
     *
     * @mbggenerated Mon Apr 27 14:46:01 CST 2015
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bw_map_brand_entity
     *
     * @mbggenerated Mon Apr 27 14:46:01 CST 2015
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bw_map_brand_entity
     *
     * @mbggenerated Mon Apr 27 14:46:01 CST 2015
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
     * This method corresponds to the database table bw_map_brand_entity
     *
     * @mbggenerated Mon Apr 27 14:46:01 CST 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bw_map_brand_entity
     *
     * @mbggenerated Mon Apr 27 14:46:01 CST 2015
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table bw_map_brand_entity
     *
     * @mbggenerated Mon Apr 27 14:46:01 CST 2015
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

        public Criteria andBrandEntityIdIsNull() {
            addCriterion("BRAND_ENTITY_ID is null");
            return (Criteria) this;
        }

        public Criteria andBrandEntityIdIsNotNull() {
            addCriterion("BRAND_ENTITY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBrandEntityIdEqualTo(Integer value) {
            addCriterion("BRAND_ENTITY_ID =", value, "brandEntityId");
            return (Criteria) this;
        }

        public Criteria andBrandEntityIdNotEqualTo(Integer value) {
            addCriterion("BRAND_ENTITY_ID <>", value, "brandEntityId");
            return (Criteria) this;
        }

        public Criteria andBrandEntityIdGreaterThan(Integer value) {
            addCriterion("BRAND_ENTITY_ID >", value, "brandEntityId");
            return (Criteria) this;
        }

        public Criteria andBrandEntityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("BRAND_ENTITY_ID >=", value, "brandEntityId");
            return (Criteria) this;
        }

        public Criteria andBrandEntityIdLessThan(Integer value) {
            addCriterion("BRAND_ENTITY_ID <", value, "brandEntityId");
            return (Criteria) this;
        }

        public Criteria andBrandEntityIdLessThanOrEqualTo(Integer value) {
            addCriterion("BRAND_ENTITY_ID <=", value, "brandEntityId");
            return (Criteria) this;
        }

        public Criteria andBrandEntityIdIn(List<Integer> values) {
            addCriterion("BRAND_ENTITY_ID in", values, "brandEntityId");
            return (Criteria) this;
        }

        public Criteria andBrandEntityIdNotIn(List<Integer> values) {
            addCriterion("BRAND_ENTITY_ID not in", values, "brandEntityId");
            return (Criteria) this;
        }

        public Criteria andBrandEntityIdBetween(Integer value1, Integer value2) {
            addCriterion("BRAND_ENTITY_ID between", value1, value2, "brandEntityId");
            return (Criteria) this;
        }

        public Criteria andBrandEntityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("BRAND_ENTITY_ID not between", value1, value2, "brandEntityId");
            return (Criteria) this;
        }

        public Criteria andBrandIdIsNull() {
            addCriterion("BRAND_ID is null");
            return (Criteria) this;
        }

        public Criteria andBrandIdIsNotNull() {
            addCriterion("BRAND_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBrandIdEqualTo(Integer value) {
            addCriterion("BRAND_ID =", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotEqualTo(Integer value) {
            addCriterion("BRAND_ID <>", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdGreaterThan(Integer value) {
            addCriterion("BRAND_ID >", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("BRAND_ID >=", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLessThan(Integer value) {
            addCriterion("BRAND_ID <", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLessThanOrEqualTo(Integer value) {
            addCriterion("BRAND_ID <=", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdIn(List<Integer> values) {
            addCriterion("BRAND_ID in", values, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotIn(List<Integer> values) {
            addCriterion("BRAND_ID not in", values, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdBetween(Integer value1, Integer value2) {
            addCriterion("BRAND_ID between", value1, value2, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotBetween(Integer value1, Integer value2) {
            addCriterion("BRAND_ID not between", value1, value2, "brandId");
            return (Criteria) this;
        }

        public Criteria andEntityCodeIsNull() {
            addCriterion("ENTITY_CODE is null");
            return (Criteria) this;
        }

        public Criteria andEntityCodeIsNotNull() {
            addCriterion("ENTITY_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andEntityCodeEqualTo(String value) {
            addCriterion("ENTITY_CODE =", value, "entityCode");
            return (Criteria) this;
        }

        public Criteria andEntityCodeNotEqualTo(String value) {
            addCriterion("ENTITY_CODE <>", value, "entityCode");
            return (Criteria) this;
        }

        public Criteria andEntityCodeGreaterThan(String value) {
            addCriterion("ENTITY_CODE >", value, "entityCode");
            return (Criteria) this;
        }

        public Criteria andEntityCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ENTITY_CODE >=", value, "entityCode");
            return (Criteria) this;
        }

        public Criteria andEntityCodeLessThan(String value) {
            addCriterion("ENTITY_CODE <", value, "entityCode");
            return (Criteria) this;
        }

        public Criteria andEntityCodeLessThanOrEqualTo(String value) {
            addCriterion("ENTITY_CODE <=", value, "entityCode");
            return (Criteria) this;
        }

        public Criteria andEntityCodeLike(String value) {
            addCriterion("ENTITY_CODE like", value, "entityCode");
            return (Criteria) this;
        }

        public Criteria andEntityCodeNotLike(String value) {
            addCriterion("ENTITY_CODE not like", value, "entityCode");
            return (Criteria) this;
        }

        public Criteria andEntityCodeIn(List<String> values) {
            addCriterion("ENTITY_CODE in", values, "entityCode");
            return (Criteria) this;
        }

        public Criteria andEntityCodeNotIn(List<String> values) {
            addCriterion("ENTITY_CODE not in", values, "entityCode");
            return (Criteria) this;
        }

        public Criteria andEntityCodeBetween(String value1, String value2) {
            addCriterion("ENTITY_CODE between", value1, value2, "entityCode");
            return (Criteria) this;
        }

        public Criteria andEntityCodeNotBetween(String value1, String value2) {
            addCriterion("ENTITY_CODE not between", value1, value2, "entityCode");
            return (Criteria) this;
        }

        public Criteria andShortNameIsNull() {
            addCriterion("SHORT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andShortNameIsNotNull() {
            addCriterion("SHORT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andShortNameEqualTo(String value) {
            addCriterion("SHORT_NAME =", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotEqualTo(String value) {
            addCriterion("SHORT_NAME <>", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameGreaterThan(String value) {
            addCriterion("SHORT_NAME >", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameGreaterThanOrEqualTo(String value) {
            addCriterion("SHORT_NAME >=", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLessThan(String value) {
            addCriterion("SHORT_NAME <", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLessThanOrEqualTo(String value) {
            addCriterion("SHORT_NAME <=", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLike(String value) {
            addCriterion("SHORT_NAME like", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotLike(String value) {
            addCriterion("SHORT_NAME not like", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameIn(List<String> values) {
            addCriterion("SHORT_NAME in", values, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotIn(List<String> values) {
            addCriterion("SHORT_NAME not in", values, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameBetween(String value1, String value2) {
            addCriterion("SHORT_NAME between", value1, value2, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotBetween(String value1, String value2) {
            addCriterion("SHORT_NAME not between", value1, value2, "shortName");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("NAME is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("ADDRESS =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("ADDRESS <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("ADDRESS >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ADDRESS >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("ADDRESS <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("ADDRESS <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("ADDRESS like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("ADDRESS not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("ADDRESS in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("ADDRESS not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("ADDRESS between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("ADDRESS not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNull() {
            addCriterion("TELEPHONE is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNotNull() {
            addCriterion("TELEPHONE is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneEqualTo(String value) {
            addCriterion("TELEPHONE =", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotEqualTo(String value) {
            addCriterion("TELEPHONE <>", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThan(String value) {
            addCriterion("TELEPHONE >", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("TELEPHONE >=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThan(String value) {
            addCriterion("TELEPHONE <", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThanOrEqualTo(String value) {
            addCriterion("TELEPHONE <=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLike(String value) {
            addCriterion("TELEPHONE like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotLike(String value) {
            addCriterion("TELEPHONE not like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneIn(List<String> values) {
            addCriterion("TELEPHONE in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotIn(List<String> values) {
            addCriterion("TELEPHONE not in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneBetween(String value1, String value2) {
            addCriterion("TELEPHONE between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotBetween(String value1, String value2) {
            addCriterion("TELEPHONE not between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andLngXIsNull() {
            addCriterion("LNG_X is null");
            return (Criteria) this;
        }

        public Criteria andLngXIsNotNull() {
            addCriterion("LNG_X is not null");
            return (Criteria) this;
        }

        public Criteria andLngXEqualTo(String value) {
            addCriterion("LNG_X =", value, "lngX");
            return (Criteria) this;
        }

        public Criteria andLngXNotEqualTo(String value) {
            addCriterion("LNG_X <>", value, "lngX");
            return (Criteria) this;
        }

        public Criteria andLngXGreaterThan(String value) {
            addCriterion("LNG_X >", value, "lngX");
            return (Criteria) this;
        }

        public Criteria andLngXGreaterThanOrEqualTo(String value) {
            addCriterion("LNG_X >=", value, "lngX");
            return (Criteria) this;
        }

        public Criteria andLngXLessThan(String value) {
            addCriterion("LNG_X <", value, "lngX");
            return (Criteria) this;
        }

        public Criteria andLngXLessThanOrEqualTo(String value) {
            addCriterion("LNG_X <=", value, "lngX");
            return (Criteria) this;
        }

        public Criteria andLngXLike(String value) {
            addCriterion("LNG_X like", value, "lngX");
            return (Criteria) this;
        }

        public Criteria andLngXNotLike(String value) {
            addCriterion("LNG_X not like", value, "lngX");
            return (Criteria) this;
        }

        public Criteria andLngXIn(List<String> values) {
            addCriterion("LNG_X in", values, "lngX");
            return (Criteria) this;
        }

        public Criteria andLngXNotIn(List<String> values) {
            addCriterion("LNG_X not in", values, "lngX");
            return (Criteria) this;
        }

        public Criteria andLngXBetween(String value1, String value2) {
            addCriterion("LNG_X between", value1, value2, "lngX");
            return (Criteria) this;
        }

        public Criteria andLngXNotBetween(String value1, String value2) {
            addCriterion("LNG_X not between", value1, value2, "lngX");
            return (Criteria) this;
        }

        public Criteria andLatYIsNull() {
            addCriterion("LAT_Y is null");
            return (Criteria) this;
        }

        public Criteria andLatYIsNotNull() {
            addCriterion("LAT_Y is not null");
            return (Criteria) this;
        }

        public Criteria andLatYEqualTo(String value) {
            addCriterion("LAT_Y =", value, "latY");
            return (Criteria) this;
        }

        public Criteria andLatYNotEqualTo(String value) {
            addCriterion("LAT_Y <>", value, "latY");
            return (Criteria) this;
        }

        public Criteria andLatYGreaterThan(String value) {
            addCriterion("LAT_Y >", value, "latY");
            return (Criteria) this;
        }

        public Criteria andLatYGreaterThanOrEqualTo(String value) {
            addCriterion("LAT_Y >=", value, "latY");
            return (Criteria) this;
        }

        public Criteria andLatYLessThan(String value) {
            addCriterion("LAT_Y <", value, "latY");
            return (Criteria) this;
        }

        public Criteria andLatYLessThanOrEqualTo(String value) {
            addCriterion("LAT_Y <=", value, "latY");
            return (Criteria) this;
        }

        public Criteria andLatYLike(String value) {
            addCriterion("LAT_Y like", value, "latY");
            return (Criteria) this;
        }

        public Criteria andLatYNotLike(String value) {
            addCriterion("LAT_Y not like", value, "latY");
            return (Criteria) this;
        }

        public Criteria andLatYIn(List<String> values) {
            addCriterion("LAT_Y in", values, "latY");
            return (Criteria) this;
        }

        public Criteria andLatYNotIn(List<String> values) {
            addCriterion("LAT_Y not in", values, "latY");
            return (Criteria) this;
        }

        public Criteria andLatYBetween(String value1, String value2) {
            addCriterion("LAT_Y between", value1, value2, "latY");
            return (Criteria) this;
        }

        public Criteria andLatYNotBetween(String value1, String value2) {
            addCriterion("LAT_Y not between", value1, value2, "latY");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(String value) {
            addCriterion("LEVEL =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(String value) {
            addCriterion("LEVEL <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(String value) {
            addCriterion("LEVEL >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(String value) {
            addCriterion("LEVEL >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(String value) {
            addCriterion("LEVEL <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(String value) {
            addCriterion("LEVEL <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLike(String value) {
            addCriterion("LEVEL like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotLike(String value) {
            addCriterion("LEVEL not like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<String> values) {
            addCriterion("LEVEL in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<String> values) {
            addCriterion("LEVEL not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(String value1, String value2) {
            addCriterion("LEVEL between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(String value1, String value2) {
            addCriterion("LEVEL not between", value1, value2, "level");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table bw_map_brand_entity
     *
     * @mbggenerated do_not_delete_during_merge Mon Apr 27 14:46:01 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table bw_map_brand_entity
     *
     * @mbggenerated Mon Apr 27 14:46:01 CST 2015
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