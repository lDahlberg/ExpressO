//The New Recipe Controller operates the addition of an Recipe.
angular.module('expressOApp').controller('newRecipeController', ['$scope', '$state', '$http','ingredientService', function($scope, $state, $http, ingredientService){
	
	$scope.ingredientList = [];
	$scope.ingredients = [];
	$scope.error = false;
	
	//this function calls Ingredient service for ingredients to include in new Recipe.
	ingredientService.getIngredients().then(function(ingredientData) {
		$scope.ingredients = ingredientData.data;
	});
	
	//This function controls the addition of an ingredient to the recipe page by adding to ingredientList array
	// and removing the ingredient from the ingredients array.
	$scope.addIngredient = function(newIngredient){
		
		$scope.ingredientList.push(newIngredient);
		var index = $scope.ingredients.indexOf(newIngredient);
		$scope.ingredients.splice(index, 1);

	};
	
	//This function controls the removal of an ingredient on the recipe page by removing it from
	// ingredientsList array and adding it back to ingredients array.
	$scope.removeIngredient = function(ingredient){
		
		var index = $scope.ingredientList.indexOf(ingredient);
		$scope.ingredientList.splice(index, 1);
		$scope.ingredients.push(ingredient);

	};
	
	//When the user submits the Recipe, it follows this post function
	//Upon success, user is routed to the Recipe home page.
	$scope.submitRecipe = function(recipeData) {
		if ($scope.ingredientList.length == 0) {
			$scope.error = true;
		} else {
			recipeData = {
				name: recipeData.name,
				instructions: recipeData.instructions,
				ingredient : $scope.ingredientList
			}
			$http.post("recipes", recipeData)
			.success(function(data, status, headers, config){
			   	$state.go("recipeHome");
			})
			.error(function(data, status, headers, config){
			   	console.log("failure");
			});
		}
		
	}
}]);