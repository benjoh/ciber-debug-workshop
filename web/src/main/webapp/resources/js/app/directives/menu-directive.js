angular.module('superhelt.directive')
    .directive('superheltMenu', MenuDirective);

function MenuDirective() {
    return {
        restrict: 'AE',
        replace: 'true',
        scope: {},
        templateUrl: 'resources/views/menu/menu.html'
    };
}