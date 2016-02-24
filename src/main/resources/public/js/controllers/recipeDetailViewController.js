angular.module('expressOApp').controller('recipeDetailViewController', ['$scope', '$state', '$http','idService', function($scope, $state, $http, idService){
	
	$scope.editing = false;
	
	var id = idService.getId();
	$scope.ingredientList = [];
	
	$http.get('/ingredients').then(function(ingredientData){
		$scope.ingredients = ingredientData.data;
	});
	
	$http.get('/recipes/'+id).then(function(recipeData){
		console.log(recipeData.data);
		$scope.recipe = recipeData.data;
		$scope.ingredientList = recipeData.data.ingredient;
		console.log($scope.ingredientList);
	});

	$scope.addIngredient = function(newIngredient){
		
		$scope.ingredientList.push(newIngredient);
		console.log($scope.ingredientList);

	};
	
	$scope.saveRecipe = function(recipeData) {
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