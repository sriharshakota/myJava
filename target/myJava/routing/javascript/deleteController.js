
var app = angular.module("myApp");

app.controller("deleteController", function($scope,$http,$log,$location){
    $scope.heading = "Delete Account";
    $scope.account ={};

    $scope.delete = function () {
        console.log($scope.account.id);
        $http.delete('/deleteaccount?id='+$scope.account.id)
            .success(function(){
                $location.url('/accounts');
            })
            .error(function(error){
                $log.debug("Error Retriving Employee");
            });
    }
});
