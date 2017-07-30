(function() {

    var ArticleService =  function(articleDal) {
        
    	this.getArticles = function()
        {
            return articleDal.getArticles();
        };
    };

    angular.module('articleStore').service('articleService', ['articleDal', ArticleService]);
}());