angular.module('expressOApp').controller('newBakedGoodController', ['$scope', '$state', '$http','allergenService','categoryService','vendorService', function($scope, $state, $http, allergenService, categoryService, vendorService){
	
	allergenService.getAllergens().then(function(response) {
		$scope.allergens = response.data;
	});
	
	categoryService.getCategories().then(function(response) {
		$scope.categories = response.data;
	});
	
	vendorService.getVendors().then(function(response) {
		$scope.vendors = response.data;
	});
	
	$scope.submitBakedGood = function(bakedGoodData) {
		$http.post("bakedgoods", bakedGoodData)
		.success(function(data, status, headers, config){
	    	$state.go("bakedGoodHome");
	    })
	    .error(function(data, status, headers, config){
	    	console.log("failure");
	    });
	}	
}]);