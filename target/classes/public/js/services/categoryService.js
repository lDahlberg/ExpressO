//The following service retrieves the list of categories from the server as a promise.
angular.module('expressOApp').factory("categoryService", ['$http','$q', function($http, $q){
	return {
		getCategories : function() {
			var deferredCategory = $q.defer();
			$http.get('categories').then(function(data) {
			    return deferredCategory.resolve(data);
			});
			return deferredCategory.promise;
		}
	}
}]);