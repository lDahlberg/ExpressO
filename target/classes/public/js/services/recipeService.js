//The following service retrieves the list of recipe from the server as a promise or a single 
//recipe by its corresponding id.
angular.module('expressOApp').factory("recipeService", ['$http','$q', function($http, $q){
	return {
		getRecipes : function() {
			var deferredRecipes = $q.defer();
			$http.get('/recipes').then(function(data) {
			    return deferredRecipes.resolve(data);
			});
			return deferredRecipes.promise;
		},
		getRecipeById : function(id) {
			var deferredRecipe = $q.defer();
			$http.get('/recipes/'+id).then(function(recipeData) {
			    return deferredRecipe.resolve(recipeData);
			   
			});
			return deferredRecipe.promise;
		}
	}
}]);