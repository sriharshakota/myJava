
var check = angular.module("myApp");

check.controller("accountListController", function($scope,$http,$log,$location){
    $scope.heading = "Account List";
    $scope.accounts =[];
    $scope.account ={};
    $scope.account.id = 0;
    $scope.account.fName =   null;
    $scope.account.lName = null;
    $scope.createAccount = function () {




        $http.get('/accountsList')
            .success(function(data){
                $scope.accounts = data;
            })
            .error(function(error){
                $log.debug("Error Retriving Employee");
            });
    }
    $scope.createAccount();
});
