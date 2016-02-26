//The following service retrieves the list of vendors from the server as a promise.
angular.module('expressOApp').factory("vendorService", ['$http','$q', function($http, $q){
	return {
		getVendors : function() {
			var deferredVendor = $q.defer();
			$http.get('vendors').then(function(data) {
			    return deferredVendor.resolve(data);
			});
			return deferredVendor.promise;
		}
	}
}]);