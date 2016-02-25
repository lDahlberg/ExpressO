angular.module('expressOApp').controller('newRecipeController', ['$scope', '$state', '$http','ingredientService', function($scope, $state, $http, ingredientService){
	
	$scope.ingredientList = [];
	$scope.ingredients = [];
	$scope.error = false;
	
	ingredientService.getIngredients().then(function(ingredientData) {
		$scope.ingredients = ingredientData.data;
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