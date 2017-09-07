
var check = angular.module("myApp");

check.controller("findController", function($scope,$http,$location){
    $scope.heading = "Requried Account";
    $scope.account ={};
    $scope.account.id = 0;
    $scope.account.firstName =   null;
    $scope.account.lastName = null;
    $scope.check=false;
    $scope.findAccount = function () {

        $http.get('/findbalance?id='+$scope.account.id)
            .success(function(data){
                $scope.account = data;
                alert("Account id : "+data.id + "\nName : "+data.firstName + data.lastName + "\nBalance : "+data.balance);
                $location.url('/accounts');
            })

    }
});
