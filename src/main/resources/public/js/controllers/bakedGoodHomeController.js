angular.module('expressOApp').controller('bakedGoodHomeController', ['$scope', '$state', '$http','idService', function($scope, $state, $http, idService){
	$http.get('/bakedgoods').then(function(bakedGoodData){
		$scope.bakedGoods = bakedGoodData.data;
	});
	
	$scope.detailView = function(id) {
		idService.setId(id);
		$state.go("bakedGoodDetailView");
	}
}]);