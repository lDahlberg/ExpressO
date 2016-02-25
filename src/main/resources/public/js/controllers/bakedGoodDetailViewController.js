angular.module('expressOApp').controller('bakedGoodDetailViewController', ['$scope', '$state', '$http', 'idService','allergenService','bakedGoodService','categoryService','vendorService', function($scope, $state, $http, idService, allergenService, bakedGoodService, categoryService, vendorService){
	
	var id = idService.getId();
	
	allergenService.getAllergens().then(function(response) {
		$scope.allergens = response.data;
	});
	
	categoryService.getCategories().then(function(response) {
		$scope.categories = response.data;
	});
	
	vendorService.getVendors().then(function(response) {
		$scope.vendors = response.data;
	});
	
	bakedGoodService.getBakedGoodById(id).then(function(bakedGoodData){
		$scope.bakedGood = bakedGoodData.data;
		var bakedGoodId = $scope.bakedGood.vendor.vendorId - 1;
		var allergenId = $scope.bakedGood.allergen.allergenId - 1;
		var categoryId = $scope.bakedGood.category.categoryId - 1;
		$scope.bakedGood.vendor = $scope.vendors[bakedGoodId];
		$scope.bakedGood.allergen = $scope.allergens[allergenId];
		$scope.bakedGood.category = $scope.categories[categoryId];
		
	});

	
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