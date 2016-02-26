//The Recipe Detail View Controller operates the detail view, the delete and the editing functions of the Recipe.
angular.module('expressOApp').controller('recipeDetailViewController', ['$scope', '$state', '$http','idService','ingredientService','recipeService', function($scope, $state, $http, idService, ingredientService, recipeService){
	
	$scope.ingredientError = false;
	$scope.ingredientError2 = false;
	$scope.editing = false;
	$scope.ingredientList = [];
	$scope.ingredients = [];
	$scope.serverError = false;
	
	var id = idService.getId();
	
	//The following function obtains the recipes from the factory and then runs the list of ingredients
	//through a filter and cancels out those in the recipe so that only 1 of each ingredient shows 
	// in total on the detail page.
	recipeService.getRecipeById(id).then(function(recipeData) {
		$scope.recipe = recipeData.data;
		$scope.ingredientList = recipeData.data.ingredient;

		ingredientService.getIngredients().then(function(response) {
			$scope.ingredients = response.data;
			
			var checkArray = [];
			angular.forEach($scope.ingredients, function(value,key){
				angular.forEach($scope.ingredientList, function(value2, key2){
					if (angular.equals(value, value2)){
						checkArray.push(value);
					}
				})
			})
			$scope.ingredients = $scope.ingredients.filter(function(val) {
          	  return checkArray.indexOf(val) == -1;
			})
		});
	});
	
	//This function controls the addition of an ingredient to the recipe page by adding to ingredientList array
	// and removing the ingredient from the ingredients array.
	//If user tries to add null element, if statement catches the error and 
	// displays issue to user.
	$scope.addIngredient = function(newIngredient){
		if (newIngredient == null || newIngredient.length> 1){
			$scope.ingredientError2 = true;
		} else {
			$scope.ingredientError2 = false;
			$scope.ingredientList.push(newIngredient);
			var index = $scope.ingredients.indexOf(newIngredient);
			$scope.ingredients.splice(index, 1);
		}
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
	$scope.saveRecipe = function(recipeData) {
		if ($scope.ingredientList.length == 0) {
			$scope.error = true;
		} else {
			recipeData = {
				recipeId: id,
				name: recipeData.name,
				instructions: recipeData.instructions,
				ingredient : $scope.ingredientList
			}
			$http.put('/recipes/'+id, recipeData)
			.success(function(response) {
				$state.go("recipeHome");
			})
			.error(function(response){
				$scope.serverError = true;
			});
		}	
	};
	
	$scope.deleteRecipe = function(id) {
		$http.delete('/recipes/'+id)
		.success(function(response) {
			$state.go("recipeHome");
		})
		.error(function(response){
			$scope.serverError = true;
		});
	};
}]);