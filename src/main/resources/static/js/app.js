var appYourPhysio = angular.module("appYourPhysio",[]);

appYourPhysio.controller("indexController", function($scope, $http){
	
	$scope.name = "Paulo";
	$scope.users = [];
	
	$http({method: "GET", url:"http://localhost:8080/users"}).then(function sucessCallback(response){
		$scope.users = response.data;
		console.log(response.data);
		console.log(response.status);
		
	}, function errorCallback(response){
		
		console.log(response.data);
		console.log(response.status);
		
	})
	
});