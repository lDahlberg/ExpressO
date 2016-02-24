angular.module('expressOApp').controller('bakedGoodDetailViewController', ['$scope', '$state', '$http','idService', function($scope, $state, $http, idService){
	
	var id = idService.getId();
	
	$http.get('/allergens').then(function(allergenData){
		$scope.allergens = allergenData.data;
	});
	
	$http.get('/categories').then(function(categoryData){
		$scope.categories = categoryData.data;
	});
	
	$http.get('/vendors').then(function(vendorData){
		$scope.vendors = vendorData.data;
	});
	
	$http.get('/bakedgoods/'+id).then(function(bakedGoodData){
		$scope.bakedGood = bakedGoodData.data;
		var bakedGoodId = bakedGoodData.data.vendor.vendorId - 1;
		var allergenId = bakedGoodData.data.allergen.allergenId - 1;
		var categoryId = bakedGoodData.data.category.categoryId - 1;
		$scope.bakedGood.vendor = $scope.vendors[bakedGoodId];
		$scope.bakedGood.allergen = $scope.allergens[allergenId];
		$scope.bakedGood.category = $scope.categories[categoryId];

	});
	
	$scope.editing = false;
	
	$scope.saveBakedGood = function(bakedGood) {
		$http.put('/bakedgoods/'+id, bakedGood)
		.success(function(response) {
			$state.go("bakedGoodHome");
		})
		.error(function(response){
			console.log("Failure");
		});
	};
	
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