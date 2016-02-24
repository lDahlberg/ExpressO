angular.module('expressOApp').controller('newRecipeController', ['$scope', '$state', '$http', function($scope, $state, $http){
	
	$scope.ingredientList = [];
	$scope.error = false;
	
	$http.get('/ingredients').then(function(ingredientData){
		$scope.ingredients = ingredientData.data;
	});
	
	$scope.addIngredient = function(newIngredient){
		
		$scope.ingredientList.push(newIngredient);

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