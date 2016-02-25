//Used with permission from blog.krusen.dk/angularjs-decimals-browsers
angular.module('expressOApp').directive("twoPrecision", function () {
	return {
        replace: false,
        restrict: 'A',
        link: function(scope, element) {
            var e = angular.element(element);
            e.on('keyup', function(){
                var n = parseFloat(e.val().toFixed(2));
            });
        }
    }
});