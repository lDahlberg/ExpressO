//The following service retrieves the list of ingredients from the server as a promise or a single 
//ingredient by its corresponding id.
angular.module('expressOApp').factory("ingredientService", ['$http','$q', function($http, $q){
	return {
		getIngredients : function() {
			var deferredIngredient = $q.defer();
			$http.get('/ingredients').then(function(ingredientData) {
			    return deferredIngredient.resolve(ingredientData);
			});
			return deferredIngredient.promise;
		},
		getIngredientById : function(id) {
			var deferredIngredient = $q.defer();
			$http.get('/ingredients/'+id).then(function(ingredientData) {
			    return deferredIngredient.resolve(ingredientData);
			   
			});
			return deferredIngredient.promise;
		}
	}
}]);