package com.testssm.dao;

import com.testssm.entity.Article;
import com.testssm.entity.ArticleExample;
import org.springframework.stereotype.Repository;

/**
 * ArticleDAO继承基类
 */
@Repository
public interface ArticleDAO extends MyBatisBaseDao<Article, Integer, ArticleExample> {
}