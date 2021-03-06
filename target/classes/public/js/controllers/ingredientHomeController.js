//The following controller controls the list on the Ingredient Home page. 
angular.module('expressOApp').controller('ingredientHomeController', ['$scope', '$state', '$http','idService','ingredientService', function($scope, $state, $http, idService, ingredientService){
	
	//Function grabs ingredients and adds cent to cost for display purposes.
	ingredientService.getIngredients().then(function(ingredientData) {
		$scope.ingredients = ingredientData.data;
		angular.forEach($scope.ingredients, function(value,key){
			if (value.cost % 1 == 0 || value.cost % 1 == 0.5) {
				value.cost = value.cost.toFixed(2);
			}
		});
	});
	
	//If the user clicks on the link, this function takes them to the detail view
	// by sending the ingredientId to the service and then routing with the $state.go
	$scope.detailView = function(id) {
		idService.setId(id);
		$state.go("ingredientDetailView");
	};
}]);