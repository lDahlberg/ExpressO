angular.module('expressOApp').controller('newRecipeController', ['$scope', '$state', '$http', function($scope, $state, $http){
	$scope.ingredientList = [];
	
	$http.get('/ingredients').then(function(ingredientData){
		$scope.ingredients = ingredientData.data;
	});
	
	$scope.addIngredient = function(newIngredient){
		
		$scope.ingredientList.push(newIngredient);

	};
	
	$scope.submitRecipe = function(recipeData) {
		recipeData = {
			name: recipeData.name,
			instructions: recipeData.instructions,
			ingredient : $scope.ingredientList
		}
        console.log(recipeData);
		$http.post("recipes", recipeData)
		.success(function(data, status, headers, config){
	    	console.log("success"); 
	    	$state.go("recipeHome");
	    })
	    .error(function(data, status, headers, config){
	    	console.log("failure");
	    });
	}
}]);