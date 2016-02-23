angular.module('expressOApp').controller('bakedGoodHomeController', ['$scope', '$state', '$http', function($scope, $state, $http){
	$http.get('/bakedgoods').then(function(bakedGoodData){
		console.log(bakedGoodData.data);
		$scope.bakedGoods = bakedGoodData.data;
	});
}]);