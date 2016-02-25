angular.module('expressOApp').controller('recipeDetailViewController', ['$scope', '$state', '$http','idService','ingredientService','recipeService', function($scope, $state, $http, idService, ingredientService, recipeService){
	
	$scope.error = false;
	$scope.editing = false;
	$scope.ingredientList = [];
	$scope.ingredients = [];
	
	var id = idService.getId();
	
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
	
	$scope.addIngredient = function(newIngredient){
		
		$scope.ingredientList.push(newIngredient);
		var index = $scope.ingredients.indexOf(newIngredient);
		$scope.ingredients.splice(index, 1);

	};
	
	$scope.removeIngredient = function(ingredient){
		
		var index = $scope.ingredientList.indexOf(ingredient);
		$scope.ingredientList.splice(index, 1);
		$scope.ingredients.push(ingredient);

	};
	
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
				console.log("Failure");
			});
		}	
	};
	
	$scope.deleteRecipe = function(id) {
		$http.delete('/recipes/'+id)
		.success(function(response) {
			$state.go("recipeHome");
		})
		.error(function(response){
			console.log("Failure");
		});
	};
}]);