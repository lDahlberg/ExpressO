//The following controller controls the list on the BakedGood Home page. 
angular.module('expressOApp').controller('bakedGoodHomeController', ['$scope', '$state', '$http','idService','bakedGoodService', function($scope, $state, $http, idService, bakedGoodService){
	
	bakedGoodService.getBakedGoods().then(function(bakedGoodData) {
		$scope.bakedGoods = bakedGoodData.data;
		angular.forEach($scope.bakedGoods, function(value,key){
			if (value.cost % 1 == 0 || value.cost % 1 == 0.5) {
				value.cost = value.cost.toFixed(2);
			}
		});
	});
	
	//If the user clicks on the link, this function takes them to the detail view
	// by sending the BakedGoodId to the service and then routing with the $state.go
	$scope.detailView = function(id) {
		idService.setId(id);
		$state.go("bakedGoodDetailView");
	}
}]);