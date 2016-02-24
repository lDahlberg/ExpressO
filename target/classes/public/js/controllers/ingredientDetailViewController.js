angular.module('expressOApp').controller('ingredientDetailViewController', ['$scope', '$state', '$http','idService', function($scope, $state, $http, idService){
	
	var id = idService.getId();
	
	if (id < 0 ) {
		$state.go("ingredientHome");
	}
	
	$http.get('/ingredients/'+id).then(function(ingredientData){
		$scope.ingredient = ingredientData.data;
	});
	
	$scope.editing = false;
	
	$scope.saveIngredient = function(ingredient) {
		$http.put('/ingredients/'+id, ingredient)
		.success(function(response) {
			$state.go("ingredientHome");
		})
		.error(function(response){
			console.log("Failure");
		});
	};
	
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