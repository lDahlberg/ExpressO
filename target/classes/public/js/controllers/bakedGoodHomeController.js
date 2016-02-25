angular.module('expressOApp').controller('bakedGoodHomeController', ['$scope', '$state', '$http','idService','bakedGoodService', function($scope, $state, $http, idService, bakedGoodService){
	
	bakedGoodService.getBakedGoods().then(function(bakedGoodData) {
		$scope.bakedGoods = bakedGoodData.data;
	});
	
	$scope.detailView = function(id) {
		idService.setId(id);
		$state.go("bakedGoodDetailView");
	}
}]);