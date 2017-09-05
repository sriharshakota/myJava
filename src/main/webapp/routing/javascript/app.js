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
                //controller:"samsungCtrl"

            })
            .when("/updateaccount", {
                templateUrl : "updateaccount.html",
               // controller:"lenovoCtrl"

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
