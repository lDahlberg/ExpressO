angular.module('expressOApp').controller('newIngredientController', ['$scope', '$state', '$http', function($scope, $state, $http){
	$scope.submitIngredient = function(ingredientData) {
        console.log(ingredientData);
		$http.post("ingredients",ingredientData)
		.success(function(data, status, headers, config){
	    	$state.go("ingredientHome");
	    })
	    .error(function(data, status, headers, config){
	    	console.log("failure");
	    });
	}	
}]);