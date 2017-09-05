
var app = angular.module("myApp");

app.controller("createAccountController", function($scope,$http,$log,$location){
    $scope.heading = "Create Account";
    $scope.account ={};
    $scope.account.id = 0;
    $scope.account.fName =   null;
    $scope.account.lName = null;
    $scope.createAccount = function () {

        $http.post('/createAccount?firstName='
            +$scope.account.fName+'&lastName='+$scope.account.lName+'&balance='+$scope.account.balance)
            .success(function(){
                $location.url('/accounts');
            })
            .error(function(error){
                $log.debug("Error Retriving Employee");
            });
    }
});
