package com.testssm.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ArticleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public ArticleExample() {
        oredCriteria = new ArrayList<Criteria>();
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andContentidIsNull() {
            addCriterion("contentId is null");
            return (Criteria) this;
        }

        public Criteria andContentidIsNotNull() {
            addCriterion("contentId is not null");
            return (Criteria) this;
        }

        public Criteria andContentidEqualTo(Integer value) {
            addCriterion("contentId =", value, "contentid");
            return (Criteria) this;
        }

        public Criteria andContentidNotEqualTo(Integer value) {
            addCriterion("contentId <>", value, "contentid");
            return (Criteria) this;
        }

        public Criteria andContentidGreaterThan(Integer value) {
            addCriterion("contentId >", value, "contentid");
            return (Criteria) this;
        }

        public Criteria andContentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("contentId >=", value, "contentid");
            return (Criteria) this;
        }

        public Criteria andContentidLessThan(Integer value) {
            addCriterion("contentId <", value, "contentid");
            return (Criteria) this;
        }

        public Criteria andContentidLessThanOrEqualTo(Integer value) {
            addCriterion("contentId <=", value, "contentid");
            return (Criteria) this;
        }

        public Criteria andContentidIn(List<Integer> values) {
            addCriterion("contentId in", values, "contentid");
            return (Criteria) this;
        }

        public Criteria andContentidNotIn(List<Integer> values) {
            addCriterion("contentId not in", values, "contentid");
            return (Criteria) this;
        }

        public Criteria andContentidBetween(Integer value1, Integer value2) {
            addCriterion("contentId between", value1, value2, "contentid");
            return (Criteria) this;
        }

        public Criteria andContentidNotBetween(Integer value1, Integer value2) {
            addCriterion("contentId not between", value1, value2, "contentid");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andAbstrIsNull() {
            addCriterion("abstr is null");
            return (Criteria) this;
        }

        public Criteria andAbstrIsNotNull() {
            addCriterion("abstr is not null");
            return (Criteria) this;
        }

        public Criteria andAbstrEqualTo(String value) {
            addCriterion("abstr =", value, "abstr");
            return (Criteria) this;
        }

        public Criteria andAbstrNotEqualTo(String value) {
            addCriterion("abstr <>", value, "abstr");
            return (Criteria) this;
        }

        public Criteria andAbstrGreaterThan(String value) {
            addCriterion("abstr >", value, "abstr");
            return (Criteria) this;
        }

        public Criteria andAbstrGreaterThanOrEqualTo(String value) {
            addCriterion("abstr >=", value, "abstr");
            return (Criteria) this;
        }

        public Criteria andAbstrLessThan(String value) {
            addCriterion("abstr <", value, "abstr");
            return (Criteria) this;
        }

        public Criteria andAbstrLessThanOrEqualTo(String value) {
            addCriterion("abstr <=", value, "abstr");
            return (Criteria) this;
        }

        public Criteria andAbstrLike(String value) {
            addCriterion("abstr like", value, "abstr");
            return (Criteria) this;
        }

        public Criteria andAbstrNotLike(String value) {
            addCriterion("abstr not like", value, "abstr");
            return (Criteria) this;
        }

        public Criteria andAbstrIn(List<String> values) {
            addCriterion("abstr in", values, "abstr");
            return (Criteria) this;
        }

        public Criteria andAbstrNotIn(List<String> values) {
            addCriterion("abstr not in", values, "abstr");
            return (Criteria) this;
        }

        public Criteria andAbstrBetween(String value1, String value2) {
            addCriterion("abstr between", value1, value2, "abstr");
            return (Criteria) this;
        }

        public Criteria andAbstrNotBetween(String value1, String value2) {
            addCriterion("abstr not between", value1, value2, "abstr");
            return (Criteria) this;
        }

        public Criteria andCategoryidIsNull() {
            addCriterion("categoryId is null");
            return (Criteria) this;
        }

        public Criteria andCategoryidIsNotNull() {
            addCriterion("categoryId is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryidEqualTo(String value) {
            addCriterion("categoryId =", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidNotEqualTo(String value) {
            addCriterion("categoryId <>", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidGreaterThan(String value) {
            addCriterion("categoryId >", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidGreaterThanOrEqualTo(String value) {
            addCriterion("categoryId >=", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidLessThan(String value) {
            addCriterion("categoryId <", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidLessThanOrEqualTo(String value) {
            addCriterion("categoryId <=", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidLike(String value) {
            addCriterion("categoryId like", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidNotLike(String value) {
            addCriterion("categoryId not like", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidIn(List<String> values) {
            addCriterion("categoryId in", values, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidNotIn(List<String> values) {
            addCriterion("categoryId not in", values, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidBetween(String value1, String value2) {
            addCriterion("categoryId between", value1, value2, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidNotBetween(String value1, String value2) {
            addCriterion("categoryId not between", value1, value2, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryvalueIsNull() {
            addCriterion("categoryValue is null");
            return (Criteria) this;
        }

        public Criteria andCategoryvalueIsNotNull() {
            addCriterion("categoryValue is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryvalueEqualTo(String value) {
            addCriterion("categoryValue =", value, "categoryvalue");
            return (Criteria) this;
        }

        public Criteria andCategoryvalueNotEqualTo(String value) {
            addCriterion("categoryValue <>", value, "categoryvalue");
            return (Criteria) this;
        }

        public Criteria andCategoryvalueGreaterThan(String value) {
            addCriterion("categoryValue >", value, "categoryvalue");
            return (Criteria) this;
        }

        public Criteria andCategoryvalueGreaterThanOrEqualTo(String value) {
            addCriterion("categoryValue >=", value, "categoryvalue");
            return (Criteria) this;
        }

        public Criteria andCategoryvalueLessThan(String value) {
            addCriterion("categoryValue <", value, "categoryvalue");
            return (Criteria) this;
        }

        public Criteria andCategoryvalueLessThanOrEqualTo(String value) {
            addCriterion("categoryValue <=", value, "categoryvalue");
            return (Criteria) this;
        }

        public Criteria andCategoryvalueLike(String value) {
            addCriterion("categoryValue like", value, "categoryvalue");
            return (Criteria) this;
        }

        public Criteria andCategoryvalueNotLike(String value) {
            addCriterion("categoryValue not like", value, "categoryvalue");
            return (Criteria) this;
        }

        public Criteria andCategoryvalueIn(List<String> values) {
            addCriterion("categoryValue in", values, "categoryvalue");
            return (Criteria) this;
        }

        public Criteria andCategoryvalueNotIn(List<String> values) {
            addCriterion("categoryValue not in", values, "categoryvalue");
            return (Criteria) this;
        }

        public Criteria andCategoryvalueBetween(String value1, String value2) {
            addCriterion("categoryValue between", value1, value2, "categoryvalue");
            return (Criteria) this;
        }

        public Criteria andCategoryvalueNotBetween(String value1, String value2) {
            addCriterion("categoryValue not between", value1, value2, "categoryvalue");
            return (Criteria) this;
        }

        public Criteria andImgurlIsNull() {
            addCriterion("imgurl is null");
            return (Criteria) this;
        }

        public Criteria andImgurlIsNotNull() {
            addCriterion("imgurl is not null");
            return (Criteria) this;
        }

        public Criteria andImgurlEqualTo(String value) {
            addCriterion("imgurl =", value, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlNotEqualTo(String value) {
            addCriterion("imgurl <>", value, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlGreaterThan(String value) {
            addCriterion("imgurl >", value, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlGreaterThanOrEqualTo(String value) {
            addCriterion("imgurl >=", value, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlLessThan(String value) {
            addCriterion("imgurl <", value, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlLessThanOrEqualTo(String value) {
            addCriterion("imgurl <=", value, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlLike(String value) {
            addCriterion("imgurl like", value, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlNotLike(String value) {
            addCriterion("imgurl not like", value, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlIn(List<String> values) {
            addCriterion("imgurl in", values, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlNotIn(List<String> values) {
            addCriterion("imgurl not in", values, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlBetween(String value1, String value2) {
            addCriterion("imgurl between", value1, value2, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlNotBetween(String value1, String value2) {
            addCriterion("imgurl not between", value1, value2, "imgurl");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNull() {
            addCriterion("createDate is null");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNotNull() {
            addCriterion("createDate is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedateEqualTo(Date value) {
            addCriterionForJDBCDate("createDate =", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotEqualTo(Date value) {
            addCriterionForJDBCDate("createDate <>", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThan(Date value) {
            addCriterionForJDBCDate("createDate >", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("createDate >=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThan(Date value) {
            addCriterionForJDBCDate("createDate <", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("createDate <=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateIn(List<Date> values) {
            addCriterionForJDBCDate("createDate in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotIn(List<Date> values) {
            addCriterionForJDBCDate("createDate not in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("createDate between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("createDate not between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andTopIsNull() {
            addCriterion("`top` is null");
            return (Criteria) this;
        }

        public Criteria andTopIsNotNull() {
            addCriterion("`top` is not null");
            return (Criteria) this;
        }

        public Criteria andTopEqualTo(String value) {
            addCriterion("`top` =", value, "top");
            return (Criteria) this;
        }

        public Criteria andTopNotEqualTo(String value) {
            addCriterion("`top` <>", value, "top");
            return (Criteria) this;
        }

        public Criteria andTopGreaterThan(String value) {
            addCriterion("`top` >", value, "top");
            return (Criteria) this;
        }

        public Criteria andTopGreaterThanOrEqualTo(String value) {
            addCriterion("`top` >=", value, "top");
            return (Criteria) this;
        }

        public Criteria andTopLessThan(String value) {
            addCriterion("`top` <", value, "top");
            return (Criteria) this;
        }

        public Criteria andTopLessThanOrEqualTo(String value) {
            addCriterion("`top` <=", value, "top");
            return (Criteria) this;
        }

        public Criteria andTopLike(String value) {
            addCriterion("`top` like", value, "top");
            return (Criteria) this;
        }

        public Criteria andTopNotLike(String value) {
            addCriterion("`top` not like", value, "top");
            return (Criteria) this;
        }

        public Criteria andTopIn(List<String> values) {
            addCriterion("`top` in", values, "top");
            return (Criteria) this;
        }

        public Criteria andTopNotIn(List<String> values) {
            addCriterion("`top` not in", values, "top");
            return (Criteria) this;
        }

        public Criteria andTopBetween(String value1, String value2) {
            addCriterion("`top` between", value1, value2, "top");
            return (Criteria) this;
        }

        public Criteria andTopNotBetween(String value1, String value2) {
            addCriterion("`top` not between", value1, value2, "top");
            return (Criteria) this;
        }

        public Criteria andKeyIsNull() {
            addCriterion("`key` is null");
            return (Criteria) this;
        }

        public Criteria andKeyIsNotNull() {
            addCriterion("`key` is not null");
            return (Criteria) this;
        }

        public Criteria andKeyEqualTo(String value) {
            addCriterion("`key` =", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyNotEqualTo(String value) {
            addCriterion("`key` <>", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyGreaterThan(String value) {
            addCriterion("`key` >", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyGreaterThanOrEqualTo(String value) {
            addCriterion("`key` >=", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyLessThan(String value) {
            addCriterion("`key` <", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyLessThanOrEqualTo(String value) {
            addCriterion("`key` <=", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyLike(String value) {
            addCriterion("`key` like", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyNotLike(String value) {
            addCriterion("`key` not like", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyIn(List<String> values) {
            addCriterion("`key` in", values, "key");
            return (Criteria) this;
        }

        public Criteria andKeyNotIn(List<String> values) {
            addCriterion("`key` not in", values, "key");
            return (Criteria) this;
        }

        public Criteria andKeyBetween(String value1, String value2) {
            addCriterion("`key` between", value1, value2, "key");
            return (Criteria) this;
        }

        public Criteria andKeyNotBetween(String value1, String value2) {
            addCriterion("`key` not between", value1, value2, "key");
            return (Criteria) this;
        }

        public Criteria andKeyvalueIsNull() {
            addCriterion("keyValue is null");
            return (Criteria) this;
        }

        public Criteria andKeyvalueIsNotNull() {
            addCriterion("keyValue is not null");
            return (Criteria) this;
        }

        public Criteria andKeyvalueEqualTo(String value) {
            addCriterion("keyValue =", value, "keyvalue");
            return (Criteria) this;
        }

        public Criteria andKeyvalueNotEqualTo(String value) {
            addCriterion("keyValue <>", value, "keyvalue");
            return (Criteria) this;
        }

        public Criteria andKeyvalueGreaterThan(String value) {
            addCriterion("keyValue >", value, "keyvalue");
            return (Criteria) this;
        }

        public Criteria andKeyvalueGreaterThanOrEqualTo(String value) {
            addCriterion("keyValue >=", value, "keyvalue");
            return (Criteria) this;
        }

        public Criteria andKeyvalueLessThan(String value) {
            addCriterion("keyValue <", value, "keyvalue");
            return (Criteria) this;
        }

        public Criteria andKeyvalueLessThanOrEqualTo(String value) {
            addCriterion("keyValue <=", value, "keyvalue");
            return (Criteria) this;
        }

        public Criteria andKeyvalueLike(String value) {
            addCriterion("keyValue like", value, "keyvalue");
            return (Criteria) this;
        }

        public Criteria andKeyvalueNotLike(String value) {
            addCriterion("keyValue not like", value, "keyvalue");
            return (Criteria) this;
        }

        public Criteria andKeyvalueIn(List<String> values) {
            addCriterion("keyValue in", values, "keyvalue");
            return (Criteria) this;
        }

        public Criteria andKeyvalueNotIn(List<String> values) {
            addCriterion("keyValue not in", values, "keyvalue");
            return (Criteria) this;
        }

        public Criteria andKeyvalueBetween(String value1, String value2) {
            addCriterion("keyValue between", value1, value2, "keyvalue");
            return (Criteria) this;
        }

        public Criteria andKeyvalueNotBetween(String value1, String value2) {
            addCriterion("keyValue not between", value1, value2, "keyvalue");
            return (Criteria) this;
        }
    }

    /**
     */
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