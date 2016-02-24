'use strict';
//angular routing information
angular.module('expressOApp').config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){

	$urlRouterProvider.otherwise('/recipeHome');

	$stateProvider
		.state("recipeHome", {
			url: '/recipeHome',
			templateUrl: 'template/recipeHome.html',
			controller: 'recipeHomeController'
		})
		.state("bakedGoodHome", {
			url: '/bakedGoodHome',
			templateUrl: 'template/bakedGoodHome.html',
			controller: 'bakedGoodHomeController'
		})
		.state("ingredientHome", {
			url: '/ingredientHome',
			templateUrl: 'template/ingredientHome.html',
			controller: 'ingredientHomeController'
		})
		.state("newRecipe", {
			url: '/newRecipe',
			templateUrl: 'template/newRecipe.html',
			controller: 'newRecipeController',
		})
		.state("newBakedGood", {
			url: '/newBakedGood',
			templateUrl: 'template/newBakedGood.html',
			controller: 'newBakedGoodController',
		})
		.state("newIngredient", {
			url: '/newIngredient',
			templateUrl: 'template/newIngredient.html',
			controller: 'newIngredientController'
		})
		.state("bakedGoodDetailView", {
			url: '/bakedGoodDetail',
			templateUrl: 'template/bakedGoodDetailView.html',
			controller: 'bakedGoodDetailViewController'
		})
		.state("ingredientDetailView", {
			url: '/ingredientDetail',
			templateUrl: 'template/ingredientDetailView.html',
			controller: 'ingredientDetailViewController'
		})
		.state("recipeDetailView", {
			url: '/recipeDetail',
			templateUrl: 'template/recipeDetailView.html',
			controller: 'recipeDetailViewController'
		});
	
}]);