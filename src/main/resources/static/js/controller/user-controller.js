appYourPhysio.controller("userController", function($scope, $http){
	
	$scope.users = [];
	$scope.user = {};
	
	carregarUsuarios = function (){
		$http({method: "GET", url:"http://localhost:8080/users"})
		.then(function sucessCallback(response){
			$scope.users = response.data;
		}, function errorCallback(response){
			console.log(response.data);
			console.log(response.status);
		});
	};
	
	$scope.salvarUsuario = function (){
		$http({method: "POST", url:"http://localhost:8080/users", data: $scope.user})
		.then(function sucessCallback(response){
			//$scope.users.push(response.data);
			carregarUsuarios();
			$scope.cancelarAlteracaoUsuario();
		}, function errorCallback(response){
			console.log(response.data);
			console.log(response.status);
		});
	};
	
	$scope.excluirUsuario = function (user){
		$http({method: "DELETE", url:'http://localhost:8080/users/' + user.id})
		.then(function sucessCallback(response){
			pos = $scope.users.indexOf(user);
			$scope.users.splice(pos, 1);
		}, function errorCallback(response){
			console.log(response.data);
			console.log(response.status);
		});
	};
	
	$scope.alterarUsuario = function (user){
		$scope.user = angular.copy(user);
	};
	
	$scope.cancelarAlteracaoUsuario = function (){
		$scope.user = {};
	};
	
	carregarUsuarios();
	
});