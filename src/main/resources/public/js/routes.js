'use strict';
//angular routing information
angular.module('expressOApp').config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){

	$urlRouterProvider.otherwise('/');

	$stateProvider
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
		.state("bakedGoodHome.newBakedGood", {
			url: '/newBakedGood',
			templateUrl: 'template/newBakedGood.html',
			controller: 'newBakedGoodController'
		})
		.state("ingredientHome.newIngredient", {
			url: '/newIngredient',
			templateUrl: 'template/newIngredient.html',
			controller: 'newIngredientController'
		});
}]);