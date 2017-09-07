
var check = angular.module("myApp");

check.controller("updateController", function($scope,$http,$location,$log){
    $scope.heading = "Update Account";
    $scope.account ={};
    $scope.account.id = 0;
    $scope.account.firstName =   null;
    $scope.account.lastName = null;
    $scope.account.balance = null;

    $scope.updateAccount = function () {

        $http.put('/updateaccount?id='
            +$scope.account.id+'&firstName='+$scope.account.firstName+'&lastName='+$scope.account.lastName+'&balance='+$scope.account.balance)
            .success(function(){
                $location.url('/accounts');
            })
            .error(function(error){
                $log.debug("Error Updating Account");
            });

    }
});
