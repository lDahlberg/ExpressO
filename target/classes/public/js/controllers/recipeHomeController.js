angular.module('expressOApp').controller('recipeHomeController', ['$scope', '$state', '$http','idService','recipeService', function($scope, $state, $http, idService, recipeService){
	
	recipeService.getRecipes().then(function(recipeData) {
		$scope.recipes = recipeData.data;
	});
	
	$scope.detailView = function(id) {
		idService.setId(id);
		$state.go("recipeDetailView");
	};
}]);