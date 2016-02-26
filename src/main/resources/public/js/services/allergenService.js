//The following service retrieves the list of allergens from the server as a promise.
angular.module('expressOApp').factory("allergenService", ['$http','$q', function($http, $q){
	return {
		getAllergens : function() {
			var deferredAllergen = $q.defer();
			$http.get('allergens').then(function(data) {
			    return deferredAllergen.resolve(data);
			});
			return deferredAllergen.promise;
		}
	}
}]);