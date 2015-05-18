angular.module('superhelt.directive')
    .directive('superheltHeader', HeaderDirective);

function HeaderDirective() {
    return {
        restrict: 'AE',
        replace: 'true',
        scope: {},
        templateUrl: 'resources/views/header/header.html',
        link: function(scope, element, attrs, controller) {
        }
    };
}