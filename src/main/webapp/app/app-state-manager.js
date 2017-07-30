"use strict";

(function () {

    angular.module('articleStore').config(function ($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise("/article");

        $stateProvider.state("article", {
            url: "/article",
            templateUrl: "app/feature/article/articles.html"
        }).state("dashboard", {
                url: "/dashboard",
                templateUrl: "app/feature/dashboard/dashboard.html"
        })
    });
}());