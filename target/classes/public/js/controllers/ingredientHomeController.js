angular.module('expressOApp').controller('ingredientHomeController', ['$scope', '$state', '$http','idService','ingredientService', function($scope, $state, $http, idService, ingredientService){
	
	ingredientService.getIngredients().then(function(ingredientData) {
		$scope.ingredients = ingredientData.data;
	});
	
	$scope.detailView = function(id) {
		idService.setId(id);
		$state.go("ingredientDetailView");
	};
}]);