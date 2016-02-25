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