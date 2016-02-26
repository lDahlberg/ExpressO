//The new Baked Good Controller operates the addition of a Baked Good.
angular.module('expressOApp').controller('newBakedGoodController', ['$scope', '$state', '$http','allergenService','categoryService','vendorService', function($scope, $state, $http, allergenService, categoryService, vendorService){
	
	$scope.error = false;
	
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
	
	//When the user submits the BakedGood, it follows this post function
	//Upon success, user is routed to the BakedGood home page.
	$scope.submitBakedGood = function(bakedGoodData) {
		$http.post("bakedgoods", bakedGoodData)
		.success(function(data, status, headers, config){
	    	$state.go("bakedGoodHome");
	    })
	    .error(function(data, status, headers, config){
	    	$scope.error = true;
	    });
	}	
}]);