//The Ingredient Detail View Controller operates on both the detail view and the editing functions.
angular.module('expressOApp').controller('ingredientDetailViewController', ['$scope', '$state', '$http','idService','ingredientService', function($scope, $state, $http, idService, ingredientService){
	
	$scope.error = false;
	
	var id = idService.getId();
	
	//This scope sets whether or not the user is in edit mode.
	$scope.editing = false;
	
	ingredientService.getIngredientById(id).then(function(ingredientData) {
		$scope.ingredient = ingredientData.data;
		if ($scope.ingredient.cost % 1 == 0 || $scope.ingredient.cost % 1 == 0.5) {
			$scope.ingredient.cost = $scope.ingredient.cost.toFixed(2);
		}
	});
	
	//Following scope saves the Ingredient edits made by the user
	$scope.saveIngredient = function(ingredient) {
		$http.put('/ingredients/'+id, ingredient)
		.success(function(response) {
			$state.go("ingredientHome");
		})
		.error(function(response){
			$scope.error = true;
		});
	};
}]);