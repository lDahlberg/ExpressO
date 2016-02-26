angular.module('expressOApp').controller('ingredientDetailViewController', ['$scope', '$state', '$http','idService','ingredientService', function($scope, $state, $http, idService, ingredientService){
	
	var id = idService.getId();
	
	$scope.editing = false;
	
	ingredientService.getIngredientById(id).then(function(ingredientData) {
		$scope.ingredient = ingredientData.data;
	});
	
	$scope.saveIngredient = function(ingredient) {
		$http.put('/ingredients/'+id, ingredient)
		.success(function(response) {
			$state.go("ingredientHome");
		})
		.error(function(response){
			console.log("Failure");
		});
	};
}]);