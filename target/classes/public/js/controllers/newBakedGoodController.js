angular.module('expressOApp').controller('newBakedGoodController', ['$scope', '$state', '$http', function($scope, $state, $http){
	
	$http.get('/allergens').then(function(allergenData){
		$scope.allergens = allergenData.data;
	});
	
	$http.get('/categories').then(function(categoryData){
		$scope.categories = categoryData.data;
	});
	
	$http.get('/vendors').then(function(vendorData){
		$scope.vendors = vendorData.data;
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