angular.module('expressOApp').factory("vendorService", ['$http','$q', function($http, $q){
	return {
		getVendors : function() {
			var deferredVendor = $q.defer();
			$http.get('vendors').then(function(data) {
				console.log(data);
			    return deferredVendor.resolve(data);
			});
			return deferredVendor.promise;
		}
	}
}]);