angular.module('expressOApp').controller('bakedGoodHomeController', ['$scope', '$state', '$http', function($scope, $state, $http){
	$http.get('/allergens').then(function(data){
		console.log(data);
	});
	
	$http.get('/categories').then(function(data){
		console.log(data);
	});
	
	$http.get('/vendors').then(function(data){
		console.log(data);
	});
}]);