package com.pa.articles.articlestore.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.pa.articles.articlestore.service.ArticleService;

@Path("/articlestore")
public class ArticleEndPoint {

	@Inject
	private ArticleService articleService;

	@GET
	@Path("/json")
	@Produces({ "application/json" })
	public String getarticlesAsJson() {
		return articleService.getAllArticles();
	}

	@POST
	@Path("/json")
	@Produces({ "application/json" })
	public String addNewarticleToMap(String articleJson) {
		return articleService.addNewArticle(articleJson);
	}

	@PUT
	@Path("/json/{id}")
	@Produces({ "application/json" })
	public String replacearticleFromarticleStore(@PathParam("id") Integer id, String articleJson) {
		return articleService.replaceArticle(id, articleJson);
	}

	@DELETE
	@Path("/json/{id}")
	@Produces({ "application/json" })
	public String deletearticleFromarticleStore(@PathParam("id") Integer id) {
		return articleService.deleteArticle(id);
	}

}
