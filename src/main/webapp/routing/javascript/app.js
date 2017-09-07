    var app = angular.module("myApp", ["ngRoute"]);
    app.config(function($routeProvider) {
        $routeProvider
            .when("/", {
                templateUrl : "index.html"

            })
            .when("/createaccount", {
                templateUrl : "CreateAccount.html",
                controller:"createAccountController"
            })
            .when("/findbalance", {
                templateUrl : "findbalance.html",
                controller:"findController"

            })
            .when("/updateaccount", {
                templateUrl : "updateaccount.html",
                controller:"updateController"

            })
            .when("/deleteaccount", {
                templateUrl : "deleteaccount.html",
                controller:"deleteController"

            })
            .when("/accounts", {
                templateUrl : "accounts.html",
                 controller:"accountListController"

            })

            .otherwise({
                templateUrl: 'error.html'
            });
    });
