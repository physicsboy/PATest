package com.pa.articles.articlestore.service;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.pa.articlestore.model.Article;
import com.pa.articlestore.util.JSONUtil;

@Stateless
@Default
public class ArticleServiceDBImpl implements ArticleService {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Inject
	private JSONUtil util;

	@Override
	public String getAllArticles() {
		Query query = em.createQuery("SELECT e FROM ARTICLE e");
		Collection<Article> articles = (Collection<Article>) query.getResultList();
		return util.getJSONForObject(articles);
	}

	@Override
	public String addNewArticle(String articleJson) {
		Article newArticle = util.getObjectForJSON(articleJson, Article.class);
		em.persist(newArticle);
		return articleJson;
	}

	@Override
	public String replaceArticle(Integer articleId, String updatedArticle) {
		Article updateArticle = util.getObjectForJSON(updatedArticle, Article.class);
		Article article = findArticle(new Long(articleId));
		if (article != null) {
			article = updateArticle;
			em.merge(article);
		}
		return "{\"message\": \"article sucessfully updated\"}";
	}

	@Override
	public String deleteArticle(Integer articleId) {
		Article article = findArticle(new Long(articleId));
		if (article != null) {
			em.remove(article);
		}
		return "{\"message\": \"article sucessfully removed\"}";
	}

	private Article findArticle(Long id) {
		return em.find(Article.class, id);
	}

}
