angular.module('expressOApp').controller('recipeDetailViewController', ['$scope', '$state', '$http','idService', function($scope, $state, $http, idService){
	
	$scope.error = false;
	$scope.editing = false;
	
	var id = idService.getId();
	
	if (id < 0 ) {
		$state.go("recipeHome");
	}
	
	$scope.ingredientList = [];
	
	$http.get('/ingredients').then(function(ingredientData){
		$scope.ingredients = ingredientData.data;
	});
	
	$http.get('/recipes/'+id).then(function(recipeData){
		$scope.recipe = recipeData.data;
		$scope.ingredientList = recipeData.data.ingredient;

	});

	$scope.addIngredient = function(newIngredient){
		
		$scope.ingredientList.push(newIngredient);
		console.log($scope.ingredientList);

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