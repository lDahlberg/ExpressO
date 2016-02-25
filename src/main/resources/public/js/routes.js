'use strict';
//angular routing information
angular.module('expressOApp').config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){

	$urlRouterProvider.otherwise('/recipeHome');

	$stateProvider
		.state("recipeHome", {
			url: '/recipeHome',
			templateUrl: 'template/recipeHome.html',
			controller: 'recipeHomeController',
			resolve: {
				getRecipes: function(recipeService) {
					return recipeService.getRecipes();
				}
			}
		
		})
		.state("bakedGoodHome", {
			url: '/bakedGoodHome',
			templateUrl: 'template/bakedGoodHome.html',
			controller: 'bakedGoodHomeController',
			resolve: {
				getBakedGoods: function(bakedGoodService) {
					return bakedGoodService.getBakedGoods();
				}
			}	
		})
		.state("ingredientHome", {
			url: '/ingredientHome',
			templateUrl: 'template/ingredientHome.html',
			controller: 'ingredientHomeController',
			resolve: {
				getIngredients: function(ingredientService) {
					return ingredientService.getIngredients();
				}
			}
		})
		.state("newRecipe", {
			url: '/newRecipe',
			templateUrl: 'template/newRecipe.html',
			controller: 'newRecipeController',
			resolve: {
				getIngredients: function(ingredientService) {
					return ingredientService.getIngredients();
				}
			}
		})
		.state("newBakedGood", {
			url: '/newBakedGood',
			templateUrl: 'template/newBakedGood.html',
			controller: 'newBakedGoodController',
			resolve: {
				getVendors: function(vendorService) {
					return vendorService.getVendors();
				},
				getCategories: function(categoryService) {
					return categoryService.getCategories();
				},
				getAllergens: function(allergenService) {
					return allergenService.getAllergens();
				},
			}
		})
		.state("newIngredient", {
			url: '/newIngredient',
			templateUrl: 'template/newIngredient.html',
			controller: 'newIngredientController'
		})
		.state("bakedGoodDetailView", {
			url: '/bakedGoodDetail',
			templateUrl: 'template/bakedGoodDetailView.html',
			controller: 'bakedGoodDetailViewController',
			resolve: {
				redirect: function($location, idService) {
					if(idService.getId() < 0 ){
						$location.path('/bakedGoodHome')
					} 
				},
				getVendors: function(vendorService) {
					return vendorService.getVendors();
				},
				getCategories: function(categoryService) {
					return categoryService.getCategories();
				},
				getAllergens: function(allergenService) {
					return allergenService.getAllergens();
				},
				getBakedGoodById: function(bakedGoodService, idService) {
					return bakedGoodService.getBakedGoodById(idService.getId());
				}
			}
		})
		.state("ingredientDetailView", {
			url: '/ingredientDetail',
			templateUrl: 'template/ingredientDetailView.html',
			controller: 'ingredientDetailViewController',
			resolve: {
				redirect: function($location, idService) {
					if(idService.getId() < 0 ){
						$location.path('/ingredientHome')
					} 
				},
				getIngredientById: function(ingredientService, idService) {
					return ingredientService.getIngredientById(idService.getId());
				}
			}
		})
		.state("recipeDetailView", {
			url: '/recipeDetail',
			templateUrl: 'template/recipeDetailView.html',
			controller: 'recipeDetailViewController',
			resolve: {
				redirect: function($location, idService) {
					if(idService.getId() < 0 ){
						$location.path('/recipeHome');
					} 
				},
				getIngredients: function(ingredientService) {
					return ingredientService.getIngredients();
				},
				getRecipeById: function(recipeService, idService) {
					return recipeService.getRecipeById(idService.getId());
				}
			}
		});
	
}]);