//The New Ingredient Controller operates the addition of an Ingredient.
angular.module('expressOApp').controller('newIngredientController', ['$scope', '$state', '$http', function($scope, $state, $http){
	
	$scope.error = false;
	
	//When the user submits the Ingredient, it follows this post function
	//Upon success, user is routed to the Ingredient home page.
	$scope.submitIngredient = function(ingredientData) {
		$http.post("ingredients",ingredientData)
		.success(function(data, status, headers, config){
	    	$state.go("ingredientHome");
	    })
	    .error(function(data, status, headers, config){
	    	$scope.error = true;
	    });
	}	
}]);