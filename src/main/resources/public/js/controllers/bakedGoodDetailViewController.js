angular.module('expressOApp').controller('bakedGoodDetailViewController', ['$scope', '$state', '$http', function($scope, $state, $http){
	$http.get('/bakedgoods/1').then(function(bakedGoodData){
		console.log(bakedGoodData.data);
		$scope.bakedGoods = bakedGoodData.data;
	});
}]);