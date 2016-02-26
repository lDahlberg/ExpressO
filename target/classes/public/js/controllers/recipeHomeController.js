//The following controller controls the list on the Recipe Home page. 
angular.module('expressOApp').controller('recipeHomeController', ['$scope', '$state', '$http','idService','recipeService', function($scope, $state, $http, idService, recipeService){
	
	recipeService.getRecipes().then(function(recipeData) {
		$scope.recipes = recipeData.data;
	});
	
	//If the user clicks on the link, this function takes them to the detail view
	// by sending the recipeId to the service and then routing with the $state.go
	$scope.detailView = function(id) {
		idService.setId(id);
		$state.go("recipeDetailView");
	};
}]);