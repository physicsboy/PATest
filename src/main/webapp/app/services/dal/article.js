"use strict";

(function () {

    angular.module("articleStore").service("articleDal", ["dal", ArticleDal]);

    function ArticleDal (dal) {

        this.getArticles = function () {
            return dal.http.GET("rest/articlestore/json");
        };

        this.saveArticle = function (articleToSave) {
            return dal.http.POST("rest/articlestore/json", articleToSave);
        };

        this.updateArticle = function (articleToUpdate) {
            return dal.http.PUT("rest/articlestore/json/", articleToUpdate);
        };

        this.deleteArticle = function (articleToDelete) {
            return dal.http.DELETE("/rest/articlestore/json/", articleToDelete);
        };

    }
}());
