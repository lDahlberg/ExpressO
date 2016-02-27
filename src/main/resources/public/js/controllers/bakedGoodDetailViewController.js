//The bakedGoodDetail View Controller operates the detail view, the delete and the editing functions.
angular.module('expressOApp').controller('bakedGoodDetailViewController', ['$scope', '$state', '$http', 'idService','allergenService','bakedGoodService','categoryService','vendorService', function($scope, $state, $http, idService, allergenService, bakedGoodService, categoryService, vendorService){
	
	$scope.error = false;
	var id = idService.getId();
	
	//Following 3 functions call their respective factories
	allergenService.getAllergens().then(function(response) {
		$scope.allergens = response.data;
	});
	
	categoryService.getCategories().then(function(response) {
		$scope.categories = response.data;
	});
	
	vendorService.getVendors().then(function(response) {
		$scope.vendors = response.data;
	});
	
	//This function calls its respective factory and then sets the vendor, allergen, and category
	// so that, when the user goes to edit, the select boxes will be set properly. 
	bakedGoodService.getBakedGoodById(id).then(function(bakedGoodData){
		$scope.bakedGood = bakedGoodData.data;
		var bakedGoodId = $scope.bakedGood.vendor.vendorId - 1;
		var allergenId = $scope.bakedGood.allergen.allergenId - 1;
		var categoryId = $scope.bakedGood.category.categoryId - 1;
		$scope.bakedGood.vendor = $scope.vendors[bakedGoodId];
		$scope.bakedGood.allergen = $scope.allergens[allergenId];
		$scope.bakedGood.category = $scope.categories[categoryId];
		if ($scope.bakedGood.cost % 1 == 0 || $scope.bakedGood.cost % 1 == 0.5) {
			$scope.bakedGood.cost = $scope.bakedGood.cost.toFixed(2);
		}
	});

	//Following scope saves the BakedGood edits made by the user
	$scope.saveBakedGood = function(bakedGood) {
		$http.put('/bakedgoods/'+id, bakedGood)
		.success(function(response) {
			$state.go("bakedGoodHome");
		})
		.error(function(response){
			$scope.error = true;
		});
	};
	
	//Following scope deletes the BakedGood. Only available in the Detail View.
	$scope.deleteBakedGood = function(id) {
		$http.delete('/bakedgoods/'+id)
		.success(function(response) {
			$state.go("bakedGoodHome");
		})
		.error(function(response){
			$scope.error = true;
		});
	};
}]);