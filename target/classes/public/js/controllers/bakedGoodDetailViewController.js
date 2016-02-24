angular.module('expressOApp').controller('bakedGoodDetailViewController', ['$scope', '$state', '$http','idService', function($scope, $state, $http, idService){
	
	var id = idService.getId();
	
	$http.get('/bakedgoods/'+id).then(function(bakedGoodData){
		console.log(bakedGoodData.data);
		$scope.bakedGood = bakedGoodData.data;
	});
	
	$scope.deleteBakedGood = function(id) {
		$http.delete('/bakedgoods/'+id)
		.success(function(response) {
			$state.go("bakedGoodHome");
		})
		.error(function(response){
			console.log("Failure");
		});
	};
}]);