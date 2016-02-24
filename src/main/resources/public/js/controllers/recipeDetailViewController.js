angular.module('expressOApp').controller('recipeDetailViewController', ['$scope', '$state', '$http','idService', function($scope, $state, $http, idService){
	
	var id = idService.getId();
	
	$http.get('/recipes/'+id).then(function(recipeData){
		console.log(recipeData.data);
		$scope.recipe = recipeData.data;
	});
	
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