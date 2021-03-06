//The following service retrieves the list of bakedGoods from the server as a promise or a single 
//bakedGood by its corresponding id.
angular.module('expressOApp').factory("bakedGoodService", ['$http','$q', function($http, $q){
	return {
		getBakedGoods : function() {
			var deferredBakedGood = $q.defer();
			$http.get('/bakedgoods').then(function(bakedGoodData) {
			    return deferredBakedGood.resolve(bakedGoodData);
			});
			return deferredBakedGood.promise;
		},
		getBakedGoodById : function(id) {
			var deferredBakedGood = $q.defer();
			$http.get('/bakedgoods/'+id).then(function(data) {
			    return deferredBakedGood.resolve(data);
			});
			return deferredBakedGood.promise;
		}
	}
}]);