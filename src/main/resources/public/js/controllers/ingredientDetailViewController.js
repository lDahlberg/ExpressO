angular.module('expressOApp').controller('ingredientDetailViewController', ['$scope', '$state', '$http', function($scope, $state, $http){
	$http.get('/ingredients/1').then(function(ingredientData){
		console.log(ingredientData.data);
		$scope.ingredients = ingredientData.data;
	});
}]);