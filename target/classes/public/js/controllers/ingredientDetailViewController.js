angular.module('expressOApp').controller('ingredientDetailViewController', ['$scope', '$state', '$http','idService', function($scope, $state, $http, idService){
	
	var id = idService.getId();
	
	$http.get('/ingredients/'+id).then(function(ingredientData){
		console.log(ingredientData.data);
		$scope.ingredient = ingredientData.data;
	});
	
	$scope.deleteIngredient = function(id) {
		$http.delete('/ingredients/'+id)
		.success(function(response) {
			$state.go("ingredientHome");
		})
		.error(function(response){
			console.log("Failure");
		});
	};
}]);