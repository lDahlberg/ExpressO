angular.module('expressOApp').controller('recipeHomeController', ['$scope', '$state', '$http','idService', function($scope, $state, $http, idService){
	$http.get('/recipes').then(function(recipeData){
		$scope.recipes = recipeData.data;
	});
	
	$scope.detailView = function(id) {
		idService.setId(id);
		$state.go("recipeDetailView");
	};
}]);