angular.module('expressOApp').controller('ingredientHomeController', ['$scope', '$state', '$http','idService', function($scope, $state, $http, idService){
	$http.get('/ingredients').then(function(ingredientData){
		console.log(ingredientData.data);
		$scope.ingredients = ingredientData.data;
	});
	
	$scope.detailView = function(id) {
		idService.setId(id);
		$state.go("ingredientDetailView");
	};
}]);