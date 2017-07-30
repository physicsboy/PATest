package com.pa.articles.articlestore.service;

public interface ArticleService {

	String getAllArticles();

	String addNewArticle(String articleJson);

	String replaceArticle(Integer articleId, String updatedArticle);

	String deleteArticle(Integer articleId);

}