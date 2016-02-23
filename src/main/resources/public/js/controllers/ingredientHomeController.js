angular.module('expressOApp').controller('ingredientHomeController', ['$scope', '$state', '$http', function($scope, $state, $http){
	$http.get('/ingredients').then(function(ingredientData){
		console.log(ingredientData.data);
		$scope.ingredients = ingredientData.data;
	});
}]);