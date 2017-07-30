(function() {

    var ArticleController =  function(articleService)
    {
        var vm = this;
        
        vm.reverse =false;

        vm.doSort = function()
        {
            vm.sortby = 'Title';
            vm.reverse= !vm.reverse
        };

        function init() {
             articleService.getArticles().then(function (results) {
            	 console.log("In article controller about to return data to the client with results " + results);
            	 vm.article  = results;
             }, function (error) {
                 vm.error = true;
                 vm.errorMessage = error;
             });
        }
        
        init();
    };
    angular.module('articleStore').controller('ArticleController', ['articleService', ArticleController]);
}());