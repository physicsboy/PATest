package com.pa.articles.articlestore.service;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.pa.articlestore.model.Article;
import com.pa.articlestore.util.JSONUtil;

@ApplicationScoped
@Alternative
public class ArticleServiceImpl implements ArticleService {

	private static final Logger LOGGER = Logger.getLogger(ArticleServiceImpl.class);
	private final int INITIAL_COUNT = 1;
	private Map<Integer, Article> articleMap;
	private int ID;

	@Inject
	private JSONUtil util;

	public ArticleServiceImpl() {
		this.articleMap = new HashMap<Integer, Article>();
		ID = INITIAL_COUNT;
		initArticleStore();
	}

	@Override
	public String getAllArticles() {
		return util.getJSONForObject(articleMap.values());
	}

	@Override
	public String addNewArticle(String articleJson) {
		ID++;
		Article newArticle = util.getObjectForJSON(articleJson, Article.class);
		LOGGER.info("In add article method about to add to map");
		articleMap.put(ID, newArticle);
		LOGGER.info("In add article method article added to map");
		return articleJson;
	}

	@Override
	public String replaceArticle(Integer articleId, String updatedArticle) {
		Article newArticle = util.getObjectForJSON(updatedArticle, Article.class);
		articleMap.put(articleId, newArticle);
		return updatedArticle;
	}

	@Override
	public String deleteArticle(Integer articleId) {
		LOGGER.info("In delete article method about to remove article");
		articleMap.remove(articleId);
		LOGGER.info("In delete article method article removed");
		return "{\"message\": \"article sucessfully removed\"}";
	}

	private void initArticleStore() {
		Article aArticle = new Article("Adam Highton", "The ever increasing price of football transfers", "Sport", "2017");
		articleMap.put(1, aArticle);
	}

}
