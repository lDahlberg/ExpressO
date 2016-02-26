//The Ingredient Detail View Controller operates on both the detail view and the editing functions.
angular.module('expressOApp').controller('ingredientDetailViewController', ['$scope', '$state', '$http','idService','ingredientService', function($scope, $state, $http, idService, ingredientService){
	
	var id = idService.getId();
	
	//This scope sets whether or not the user is in edit mode.
	$scope.editing = false;
	
	ingredientService.getIngredientById(id).then(function(ingredientData) {
		$scope.ingredient = ingredientData.data;
	});
	
	//Following scope saves the Ingredient edits made by the user
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