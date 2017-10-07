var baseURL = "http://localhost:8080/"
var cricketApp = angular.module("cricketApp", ['ngRoute']);

cricketApp.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl : "playerListing.html"
    })
    .when("/team", {
        templateUrl : "teamListing.html"
    });
});
